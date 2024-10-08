package com.TPI.service.evento.impl;

import com.TPI.domain.Chef;
import com.TPI.domain.Evento;
import com.TPI.domain.Participante;
import com.TPI.domain.Resena;
import com.TPI.service.chef.ChefService;
import com.TPI.service.evento.EventoService;
import com.TPI.service.organizacion.OrganizacionService;
import com.TPI.service.participante.ParticipanteService;
import com.TPI.service.resena.ResenaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class EventoServiceImpl implements EventoService {

    private ParticipanteService participanteService;
    private OrganizacionService organizacionService;
    private ChefService chefService;
    private ResenaService resenaService;
    private Evento evento;

    public EventoServiceImpl(ParticipanteService participanteService, OrganizacionService organizacionService, ChefService chefService, ResenaService resenaService) {
        this.participanteService = participanteService;
        this.organizacionService = organizacionService;
        this.chefService = chefService;
        this.resenaService = resenaService;
    }

    public Evento buscarEventoPorId(UUID idEvento) {
        for (Evento evento : organizacionService.getEvento()) {
            if (evento.getId().equals(idEvento)) {
                return evento; // Si encuentra el evento, lo retorna
            }
        }
        throw new NoSuchElementException("No existe el evento con ID: " + idEvento);
    }


    public void inscribirParticipante(UUID idEvento1) {   //recibe el id del evento
        Participante participante = participanteService.registrarParticipante();
        boolean existeEvento = Boolean.FALSE;
        Evento evento = buscarEventoPorId(idEvento1);
            if (evento.getParticipantes().size() < evento.getCapacidad()) {
                participante.getEventos().add(evento);
                evento.getParticipantes().put(participante.getDni(), participante);
                System.out.println("Participante asignado al evento");
            } else {
                System.out.println("No se puede registrar al participante. Capacidad máxima alcanzada.");
            }

    }
    public void inscribirChef(UUID idEvento1) {
        Chef chef = chefService.altaNuevoChef();
        boolean existeEvento = Boolean.FALSE;


        for (Evento evento : organizacionService.getEvento()) {

            if (evento.getId().equals(idEvento1)) {
                chef.getEventos().add(evento);
                evento.getChefs().put(chef.getDni(), chef);
                existeEvento = Boolean.TRUE;
                break;
            }
        }
        if (existeEvento) {
            System.out.println("Chef asignado al evento");
        }

    }


    @Override
    public void crearEvento() {
        Evento nuevoEvento = new Evento();
        Scanner sc= new Scanner(System.in);

        nuevoEvento.setId(UUID.randomUUID());

        System.out.println("ingrese el nombre del evento");
        String nombreEvento= sc.nextLine();
        sc.nextLine();
        nuevoEvento.setNombre(nombreEvento);

        System.out.println("ingrese la descripcion del evento");
        String descrpEvento= sc.nextLine();
        sc.nextLine();
        nuevoEvento.setDescripcion(descrpEvento);

        System.out.println("Ingrese la fecha del evento (formato: DD-MM-YYYY):");
        String fechaEvento = sc.nextLine();

        System.out.println("Ingrese la hora del evento (formato: HH:mm):");
        String horaEvento = sc.nextLine();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalDate fecha = LocalDate.parse(fechaEvento, dateFormatter);

            LocalTime hora = LocalTime.parse(horaEvento, timeFormatter);

            LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
            nuevoEvento.setFechaYhora(fechaYHora);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha u hora incorrecto. Por favor, use los formatos DD-MM-YYYY y HH:mm.");
            return;
        }

        System.out.println("ingrese la ubicacion del evento");
        String ubicacionEvento = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setUbicacion(ubicacionEvento);

        System.out.println("ingrese la capacidad maxima del evento");
        long capacidadEvento = sc.nextInt();
        sc.nextLine();
        nuevoEvento.setCapacidad(capacidadEvento);

        organizacionService.getEvento().add(nuevoEvento);
        System.out.println("Evento creado satisfactoriamente");



   }
