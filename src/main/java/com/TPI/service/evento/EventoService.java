package com.TPI.service.evento;


import com.TPI.domain.Evento;

import java.util.List;
import java.util.UUID;

public interface EventoService {


    void inscribirParticipante(UUID idEvento1);

    void crearEvento();

    void inscribirParticipanteEvento(UUID idEvento, Long dni);

    void listarEvento();

    List<Evento> listarEventosDesdeFecha(String fechaDesdeString);

    List<Evento> listarEventosDisponibles(String fechaDesdeString);

    void inscribirChefEvento(UUID idEvento, int dni);

    void inscribirChef(UUID uuid);

    void añadirReseña(UUID idEvento2, Long dni);
}
