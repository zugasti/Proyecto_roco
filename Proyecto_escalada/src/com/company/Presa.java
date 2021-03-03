package com.company;

public class Presa {
    private String Codigo;
    private String Nivel;
    private String Color;
    private String Tama�o;
    private String Forma;
    private String Puntuacion;

    public Presa(String codigo, String nivel, String color, String tama�o, String forma, String puntuacion) {
        Codigo = codigo;
        Nivel = nivel;
        Color = color;
        Tama�o = tama�o;
        Forma = forma;
        Puntuacion = puntuacion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getTama�o() {
        return Tama�o;
    }

    public void setTama�o(String tama�o) {
        Tama�o = tama�o;
    }

    public String getForma() {
        return Forma;
    }

    public void setForma(String forma) {
        Forma = forma;
    }

    public String getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        Puntuacion = puntuacion;
    }
}
