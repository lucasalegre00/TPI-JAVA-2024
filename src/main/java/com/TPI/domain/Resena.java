package com.TPI.domain;

import java.util.UUID;

public class Resena {
    private UUID id;
    private int calificacionEnum;
    private String comentario;
    private Participante participante;

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getCalificacionEnum() {
        return calificacionEnum;
    }

    public void setCalificacionEnum(int calificacionEnum) {
        this.calificacionEnum = calificacionEnum;
    }

    public Resena() {
        this.id = id;
        this.calificacionEnum = calificacionEnum;
        this.comentario = comentario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacionEnum;
    }

    public void setCalificacion(int calificacion) {
        this.calificacionEnum = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
