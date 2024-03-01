package org.example;

public class Request {

    public Request() {
    }

    // Guardará el valor que está pendiente por dispensar
    int valorDispensar = 0;

    // Arreglo que guardará en cada posición la cantidad de billetes que se deben dispensar.
    // El orden del arreglo es : $100.000, $50.000, $20.000, $10.000, $5.000
    int[] cantidadBilletes = new int[]{0,0,0,0,0};


    public int getValorDispensar() {
        return valorDispensar;
    }

    public void setValorDispensar(int valorDispensar) {
        this.valorDispensar = valorDispensar;
    }

    public int[] getCantidadBilletes() {
        return cantidadBilletes;
    }

    public void setCantidadBilletes(int posicion, int cantidad) {
        this.cantidadBilletes[posicion] = cantidad;
    }
}
