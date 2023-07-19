package com.igormenin.banco.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, Pessoa coTitular, int agencia, int numero, BigDecimal saldo) {
        super(titular, coTitular, agencia, numero,saldo);
    }

    @Override
    public void debitarTarifa() {
        if (getSaldo().compareTo(new BigDecimal("10000")) < 0){
            sacar(new BigDecimal("25"));
        }
    }

    public void creditarRendimentos(BigDecimal percentualJuros) {
        BigDecimal valorSaldo = getSaldo();
        BigDecimal vlrRendimento = valorSaldo.multiply(percentualJuros).divide(new BigDecimal("100"), RoundingMode.HALF_EVEN);
        depositar(vlrRendimento);
    }

}
