package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.services.ProfessorsService;
import com.uniovi.notaneitor.validators.MarkValidator;
import com.uniovi.notaneitor.validators.ProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;
    @Autowired
    private ProfessorValidator professorValidator;
    @RequestMapping("/professor/list")
    public String getList(Model model) {
        model.addAttribute("professorList", professorsService.getProfessor());
        return "professor/list";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@Validated Professor professor, BindingResult result){
        professorValidator.validate(professor, result);
        if (result.hasErrors()) {
            return "professor/add";
        }
        professorsService.addProfessor(professor);

        return "redirect:/professor/list";
    }
    @RequestMapping(value = "/professor/add")
    public String getProfessor() {
        return "professor/add";
    }

    @RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
    public String getEdit(@Validated Professor professor, @PathVariable Long id,
                          BindingResult result) {
        professor.setId(id);
        professorValidator.validate(professor, result);
        if (result.hasErrors()) {
            return "professor/edit/" + id;
        }
        professorsService.editProfessor(id, professor);
        return "redirect:/professor/details/"+id;
    }
    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/edit";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorsService.deleteProfessor(id);
        return "redirect:/professor/list";
    }

}