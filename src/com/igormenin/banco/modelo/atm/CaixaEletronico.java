package com.igormenin.banco.modelo.atm;

import com.igormenin.banco.modelo.Conta;
import com.igormenin.banco.modelo.pagamento.DocumentoEstornavel;
import com.igormenin.banco.modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta) {
        System.out.println("           Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("         Titular: " + conta.getTitular().getNome());
        System.out.println("           Saldo: " + conta.getSaldo());
        System.out.println("Saldo Disponível: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento, Conta conta) {
        if (documento.estaPago()){
            throw new IllegalArgumentException("Documento já está pago!");
        }
        conta.sacar(documento.getValorTotal());
        documento.efetuarPagamento();
    }

    public void estornar(DocumentoEstornavel documento, Conta conta) {
        if (!documento.estaPago()) {
            throw new IllegalArgumentException("Documento não está pago!");
        } else if (documento.estaEstornado()) {
            throw new IllegalArgumentException("Documento já estornado!");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();
    }

}
