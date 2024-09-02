package com.TPI.domain;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private Long dni;
    private String nombre;
    private String apellido;
    private String interes;
    private List<Evento> eventos = new ArrayList<>();

    public Participante() {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.interes = interes;
        this.eventos = eventos;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
