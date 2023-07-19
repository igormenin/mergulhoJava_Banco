package com.igormenin.banco.modelo;

import java.time.LocalDateTime;

public class Pessoa {
    private int id;
    private String nome;
    private String documento;
    private TipoPessoa tipo = TipoPessoa.FISICA;
    private LocalDateTime ultimaAtualizacao = LocalDateTime.now();

    Pessoa() {

    }

    public Pessoa(int id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao() {
        this.ultimaAtualizacao = LocalDateTime.now();
    }
}
