package com.TPI.service.ArchivosEventoService.impl;

import com.TPI.domain.Evento;
import com.TPI.service.ArchivosEventoService.ArchivosEventosService;
import com.TPI.service.organizacion.OrganizacionService;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ArchivosEventosServiceImpl implements ArchivosEventosService {
    private OrganizacionService organizacionService;
    CSVWriter csvWriter;
    public ArchivosEventosServiceImpl(OrganizacionService organizacionService) {
        this.organizacionService = organizacionService;
    }

    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\com\\TPI\\recursos\\";

    @Override
     public List<Evento> exportarArchivosCsv(String fecha) {

        String ruta= System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("Eventos-no-disponibles.csv");

        try{
            this.csvWriter = new CSVWriter(new FileWriter(ruta));
            String[] encabezado = {"ID","Fecha del evento","Nombre","Capacidad"};
            this.csvWriter.writeNext(encabezado);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


            LocalDate fecha1 = LocalDate.parse(fecha, dateFormatter);

            System.out.println("Lista de eventos NO disponibles sobre la fecha seleccionada: " + fecha1.format(dateFormatter) + ":");
            boolean hayEventosExportados = false;
            for (Evento evento : organizacionService.getEvento()) {

                    LocalDate fechaEvento = evento.getFechaYhora().toLocalDate();


                    if (!fechaEvento.isBefore(fecha1) && evento.getParticipantes().size() >= evento.getCapacidad()) {
                        String datos [] = {
                                evento.getId().toString(),
                                evento.getFechaYhora().toString(),
                                evento.getNombre(),
                                evento.getCapacidad().toString()
                        };
                        this.csvWriter.writeNext(datos);
                        hayEventosExportados = true;
                        System.out.println("Evento exportado: " + String.join(", ", datos)); // Mensaje de depuración
                    }
            }

            if (!hayEventosExportados) {
                System.out.println("No hay eventos que cumplan con los criterios de exportación.");
            } else {
                System.out.println("Exportación exitosa a " + ruta);
            }
        }catch (IOException e){
            System.out.println("Algo salio mal: " + e.getMessage().concat("ubicacion del archivo: " + ruta));
    }return null;
}

    @Override
    public void cerrarWriter() {
        if (this.csvWriter != null) {
            try {
                this.csvWriter.close();
            } catch (IOException e) {
                System.out.println("Algo salio mal motivo :" + e.getMessage());
            }
        }

    }
}