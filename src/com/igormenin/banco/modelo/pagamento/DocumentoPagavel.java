package com.igormenin.banco.modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {

    BigDecimal getValorTotal();
    boolean estaPago();
    boolean estaEstornado();
    void efetuarPagamento();
    default void imprimirRecibo() {
        System.out.println("Recibo");
        System.out.println("Valor Total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }

}
