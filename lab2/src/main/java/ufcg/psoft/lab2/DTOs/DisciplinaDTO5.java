package ufcg.psoft.lab2.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DisciplinaDTO5 {
    private Long id;
    private String nome;
    private String comentarios;

    @JsonCreator
    public DisciplinaDTO5(Long id, String nome, String comentarios) {
        this.id = id;
        this.nome = nome;
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getComentarios() {
        return comentarios;
    }
}
