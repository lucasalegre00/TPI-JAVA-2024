package com.TPI.service.organizacion;

import com.TPI.domain.Chef;
import com.TPI.domain.Evento;

import java.util.List;

public interface OrganizacionService {

    List<Evento> getEvento();

    List<Chef> getChefs();


}
