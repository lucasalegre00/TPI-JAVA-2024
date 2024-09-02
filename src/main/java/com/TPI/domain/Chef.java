package com.TPI.domain;

import java.util.ArrayList;
import java.util.List;

public class Chef {
    private Long dni;
    private String nombre;
    private String especialidad;
    private List<Evento> eventos = new ArrayList<>();

    public Chef() {
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

}
