package com.TPI.service.participante.impl;

import com.TPI.domain.Participante;
import com.TPI.service.participante.ParticipanteService;

import java.util.Scanner;

public class ParticipanteServiceImpl implements ParticipanteService {

    @Override
    public Participante registrarParticipante() {
        Participante nuevoParticipante= new Participante();
        Scanner sc= new Scanner(System.in);
        System.out.println("ingrese el numero de dni: ");
        long numDni= sc.nextInt();
        sc.nextLine();
        nuevoParticipante.setDni(numDni);

        System.out.println("ingrese el nombre del participante: ");
        String nombreParticipante= sc.nextLine();
        sc.nextLine();
        nuevoParticipante.setNombre(nombreParticipante);

        System.out.println("ingrese el Apellido del participante: ");
        String apellidoParticipante= sc.nextLine();
        sc.nextLine();
        nuevoParticipante.setApellido(apellidoParticipante);

        System.out.println("ingrese los intereses culinarios del participante: ");
        String interesesParticipante= sc.nextLine();
        sc.nextLine();
        nuevoParticipante.setInteres(interesesParticipante);

        System.out.println("Participante creado correctamente");

        return nuevoParticipante;
}

    }
