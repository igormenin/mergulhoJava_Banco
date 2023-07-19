package com.igormenin.banco.modelo.pagamento;

public interface DocumentoPagavel {

    double getValorTotal();
    boolean estaPago();
    boolean estaEstornado();
    void efetuarPagamento();

}
