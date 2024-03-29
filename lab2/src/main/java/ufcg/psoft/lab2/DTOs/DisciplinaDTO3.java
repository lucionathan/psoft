package ufcg.psoft.lab2.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DisciplinaDTO3 {


    private Long id;
    private String nome;
    private Integer likes;

    @JsonCreator
    public DisciplinaDTO3(Long id, String nome, Integer likes) {
        this.id = id;
        this.nome = nome;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getLikes() {
        return likes;
    }
}
