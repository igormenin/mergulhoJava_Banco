package com.igormenin.banco.modelo.pagamento;

import com.igormenin.banco.modelo.Pessoa;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel {

    private Pessoa beneficiario;
    private double valor;
    private boolean pago;
    private boolean estornado;

    public Boleto(Pessoa beneficiario, double valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public double getValorTotal() {
        return valor;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void efetuarPagamento() {
        pago = true;
    }

    @Override
    public boolean estaEstornado() {
        return estornado;
    }

    @Override
    public void estornarPagamento() {
        estornado = true;
    }

}
