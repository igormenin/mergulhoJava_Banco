package com.igormenin.banco.modelo;

import com.igormenin.banco.modelo.exceptions.SaldoInsuficienteException;
import com.igormenin.banco.modelo.exceptions.ValorNegativoException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private Pessoa coTitular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    Conta() {
    }

    public Conta(Pessoa titular, Pessoa coTitular, int agencia, int numero, BigDecimal saldo) {
        Objects.requireNonNull(titular);
        Objects.requireNonNull(agencia);
        Objects.requireNonNull(numero);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(BigDecimal valor){
        if ( valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorNegativoException("Valor deve ser positivo!");
        }
        System.out.println("Depositar Saldo: " + saldo);
        saldo = saldo.add(valor);
        System.out.println("Apos Depositar Saldo: " + saldo);
    }

    public void sacar(BigDecimal valor) {
        if ( valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorNegativoException("Valor deve ser positivo!");
        }
        if ( getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
        saldo = saldo.subtract(valor);
    }

    public void sacar(BigDecimal valor, BigDecimal taxaSaque){
        sacar(valor.add(taxaSaque));
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaldoDisponivel() {
        return getSaldo();
    }
}
