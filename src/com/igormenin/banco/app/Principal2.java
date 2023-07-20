package com.igormenin.banco.app;

import com.igormenin.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal2 {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(0,"Igor","CPF");
        Pessoa pessoa2 = new Pessoa(0,"Joce","CPF");
        Pessoa pessoa3 = new Pessoa(0,"Isadora","RG");
        Pessoa pessoa4 = new Pessoa(0,"Igor","CPF");

//        List<Pessoa> pessoas = new ArrayList<>();
//        pessoas.add(pessoa1);
//        pessoas.add(pessoa3);
//        pessoas.add(pessoa2);
//
//        for (int i = 0; i< pessoas.size(); i++){
//            System.out.println(pessoas.get(i).toString());
//        }
//
//        System.out.println();
//
//        for (Pessoa pessoa : pessoas){
//            System.out.println(pessoa.toString());
//        }
//        System.out.println();
//        boolean isExiste = pessoas.contains(pessoa2);
//        System.out.println("Contains: " + isExiste);
//        System.out.println("Equals: " + pessoa1.equals(pessoa4));


        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa3);
        pessoas.add(pessoa2);

        boolean isExiste = pessoas.contains(pessoa2);
        System.out.println("Contains: " + isExiste);

        System.out.println();

    }

}
