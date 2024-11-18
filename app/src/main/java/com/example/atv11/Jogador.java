package com.example.atv11;

public class Jogador {
    private int id;
    private String nome;
    private int idade;
    private int idTime;

    public Jogador(int id, String nome, int idade, int idTime) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.idTime = idTime;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getIdTime() {
        return idTime;
    }

    @Override
    public String toString() {
        return "Jogador: " + nome + ", Idade: " + idade;
    }
}
