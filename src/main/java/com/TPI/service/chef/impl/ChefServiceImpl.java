package com.TPI.service.chef.impl;

import com.TPI.domain.Chef;
import com.TPI.service.chef.ChefService;
import com.TPI.service.organizacion.OrganizacionService;

import java.util.Scanner;

public class ChefServiceImpl implements ChefService {

    private OrganizacionService organizacionService;

    public ChefServiceImpl(OrganizacionService organizacionService) {
        this.organizacionService = organizacionService;
    }


    @Override
    public Chef altaNuevoChef() {
        Chef nuevoChef = new Chef();
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el numero de dni del Chef: ");
        long numDni = sc.nextInt();
        sc.nextLine();
        nuevoChef.setDni(numDni);

        System.out.println("ingrese el nombre o apodo del Chef: ");
        String nombreChef = sc.nextLine();
        sc.nextLine();
        nuevoChef.setNombre(nombreChef);

        System.out.println("ingrese la especialidad del chef: ");
        String especialidadChef = sc.nextLine();
        sc.nextLine();
        nuevoChef.setEspecialidad(especialidadChef);



        System.out.println("Chef creado correctamente");
        return nuevoChef;
    }
}



    /*@Override
    public void altaNuevoChef() {
        Chef nuevoChef = new Chef();
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el numero de dni del Chef: ");
        long numDni = sc.nextInt();
        sc.nextLine();
        nuevoChef.setDni(numDni);

        System.out.println("ingrese el nombre o apodo del Chef: ");
        String nombreChef = sc.nextLine();
        sc.nextLine();
        nuevoChef.setNombre(nombreChef);

        System.out.println("ingrese la especialidad del chef: ");
        String especialidadChef = sc.nextLine();
        sc.nextLine();
        nuevoChef.setEspecialidad(especialidadChef);

        organizacionService.getChefs().add(nuevoChef);

        System.out.println("Chef creado correctamente");

    }

    @Override
    public void listarChefs() {
        System.out.println("Lista de chefs para asignar a eventos");
        for (Chef chef: organizacionService.getChefs()) {
            System.out.println("Chef: "+chef.getNombre());
            System.out.println("Dni: "+chef.getDni());
            System.out.println("Especialidad: "+chef.getEspecialidad());
            System.out.println("---------------------------------------");
        }
    }

}
*/