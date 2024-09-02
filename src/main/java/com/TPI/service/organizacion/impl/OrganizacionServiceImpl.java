package com.TPI.service.organizacion.impl;

import com.TPI.domain.Chef;
import com.TPI.domain.Evento;
import com.TPI.domain.Organizacion;
import com.TPI.service.organizacion.OrganizacionService;

import java.util.List;

public class OrganizacionServiceImpl implements OrganizacionService {

    Organizacion organizacion;

    public OrganizacionServiceImpl(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    @Override
    public List<Evento> getEvento() {
        return this.organizacion.getEventos();
    }

    @Override
    public List<Chef> getChefs() {
        return this.organizacion.getChefs();
    }

}
