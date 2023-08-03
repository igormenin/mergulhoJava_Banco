package com.igormenin.banco.app;

import com.igormenin.banco.modelo.Banco;
import com.igormenin.banco.modelo.Conta;

import java.util.Optional;

public class Principal5 {

    public static void main(String[] args) {
        Banco banco = new Banco();

        Optional<Conta> contaOptional = banco.buscar(1,10);

        contaOptional.ifPresent(conta -> System.out.println(conta.getSaldo()));

        if (contaOptional.isPresent()) {
            Conta contaEncontrada = contaOptional.get();
            System.out.println(contaEncontrada.getSaldo());
        }

        System.out.println();


        banco.buscar(1,10)
                .ifPresent(conta -> System.out.println(conta.getSaldo()));




    }
}
