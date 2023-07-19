package com.igormenin.banco.modelo.pagamento;

import com.igormenin.banco.modelo.Pessoa;

import java.math.BigDecimal;

public class Holerite implements DocumentoPagavel{

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int qtdeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, BigDecimal valorHora, int qtdeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.qtdeHoras = qtdeHoras;
    }


    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(qtdeHoras));
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
