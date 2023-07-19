package com.igormenin.banco.modelo;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, Pessoa coTitular, int agencia, int numero, double saldo) {
        super(titular, coTitular, agencia, numero,0D);
    }

    @Override
    public void debitarTarifa() {
        if (getSaldo() < 10_000){
            sacar(25);
        }
    }

    public void creditarRendimentos(double percentualJuros) {
        double valorSaldo = getSaldo();
        double vlrRendimento = (valorSaldo * percentualJuros)/100;
        depositar(vlrRendimento);
    }

}
