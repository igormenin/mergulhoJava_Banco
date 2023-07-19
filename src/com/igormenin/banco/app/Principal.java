package com.igormenin.banco.app;

import com.igormenin.banco.modelo.*;
import com.igormenin.banco.modelo.atm.CaixaEletronico;
import com.igormenin.banco.modelo.pagamento.Boleto;
import com.igormenin.banco.modelo.pagamento.DocumentoPagavel;
import com.igormenin.banco.modelo.pagamento.Holerite;

public class Principal {

    public static void main(String[] args) {

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(new Pessoa(1,"Igor Cassiano Menin","RG"),null,1748,34488,0);

        System.out.println("Titular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.depositar(57000);
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.sacar(400, 10);
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.creditarRendimentos(0.8);
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.debitarTarifa();
        System.out.println("Saldo: " + minhaConta.getSaldo());


        ContaEspecial novaConta = new ContaEspecial(new Pessoa(1,"Isadora Menin","CPF"),null,1234,36548,0, 1500);

        System.out.println("Titular: " + novaConta.getTitular().getNome());
        System.out.println("Saldo: " + novaConta.getSaldo());
        novaConta.depositar(350);
        System.out.println("Saldo: " + novaConta.getSaldo());
        novaConta.sacar(1000,35);
        System.out.println("Saldo: " + novaConta.getSaldo());
        novaConta.debitarTarifa();
        System.out.println("Saldo: " + novaConta.getSaldo());

        System.out.println();

        Boleto boletoEscola = new Boleto(new Pessoa(1,"Isadora Menin","CPF"),200);
        System.out.println("Boleto pago: " + boletoEscola.estaPago());
        caixaEletronico.pagar(boletoEscola,minhaConta);
        System.out.println("Boleto pago: " + boletoEscola.estaPago() + " Valor: " + boletoEscola.getValorTotal());
        System.out.println("Saldo: " + minhaConta.getSaldo());
        System.out.println("Boleto Estornado: " + boletoEscola.estaEstornado());
        System.out.println("######################");
        System.out.println("# Estornando boleto! #");
        System.out.println("######################");
        caixaEletronico.estornar(boletoEscola, minhaConta);
        System.out.println("Boleto Estornado: " + boletoEscola.estaEstornado());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println();

        Holerite holeriteFuncionario = new Holerite(new Pessoa(1,"Isadora Menin","CPF"),35,280);
        System.out.println("Esta pago:" + holeriteFuncionario.estaPago());
        caixaEletronico.pagar(holeriteFuncionario,minhaConta);
        System.out.println("Esta pago:" + holeriteFuncionario.estaPago() + " Valor: " + +holeriteFuncionario.getValorTotal());



        System.out.println();
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(novaConta);

    }
}
