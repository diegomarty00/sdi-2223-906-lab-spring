package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorsService;
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

    @RequestMapping("/professor/list/update")
    public String updateList(Model model){
        model.addAttribute("professorList", professorsService.getProfessors());
        return "professor/list :: tableProfessors";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor, BindingResult result) {
        professorValidator.validate(professor,result);
        if(result.hasErrors()){
            return "professor/add";
        }

        professorsService.addProfessor(professor);
        return "redirect:/professor/list";
    }
    @RequestMapping(value = "/professor/add")
    public String getProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }

    @RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Professor professor, BindingResult result,
                          @PathVariable Long id){
        professorValidator.validate(professor,result);
        if(result.hasErrors()){
            return "professor/edit";
        }
        professorsService.addProfessor(professor);
        return "redirect:/professor/details/"+id;
    }
    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("professor",professorsService.getProfessor(id));
        return "professor/edit";
    }

    @RequestMapping("/professor/details/{id}")
    public String detailsProfessor(Model model, @PathVariable Long id){
        model.addAttribute("professor",professorsService.getProfessor(id));
        return "/professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorsService.deleteProfessor(id);
        return "redirect:/professor/list";
    }

}