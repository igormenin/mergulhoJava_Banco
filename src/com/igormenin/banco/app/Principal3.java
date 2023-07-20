package com.igormenin.banco.app;

import com.igormenin.banco.modelo.Banco;
import com.igormenin.banco.modelo.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Principal3 {

    public static void main(String[] args) {

        Banco banco = new Banco();

//        banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));

//        ToIntFunction<Conta> function = (Conta conta) -> {return conta.getNumero();};  // Expressão Lambda
//        banco.getContas().sort(Comparator.comparingInt(function));

//        banco.getContas().sort(Comparator.comparingInt((Conta conta) -> conta.getNumero()));  // Expressão Lambda

        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));  //Expressão Lambda - Referência de Método

        for (Conta conta: banco.getContas()) {
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
