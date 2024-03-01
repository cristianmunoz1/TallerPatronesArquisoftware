package org.example.manejadores;

import org.example.Request;

public class ManejadorDiezMil extends BaseHandler{

    /*Este método recibe la request y verifica si el valor a dispensar es mayor o igual a 10000 con el objetivo de
    verificar si debe devolver uno o más billetes de 10000. Si hay que dispensar de estos billetes o no,
     el sistema pasa la request al siguiente objeto de la cadena. */
    @Override
    public void handle(Request request) {
        int valorDispensar = request.getValorDispensar();
        if(valorDispensar >= 10000){
            int cantidadBilletes = (int) Math.floor(request.getValorDispensar())/10000;
            request.setValorDispensar(valorDispensar - cantidadBilletes*10000);
            request.setCantidadBilletes(3, cantidadBilletes);
            this.nextHandler.handle(request);
        }else{
            this.nextHandler.handle(request);
        }
    }
}
