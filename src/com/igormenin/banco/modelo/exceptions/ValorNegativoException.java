package com.igormenin.banco.modelo.exceptions;

public class ValorNegativoException extends RuntimeException{

    public ValorNegativoException(String message) {
        super(message);
    }
}
