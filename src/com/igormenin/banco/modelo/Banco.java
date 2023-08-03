package com.igormenin.banco.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public Banco() {
        Pessoa pessoa1 = new Pessoa(1,"Igor C. Menin","00111648084");
        Pessoa pessoa2 = new Pessoa(2,"Jucemara Menin","01762323036");

        Conta conta1 = new ContaEspecial(pessoa1,null,1,10,BigDecimal.ZERO,BigDecimal.ZERO);
        Conta conta2 = new ContaEspecial(pessoa2, null,2,20, BigDecimal.ZERO,BigDecimal.ZERO);
        Conta conta3 = new ContaInvestimento(pessoa1, null,3,50, BigDecimal.ZERO);
        Conta conta4 = new ContaInvestimento(pessoa2, null,4,40, BigDecimal.ZERO);

        conta1.depositar(new BigDecimal("100"));
        conta2.depositar(new BigDecimal("150"));
        conta3.depositar(new BigDecimal("200"));
        conta4.depositar(new BigDecimal("400"));

        contas.add(conta3);
        contas.add(conta1);
        contas.add(conta4);
        contas.add(conta2);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Optional<Conta> buscar(int agencia, int numConta) {
        for (Conta conta : getContas()) {
            if (conta.getAgencia() == agencia && conta.getNumero() == numConta) {
                return Optional.of(conta);
            }
        }
        return Optional.empty();
    }

}
