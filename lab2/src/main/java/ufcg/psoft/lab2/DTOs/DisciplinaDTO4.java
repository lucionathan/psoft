package ufcg.psoft.lab2.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DisciplinaDTO4 {


    private Long id;
    private String nome;
    private Double nota;

    @JsonCreator
    public DisciplinaDTO4(Long id, String nome, Double nota) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }
}
