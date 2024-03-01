package org.example;

import org.example.manejadores.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Se utilizará como bandera para verificar si se ingresa un valor que no sea un entero
        boolean valorCorrecto = false;

        // Objeto de tipo Request que se procesará en la cadena de responsabilidad
        Request request = new Request();

        // Ciclo para verificar que el valor que se ingrese sea un entero. No deja avanzar hasta que sea un entero.
        while(valorCorrecto == false){
            System.out.println("Ingrese el monto que se debe dispensar: ");
            try{
                request.setValorDispensar(lector.nextInt());
                valorCorrecto = true;
            }catch (InputMismatchException e){
                System.out.println("El valor ingresado no fue un entero");
                valorCorrecto = false;
                lector.next();
            }
        }

        // Instancias de los objetos de la cadena
        ManejadorMultiploCincoMil manejadorValorCorrecto = new ManejadorMultiploCincoMil();
        ManejadorCienMil manejadorCienMil = new ManejadorCienMil();
        ManejadorCincuentaMil manejadorCincuentaMil = new ManejadorCincuentaMil();
        ManejadorVeinteMil manejadorVeinteMil = new ManejadorVeinteMil();
        ManejadorDiezMil manejadorDiezMil = new ManejadorDiezMil();
        ManejadorCincoMil manejadorCincoMil = new ManejadorCincoMil();

        //Configuración del orden de la cadena
        manejadorValorCorrecto.setNext(manejadorCienMil);
        manejadorCienMil.setNext(manejadorCincuentaMil);
        manejadorCincuentaMil.setNext(manejadorVeinteMil);
        manejadorVeinteMil.setNext(manejadorDiezMil);
        manejadorDiezMil.setNext(manejadorCincoMil);

        // Inicio de procesamiento de la request.
        manejadorValorCorrecto.handle(request);
    }
}