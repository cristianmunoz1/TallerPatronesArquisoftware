package org.example.manejadores;

import org.example.Request;

public class ManejadorMultiploCincoMil extends BaseHandler{

    public ManejadorMultiploCincoMil() {

    }

    /*Este método recibe una request y accede al valor a dispensar. Solo avanza en la cadena si es un valor
    múltiplo de 5000*/
    @Override
    public void handle(Request request){
        if(request.getValorDispensar() % 5000 == 0){
            System.out.println("Manejador 1: La cantidad de dinero es válida para dispensar.");
            this.nextHandler.handle(request);
        }else{
            System.out.println("No se puede dispensar esa cantidad");
        }
    }
}
