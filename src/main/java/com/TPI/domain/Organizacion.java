package com.TPI.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Organizacion {

    private List<Evento> eventos= new ArrayList();
    private List<Chef> chefs= new ArrayList<>();

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
