package ufcg.psoft.lab2.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;


public class DisciplinaDTO {

    private Long id;
    private String nome;
    private Double nota;
    private String comentarios;
    private Integer likes;

    @JsonCreator
    public DisciplinaDTO(Long id, String nome, Double nota, String comentarios, Integer likes) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.comentarios = comentarios;
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public int getLikes() {
        return likes;
    }
}
