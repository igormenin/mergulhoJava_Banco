package com.igormenin.banco.app;

import java.math.BigDecimal;

public class TesteCalculos {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal("1.0");
        System.out.println(x);
        x = x.subtract(new BigDecimal("0.10"));
        System.out.println(x);
        x = x.subtract(new BigDecimal("0.20"));
        System.out.println(x);
        x = x.subtract(new BigDecimal("0.30"));
        System.out.println(x);

    }
}
