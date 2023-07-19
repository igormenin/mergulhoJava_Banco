package com.igormenin.banco.modelo.pagamento;

import com.igormenin.banco.modelo.Pessoa;

public class Holerite implements DocumentoPagavel{

    private Pessoa funcionario;
    private double valorHora;
    private int qtdeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, double valorHora, int qtdeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.qtdeHoras = qtdeHoras;
    }


    @Override
    public double getValorTotal() {
        return valorHora * qtdeHoras;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public boolean estaEstornado() {
        return false;
    }

    @Override
    public void efetuarPagamento() {
        pago = true;
    }
}
