package ufcg.psoft.lab2.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufcg.psoft.lab2.DTOs.*;
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

    public DisciplinaDTO3 incrementaLike(Long id) {
        Disciplina disciplina = disciplinaDAO.findById(id).get();
        disciplina.setLikes(disciplina.getLikes() + 1);
        disciplinaDAO.save(disciplina);
        return new DisciplinaDTO3(disciplina.getId(), disciplina.getNome(), disciplina.getLikes());
    }

    public DisciplinaDTO4 mudaNota(Long id, double nota) {

        Disciplina disciplina = disciplinaDAO.findById(id).get();
        disciplina.setNota(nota);
        disciplinaDAO.save(disciplina);
        return new DisciplinaDTO4(disciplina.getId(), disciplina.getNome(), disciplina.getNota());
    }

    public DisciplinaDTO5 mudaComentarios(Long id, String comentario) {
        Disciplina disciplina = disciplinaDAO.findById(id).get();
        disciplina.setComentarios(disciplina.getComentarios() + System.lineSeparator() + comentario);

        disciplinaDAO.save(disciplina);

        return new DisciplinaDTO5(disciplina.getId(), disciplina.getNome(), disciplina.getComentarios());
    }

    public List<Disciplina> getDisciplinaOrdenadaPorLikes() {
        return disciplinaDAO.findByOrderByLikesDesc();
    }

    public List<Disciplina> getDisciplinaOrdenadaPorNota() {
        return disciplinaDAO.findByOrderByNotaDesc();
    }
}
