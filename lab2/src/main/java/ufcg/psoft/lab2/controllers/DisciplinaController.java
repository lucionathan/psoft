package ufcg.psoft.lab2.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufcg.psoft.lab2.DTOs.DisciplinaDTO;
import ufcg.psoft.lab2.DTOs.DisciplinaDTO2;
import ufcg.psoft.lab2.DTOs.DisciplinaDTO3;
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


    @PostMapping("api/add")
    public ResponseEntity<List<Disciplina>> addDisciplina(@RequestBody List<DisciplinaDTO3> disciplinas) {

        List<Disciplina> disciplina1 = service.addDisciplinas(disciplinas);

        return new ResponseEntity<List<Disciplina>>(disciplina1, HttpStatus.OK);
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


}
