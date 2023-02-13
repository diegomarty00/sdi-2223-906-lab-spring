package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

    private List<Professor> professorList = new ArrayList<>();


    public void addProfessor(Professor professor) {
        professorList.add(professor);
    }

    public void deleteProfessor(Long id) {
        professorList.removeIf(p -> p.getId().equals(id));
    }

    public Professor getProfessor(Long id) {
        return professorList.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public List<Professor> getProfessor() {
        List<Professor> list = new ArrayList<Professor>();
        for (Professor p : professorList)
            list.add(p);
        return list;
    }

    public void editProfessor(Long id, Professor professor) {
        for (Professor p : professorList) {
            if (p.getId().equals(id)) {
                if (p.getDni() != null)
                    p.setDni(professor.getDni());
                if (p.getName() != null)
                    p.setName(professor.getName());
                if (p.getSurname() != null)
                    p.setDni(professor.getSurname());
                if (p.getCategoria() != null)
                    p.setCategoria(professor.getCategoria());
            }

        }
    }
}