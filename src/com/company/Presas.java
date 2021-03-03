package com.company;

import java.io.Serializable;

public class Presas implements Serializable {
    private int Codigo;
    private int Posicion;

    public Presas(int codigo, int posicion) {
        Codigo = codigo;
        Posicion = posicion;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public int getPosicion() {
        return Posicion;
    }

    public void setPosicion(int posicion) {
        Posicion = posicion;
    }

    @Override
    public String toString() {
        return "Codigo: " + Codigo + " Posicion: " + Posicion ;

    }
}