@Override
    public void inscribirParticipanteEvento(UUID idEvento, Long dni){
        Participante participante=null;
        Boolean existeElParticipante= Boolean.FALSE;
        Boolean esEventoEncontrado= Boolean.FALSE;

        for (Evento evento: organizacionService.getEvento()){
            if(evento.getParticipantes().containsKey(dni)){
                participante= evento.getParticipantes().get(dni);
                existeElParticipante = Boolean.TRUE;
                break;
            }
        }
        if (!existeElParticipante){
            throw new NoSuchElementException("No existe el participante");
        }

                Evento evento = buscarEventoPorId(idEvento);
                if (evento.getParticipantes().size() < evento.getCapacidad()) {
                    participante.getEventos().add(evento);
                    evento.getParticipantes().put(participante.getDni(), participante);
                    System.out.println("Participante asignado al evento");
                } else {
                    System.out.println("No se puede registrar al participante. Capacidad máxima alcanzada.");
                }
            }


    @Override
    public void listarEvento() {
        System.out.println("Lista de Eventos disponibles");
        for (Evento evento: organizacionService.getEvento()) {
            System.out.println("fecha del evento: "+ evento.getFechaYhora());
            System.out.println("Número de participantes actuales: " + evento.getParticipantes().size());
            System.out.println(evento.toString());

            if (!evento.getChefs().isEmpty()) {
                System.out.println("Chefs asignados:");
                for (Chef chef : evento.getChefs().values()) {
                    System.out.println("- Chef: " + chef.getNombre() + " (DNI: " + chef.getDni() + ")");
                }
            } else {
                System.out.println("No hay chefs asignados a este evento.");
            }
            if (!evento.getResenas().isEmpty()) {
                System.out.println("Reseñas para el evento " + evento.getNombre() + ":");
                for (Resena resena : evento.getResenas()) {
                    System.out.println("Calificación: " + resena.getCalificacion() + "/5");
                    System.out.println("Comentario: " + resena.getComentario());
                    System.out.println("Participante: " + resena.getParticipante().getNombre());
                    System.out.println("UUID de Reseña: " + resena.getId());
                    System.out.println("--------------------");
                }
            } else {
                System.out.println("No hay reseñas para este evento.");
            }
        }
    }
    @Override
    public List<Evento> listarEventosDesdeFecha(String fechaDesde1) {


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {

            LocalDate fechaDesde = LocalDate.parse(fechaDesde1, dateFormatter);

            System.out.println("Lista de eventos disponibles a partir de " + fechaDesde.format(dateFormatter) + ":");

            boolean hayEventosDisponibles = false;
            for (Evento evento : organizacionService.getEvento()) {

                LocalDate fechaEvento = evento.getFechaYhora().toLocalDate();

                if (fechaEvento.isAfter(fechaDesde)) {
                    System.out.println("fecha del evento: "+ evento.getFechaYhora());
                    System.out.println("Capacidad del evento: " + evento.getCapacidad());
                    System.out.println("Número de participantes actuales: " + evento.getParticipantes().size());
                    System.out.println(evento);
                    hayEventosDisponibles = true;
                }
            }

            if (!hayEventosDisponibles) {
                System.out.println("No hay eventos disponibles a partir de la fecha especificada.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Por favor, use el formato DD-MM-YYYY.");
        }
        return null;
    }

    @Override
    public List<Evento> listarEventosDisponibles(String fechaDesde1) {


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate fechaDesde = LocalDate.parse(fechaDesde1, dateFormatter);

            System.out.println("Lista de eventos disponibles a partir de " + fechaDesde.format(dateFormatter) + ":");

            boolean hayEventosDisponibles = false;
            for (Evento evento : organizacionService.getEvento()) {

                LocalDate fechaEvento = evento.getFechaYhora().toLocalDate();

                if (fechaEvento.isAfter(fechaDesde)) {
                    System.out.println("fecha del evento: "+ evento.getFechaYhora());
                    System.out.println("Capacidad del evento: " + evento.getCapacidad());
                    System.out.println("Número de participantes actuales: " + evento.getParticipantes().size());
                    System.out.println(evento);
                    hayEventosDisponibles = true;
                }
            }

            if (!hayEventosDisponibles) {
                System.out.println("No hay eventos disponibles a partir de la fecha especificada.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Por favor, use el formato DD-MM-YYYY.");
        }
        return null;
    }

    @Override
    public void inscribirChefEvento(UUID idEvento, int dni){
        Chef chef=null;
        Boolean existeElchef= Boolean.FALSE;
        Boolean esEventoEncontrado= Boolean.FALSE;

        for (Evento evento: organizacionService.getEvento()){
            if(evento.getChefs().containsKey(dni)){
                chef= evento.getChefs().get(dni);
                existeElchef = Boolean.TRUE;
                break;
            }
        }
        if (!existeElchef){
            throw new NoSuchElementException("No existe el Chef");
        }
        for (Evento evento: organizacionService.getEvento()){
            if(evento.getId().equals(idEvento)){
                chef.getEventos().add(evento);
                evento.getChefs().put(chef.getDni(),chef);
                esEventoEncontrado= Boolean.TRUE;
                break;
            }


        }
        if(!esEventoEncontrado){
            throw new NoSuchElementException("No existe el evento");
        }else {
            System.out.println("Chef asignado al Evento");
        }


    }

    @Override
    public void añadirReseña(UUID idEvento3, Long dni1){
        Participante participante=null;
        Boolean existeElParticipante= Boolean.FALSE;
        Boolean esEventoEncontrado= Boolean.FALSE;

        for (Evento evento: organizacionService.getEvento()){
            if(evento.getParticipantes().containsKey(dni1)){
                participante= evento.getParticipantes().get(dni1);
                existeElParticipante = Boolean.TRUE;
                break;
            }
        }
        if (!existeElParticipante){
            throw new NoSuchElementException("No existe el participante");
        }
                Evento evento = buscarEventoPorId(idEvento3);
                Resena reseña = resenaService.dejarResena(participante);
                evento.getResenas().add(reseña);
                System.out.println("Reseña añadida por " + participante.getNombre() + " al evento " + evento.getNombre() );
                }

    }






