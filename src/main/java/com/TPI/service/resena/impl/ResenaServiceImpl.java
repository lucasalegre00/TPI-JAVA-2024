package com.TPI.service.resena.impl;

import com.TPI.domain.Participante;
import com.TPI.domain.Resena;
import com.TPI.service.resena.ResenaService;

import java.util.Scanner;
import java.util.UUID;

public class ResenaServiceImpl implements ResenaService {

    @Override
    public Resena dejarResena(Participante participante){
        Resena nuevaResena= new Resena();
        nuevaResena.setId(UUID.randomUUID());

        Scanner sc= new Scanner(System.in);

        System.out.println("Por favor, califique el evento del 1 al 5: ");
        int calificacion = sc.nextInt();
        sc.nextLine();
        nuevaResena.setCalificacionEnum(calificacion);

        System.out.println("Por favor, deje un comentario:  ");
        String comentario = sc.nextLine();
        sc.nextLine();
        nuevaResena.setComentario(comentario);
        nuevaResena.setParticipante(participante);


        System.out.println("Reseña asignada correctamente");

        return nuevaResena;

    }
}
