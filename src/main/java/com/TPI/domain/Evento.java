package com.TPI.domain;

import com.TPI.service.evento.EventoService;

import java.time.LocalDateTime;
import java.util.*;

public class Evento {
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaYhora;
    private String ubicacion;
    private Long capacidad;
    private Map<Long,Chef> chefs = new TreeMap<>();
    private List<Resena> resenas = new ArrayList<>();
    private Map<Long,Participante> participantes = new TreeMap<>();

    public Map<Long, Chef> getChefs() {
        return chefs;
    }

    public void setChefs(Map<Long, Chef> chefs) {
        this.chefs = chefs;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    public Map<Long, Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Map<Long, Participante> participantes) {
        this.participantes = participantes;
    }
    @Override
    public String toString() {

        //Patron builder
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Id : ")
                .append(this.getId()).append("\n")
                .append("Nombre : ")
                .append(this.getNombre()).append("\n")
                .append("Capacidad : ")
                .append(this.getCapacidad()).append("\n")
                .append("Ubicacion : ")
                .append(this.getUbicacion()).append("\n")
                .append("-------------------------------------------------------\n")
                .toString();

    }


}
