package ufcg.psoft.lab2.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufcg.psoft.lab2.DTOs.DisciplinaDTO;
import ufcg.psoft.lab2.DTOs.DisciplinaDTO2;
import ufcg.psoft.lab2.DTOs.DisciplinaDTO3;
import ufcg.psoft.lab2.entities.Disciplina;
import ufcg.psoft.lab2.repository.DisciplinaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaService {

    private int id = 0;

    @Autowired
    private DisciplinaRepository<Disciplina, Long> disciplinaDAO;

    public List<DisciplinaDTO2> getDisciplinas() {
        List<DisciplinaDTO2> disciplinas = new ArrayList<DisciplinaDTO2>();

        for (Disciplina disciplina : disciplinaDAO.findAll()) {
            disciplinas.add(new DisciplinaDTO2(disciplina.getId(), disciplina.getNome()));
        }

        return disciplinas;
    }


    public DisciplinaDTO getDisciplinaById(Long id) {

        Disciplina disciplina = disciplinaDAO.findById(id).get();

        return new DisciplinaDTO(disciplina.getId(), disciplina.getNome(), disciplina.getNota(), disciplina.getComentarios(), disciplina.getLikes());
    }



    public List<Disciplina> addDisciplinas(List<DisciplinaDTO3> disciplinasdto) {
        List<Disciplina> retorno = new ArrayList<Disciplina>();
        for (DisciplinaDTO3 disciplina: disciplinasdto) {
            Disciplina disciplina1 = new Disciplina(disciplina.getNome());
            disciplinaDAO.save(disciplina1);
            retorno.add(disciplina1);
        }

        return retorno;
    }
}
