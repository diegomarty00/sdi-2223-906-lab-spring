package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

    @Autowired
    private ProfessorsRepository professorsRepository;

    public List<Professor> getProfessors(){
        List<Professor> professors = new ArrayList<>();
        professorsRepository.findAll().forEach(professors::add);
        return professors;
    }

    public List<Professor> getProfessor(){
        List<Professor> professors = new ArrayList<>();
        professorsRepository.findAll().forEach(professors::add);
        return professors;
    }
    public Professor getProfessor(Long id){
        return professorsRepository.findById(id).get();
    }

    public void addProfessor(Professor prof){
        professorsRepository.save(prof);
    }

    public void deleteProfessor(Long id){
        professorsRepository.deleteById(id);
    }

    public Professor getProffesorByDni(String dni){
        return professorsRepository.getProfessorByDni(dni);
    }

    public void addProffesor(Professor professor) {
        professorsRepository.save(professor);
    }
}