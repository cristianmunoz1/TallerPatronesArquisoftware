package org.example.manejadores;

import org.example.Request;

public class ManejadorCincuentaMil extends BaseHandler{

    /*Este método recibe la request y verifica si el valor a dispensar es mayor o igual a 50000 con el objetivo de
    verificar si debe devolver uno o más billetes de 50000. Si hay que dispensar de estos billetes o no,
     el sistema pasa la request al siguiente objeto de la cadena. */
    @Override
    public void handle(Request request) {
        int valorDispensar = request.getValorDispensar();
        if(valorDispensar >= 50000){
            int cantidadBilletes = (int) Math.floor(request.getValorDispensar())/50000;
            request.setValorDispensar(valorDispensar - cantidadBilletes*50000);
            request.setCantidadBilletes(1, cantidadBilletes);
            this.nextHandler.handle(request);
        }else{
            this.nextHandler.handle(request);
        }
    }
}
