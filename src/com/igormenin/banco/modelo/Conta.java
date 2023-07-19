package com.igormenin.banco.modelo;

import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private Pessoa coTitular;
    private int agencia;
    private int numero;
    private double saldo;

    Conta() {
    }

    public Conta(Pessoa titular, Pessoa coTitular, int agencia, int numero, double saldo) {
        Objects.requireNonNull(titular);
        Objects.requireNonNull(agencia);
        Objects.requireNonNull(numero);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(double valor){
        if ( valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo!");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if ( valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo!");
        }
        if ( getSaldoDisponivel() >= valor ) {
            saldo -= valor;
        } else {
            throw new IllegalStateException("Saldo insuficiente!");
        }

    }

    public void sacar(double valor, double taxaSaque){
        sacar(valor + taxaSaque);
    }

    public abstract void debitarTarifa();

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public Pessoa getCoTitular() {
        return coTitular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel() {
        return getSaldo();
    }
}
