package com.curso.udemy.cursoUdemy;

public class Saudacao {
    private final long id;
    private final String conteudo;

    public Saudacao(long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public long getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }
}
