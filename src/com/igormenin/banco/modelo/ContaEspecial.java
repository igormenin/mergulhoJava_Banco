package com.igormenin.banco.modelo;

public class ContaEspecial extends Conta {

    private double valorLimite;

    public ContaEspecial(Pessoa titular, Pessoa coTitular, int agencia, int numero, double saldo, double valorLimite) {
        super(titular, coTitular, agencia, numero, 0D);
        this.valorLimite = valorLimite;
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }

    @Override
    public double getSaldoDisponivel() {
        return getSaldo() + valorLimite;
    }

}
