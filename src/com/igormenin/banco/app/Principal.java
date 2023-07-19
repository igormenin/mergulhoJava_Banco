package com.igormenin.banco.app;

import com.igormenin.banco.modelo.*;

public class Principal {

    public static void main(String[] args) {

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(new Pessoa(1,"Igor Cassiano Menin","RG"),null,1748,34488,0);

        System.out.println("Titular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.depositar(700);
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.sacar(400, 10);
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.creditarRendimentos(0.8);
        System.out.println("Saldo: " + minhaConta.getSaldo());

        ContaEspecial novaConta = new ContaEspecial(new Pessoa(1,"Isadora Menin","CPF"),null,1234,36548,0, 1500);

        System.out.println("Titular: " + novaConta.getTitular().getNome());
        System.out.println("Saldo: " + novaConta.getSaldo());
        novaConta.depositar(350);
        System.out.println("Saldo: " + novaConta.getSaldo());
        novaConta.sacar(1000,35);
        System.out.println("Saldo: " + novaConta.getSaldo());

        System.out.println();

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(novaConta);

    }
}
