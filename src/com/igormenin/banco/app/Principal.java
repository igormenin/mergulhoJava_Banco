package com.igormenin.banco.app;

import com.igormenin.banco.modelo.*;
import com.igormenin.banco.modelo.atm.CaixaEletronico;
import com.igormenin.banco.modelo.exceptions.DocumentoExceptions;
import com.igormenin.banco.modelo.exceptions.SaldoInsuficienteException;
import com.igormenin.banco.modelo.exceptions.ValorNegativoException;
import com.igormenin.banco.modelo.pagamento.Boleto;
import com.igormenin.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;

public class Principal {

    public static void main(String[] args) {

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(new Pessoa(1,"Igor Cassiano Menin","RG"),null,1748,34488,BigDecimal.ZERO);
        System.out.println("DtHr Atualizacao: " + minhaConta.getTitular().getUltimaAtualizacao());
        minhaConta.getTitular().setTipo(TipoPessoa.JURIDICA);
        minhaConta.getTitular().setUltimaAtualizacao();
        System.out.println("DtHr Atualizacao: " + minhaConta.getTitular().getUltimaAtualizacao());
        System.out.println("Titular: " + minhaConta.getTitular().getNome());
        System.out.println("Tipo: " + minhaConta.getTitular().getTipo());
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.depositar(new BigDecimal("57000"));
        System.out.println("Saldo: " + minhaConta.getSaldoDisponivel());
        minhaConta.sacar(new BigDecimal("400"), new BigDecimal("10"));
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.creditarRendimentos(new BigDecimal("0.8"));
        System.out.println("Saldo: " + minhaConta.getSaldo());
        minhaConta.debitarTarifa();
        System.out.println("Saldo: " + minhaConta.getSaldo());


        ContaEspecial novaConta = new ContaEspecial(new Pessoa(1,"Isadora Menin","CPF"),null,1234,36548,BigDecimal.ZERO, new BigDecimal("1500"));

        System.out.println("Titular: " + novaConta.getTitular().getNome());
        System.out.println("Saldo: " + novaConta.getSaldo());
        novaConta.depositar(new BigDecimal("350"));
        System.out.println("Saldo: " + novaConta.getSaldo());
        try {
            novaConta.sacar(new BigDecimal("1000"),new BigDecimal("35"));
        } catch (SaldoInsuficienteException e) {
            System.out.println("# Erro na operação: " + e.getMessage());
        }
        try {
            novaConta.debitarTarifa();
            System.out.println("Saldo: " + novaConta.getSaldo());
        } catch (SaldoInsuficienteException | ValorNegativoException e) {
            System.out.println("# Erro na operação: " + e.getMessage());
        }
        System.out.println();

        Boleto boletoEscola = new Boleto(new Pessoa(1,"Isadora Menin","CPF"),new BigDecimal("200"));
        try {
            caixaEletronico.pagar(boletoEscola,minhaConta);
            boletoEscola.imprimirRecibo();
        } catch (SaldoInsuficienteException | DocumentoExceptions e) {
            System.out.println("# Erro na operação: " + e.getMessage());
        }
        try {
            caixaEletronico.estornar(boletoEscola, minhaConta);
            System.out.println("Boleto Estornado: " + boletoEscola.estaEstornado());
            System.out.println("Saldo: " + minhaConta.getSaldo());
        } catch (SaldoInsuficienteException | DocumentoExceptions e) {
            System.out.println("# Erro na operação: " + e.getMessage());
        }

        System.out.println();

        Holerite holeriteFuncionario = new Holerite(new Pessoa(1,"Isadora Menin","CPF"),new BigDecimal("35"),280);
        try {
            caixaEletronico.pagar(holeriteFuncionario,minhaConta);
            System.out.println("Esta pago:" + holeriteFuncionario.estaPago() + " Valor: " + holeriteFuncionario.getValorTotal().toString());
        } catch (SaldoInsuficienteException | DocumentoExceptions e) {
            System.out.println("# Erro na operação: " + e.getMessage());
        }


        System.out.println();
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(novaConta);

    }
}
