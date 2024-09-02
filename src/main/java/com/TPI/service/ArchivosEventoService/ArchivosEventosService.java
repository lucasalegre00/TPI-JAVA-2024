package com.TPI.service.ArchivosEventoService;

import com.TPI.domain.Evento;

import java.util.List;

public interface ArchivosEventosService {


    List<Evento> exportarArchivosCsv(String fechaDesde1);
    void cerrarWriter();
}
