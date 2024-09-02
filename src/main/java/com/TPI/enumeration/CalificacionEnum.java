package com.TPI.enumeration;

public enum CalificacionEnum {
    UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5);

    private final int valor;

    CalificacionEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}