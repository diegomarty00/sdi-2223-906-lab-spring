package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor){
        professorsService.addProfessor(professor);
        return "Professor added";
    }
    @RequestMapping(value = "/professor/add")
    public String getProfessor() {
        return "professor/add";
    }

    @RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
    public String getEdit(@ModelAttribute Professor professor, @PathVariable Long id){
        professor.setId(id);
        professorsService.editProfessor(id, professor);
        return "Professor edited";
    }
    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/edit";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        if (professorsService.getProfessor(id) != null){
            return professorsService.getProfessor(id).toString();
        }
        return "No professor with such id";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorsService.deleteProfessor(id);
        return "Professor deleted";
    }

}