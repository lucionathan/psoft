package ufcg.psoft.lab2.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DisciplinaDTO3 {


    private String nome;

    @JsonCreator
    public DisciplinaDTO3(String nome) {

        this.nome = nome;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
