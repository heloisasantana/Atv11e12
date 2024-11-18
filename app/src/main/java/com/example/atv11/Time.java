package com.example.atv11;

public class Time {
    private int id;
    private String nome;
    private String cidade;

    public Time(int id, String nome, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Time: " + nome + ", Cidade: " + cidade;
    }
}

