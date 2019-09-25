package ufcg.psoft.lab2.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufcg.psoft.lab2.DTOs.*;
import ufcg.psoft.lab2.entities.Disciplina;
import ufcg.psoft.lab2.services.DisciplinaService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.service = disciplinaService;
    }

    @GetMapping("api/disciplinas")
    public ResponseEntity<List<DisciplinaDTO2>> getDisciplinas() {

        List<DisciplinaDTO2> disciplinas = service.getDisciplinas();
        return new ResponseEntity<List<DisciplinaDTO2>>(disciplinas, HttpStatus.OK);
    }

    @GetMapping("api/disciplinas/{id}")
    public ResponseEntity<DisciplinaDTO> getDisciplinaById(@PathVariable Long id) {
        DisciplinaDTO disciplina = service.getDisciplinaById(id);

        if (disciplina != null) {
            return new ResponseEntity<DisciplinaDTO>(disciplina, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("api/disciplinas/likes/{id}")
    public ResponseEntity<DisciplinaDTO3> incrementaLike(@PathVariable Long id) {
        DisciplinaDTO3 disciplina = service.incrementaLike(id);

        if(disciplina != null) {
            return new ResponseEntity<DisciplinaDTO3>(disciplina, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("api/disciplinas/nota/{id}")
    public ResponseEntity<DisciplinaDTO4> mudaNota(@PathVariable Long id, @RequestBody Disciplina disciplina1) {
        DisciplinaDTO4 disciplina = service.mudaNota(id, disciplina1.getNota());

        if(disciplina != null) {
            return new ResponseEntity<DisciplinaDTO4>(disciplina, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("api/disciplinas/comentarios/{id}")
    public ResponseEntity<DisciplinaDTO5> mudaComentarios(@PathVariable Long id, @RequestBody Disciplina disciplina1) {
        DisciplinaDTO5 disciplina = service.mudaComentarios(id, disciplina1.getComentarios());

        if(disciplina != null) {
            return new ResponseEntity<DisciplinaDTO5>(disciplina, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("api/disciplinas/ranking/notas")
    public ResponseEntity<List<Disciplina>> getDisciplinasOrdenadasPorNotas() {
        List<Disciplina> disciplinas = service.getDisciplinaOrdenadaPorNota();

        return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);

    }

    @GetMapping("api/disciplinas/ranking/likes")
    public ResponseEntity<List<Disciplina>> getDisciplinasOrdenadasPorLikes() {
        List<Disciplina> disciplinas = service.getDisciplinaOrdenadaPorLikes();

        return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);

    }


}
