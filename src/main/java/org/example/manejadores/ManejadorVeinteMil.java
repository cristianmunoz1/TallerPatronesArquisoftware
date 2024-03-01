package org.example.manejadores;

import org.example.Request;

public class ManejadorVeinteMil extends BaseHandler{

    /*Este método recibe la request y verifica si el valor a dispensar es mayor o igual a 20000 con el objetivo de
    verificar si debe devolver uno o más billetes de 20000. Si hay que dispensar de estos billetes o no,
     el sistema pasa la request al siguiente objeto de la cadena. */
    @Override
    public void handle(Request request) {
        int valorDispensar = request.getValorDispensar();
        if(valorDispensar >= 20000){
            int cantidadBilletes = (int) Math.floor(request.getValorDispensar())/20000;
            request.setValorDispensar(valorDispensar - cantidadBilletes*20000);
            request.setCantidadBilletes(2, cantidadBilletes);
            this.nextHandler.handle(request);
        }else{
            this.nextHandler.handle(request);
        }
    }
}
