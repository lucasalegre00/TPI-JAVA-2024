package com.TPI;

import com.TPI.domain.Organizacion;
import com.TPI.domain.Participante;
import com.TPI.domain.Resena;
import com.TPI.service.ArchivosEventoService.ArchivosEventosService;
import com.TPI.service.ArchivosEventoService.impl.ArchivosEventosServiceImpl;
import com.TPI.service.chef.ChefService;
import com.TPI.service.chef.impl.ChefServiceImpl;
import com.TPI.service.evento.EventoService;
import com.TPI.service.evento.impl.EventoServiceImpl;
import com.TPI.service.menuService.MenuService;
import com.TPI.service.menuService.impl.MenuServiceImpl;
import com.TPI.service.organizacion.OrganizacionService;
import com.TPI.service.organizacion.impl.OrganizacionServiceImpl;
import com.TPI.service.participante.ParticipanteService;
import com.TPI.service.participante.impl.ParticipanteServiceImpl;
import com.TPI.service.resena.ResenaService;
import com.TPI.service.resena.impl.ResenaServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
public static void main( String[] args ) {

        Organizacion organizacion= new Organizacion();
        ParticipanteService participanteService= new ParticipanteServiceImpl();
        OrganizacionService organizacionService= new OrganizacionServiceImpl(organizacion);
        ChefService chefService= new ChefServiceImpl(organizacionService);
        ResenaService resenaService = new ResenaServiceImpl();
        ArchivosEventosService archivosEventosService = new ArchivosEventosServiceImpl(organizacionService);


        EventoService eventoService = new EventoServiceImpl(participanteService, organizacionService, chefService,resenaService);
        MenuService menuService = new MenuServiceImpl(eventoService,chefService,resenaService, archivosEventosService);
        Scanner scanner = new Scanner(System.in);

        menuService.mostrarMenu(scanner);

        scanner.close();
        archivosEventosService.cerrarWriter();

    }





}


