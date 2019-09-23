package ufcg.psoft.lab2.DTOs;

public class DisciplinaDTO2 {
    Long id;
    String nome;

    public DisciplinaDTO2(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
