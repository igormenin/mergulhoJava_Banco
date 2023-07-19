package com.igormenin.banco.modelo;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {

    private BigDecimal valorLimite;

    public ContaEspecial(Pessoa titular, Pessoa coTitular, int agencia, int numero, BigDecimal saldo, BigDecimal valorLimite) {
        super(titular, coTitular, agencia, numero, BigDecimal.ZERO);
        this.valorLimite = valorLimite;
    }

    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

    @Override
    public void debitarTarifa() {
        sacar(new BigDecimal("10"));
    }

    @Override
    public BigDecimal getSaldoDisponivel() {
        return getSaldo().add(valorLimite);
    }

}
