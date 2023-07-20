package com.igormenin.banco.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipo=" + tipo +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null) return false;
//        if (getClass() != o.getClass()) return false;
//
//        Pessoa pessoa = (Pessoa) o;
//
//        if (!getNome().equals(pessoa.getNome())) return false;
//        if (!getDocumento().equals(pessoa.getDocumento())) return false;
//        return getTipo() == pessoa.getTipo();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(documento, pessoa.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
