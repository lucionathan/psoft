package ufcg.psoft.lab2.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private double nota;
    private String comentarios;
    private int likes;

    public Disciplina() {
        super();
    }



    public Disciplina(String nome) {
        this.nome = nome;
        this.comentarios = "";
    }

    @JsonCreator
    public Disciplina(String nome, double nota, String comentarios, int likes) {
        this.nome = nome;
        this.nota = 0;
        this.comentarios = "";
        this.likes = 0;
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
