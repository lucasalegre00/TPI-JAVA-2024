package com.TPI.service.menuService.impl;

import com.TPI.service.ArchivosEventoService.ArchivosEventosService;
import com.TPI.service.chef.ChefService;
import com.TPI.service.evento.EventoService;
import com.TPI.service.menuService.MenuService;
import com.TPI.service.resena.ResenaService;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class MenuServiceImpl implements MenuService {

    private EventoService eventoService;
    private ChefService chefService;
    private ResenaService resenaService;
    private ArchivosEventosService archivosEventosService;


    public MenuServiceImpl(EventoService eventoService, ChefService chefService, ResenaService resenaService, ArchivosEventosService archivosEventosService) {
        this.eventoService = eventoService;
        this.chefService = chefService;
        this.resenaService = resenaService;
        this.archivosEventosService = archivosEventosService;
    }

    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcion;

        do {
            System.out.println("ingrese opcion: \n");
            System.out.println("1. Crear Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Listar Evento disponibles desde cierta fecha");
            System.out.println("4. Registrar Chef nuevo");
            System.out.println("5. Registrar participante nuevo");
            System.out.println("6  Registrar a un evento a partir de un participante existente");
            System.out.println("7. Dejar reseña y calificacion");
            System.out.println("8. Exportar eventos no disponibles");
            System.out.println("9. Salir ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    eventoService.crearEvento();
                    break;
                case 2:
                    eventoService.listarEvento();
                    break;
                case 3:
                    System.out.println("Ingrese la fecha y desde la que desea ver eventos (formato: dd-MM-yyyy):");
                    String fechaDesde1 = scanner.nextLine();
                    eventoService.listarEventosDesdeFecha(fechaDesde1);
                    break;
                case 4:
                    System.out.println("Ingrese el de id del Evento");
                    String idEvento1 = scanner.nextLine();
                    scanner.nextLine();
                    eventoService.inscribirChef(UUID.fromString(idEvento1));
                    break;
                case 5:
                    System.out.println("Ingrese id del Evento");
                    String idEvento2 = scanner.nextLine();
                    scanner.nextLine();
                    eventoService.inscribirParticipante(UUID.fromString(idEvento2));
                    break;
                case 6:
                    System.out.println("Ingrese id del evento");
                    String idEvento = scanner.nextLine();
                    System.out.println("Ingrese dni del Participante");
                    long dni = scanner.nextInt();
                    scanner.nextLine();
                    try{
                        eventoService.inscribirParticipanteEvento(UUID.fromString(idEvento), dni);
                    }catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Ingrese id del evento");
                    String idEvento3 = scanner.nextLine();
                    System.out.println("Ingrese su dni para dejar reseña");
                    long dni1 = scanner.nextInt();
                    scanner.nextLine();
                    try{
                        eventoService.añadirReseña(UUID.fromString(idEvento3), dni1);
                    }catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("ingrese la fecha para exportar los eventos no disponibles por capacidad");
                    String fechaDesde2 = scanner.nextLine();
                    archivosEventosService.exportarArchivosCsv(fechaDesde2);
                    break;
                case 9:
                    System.out.println("\n Aplicacion Finalizada");
                    break;
                default:
                    break;
            }


        } while (opcion != 9);



    }
    }
