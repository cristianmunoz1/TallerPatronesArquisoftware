package org.example.manejadores;

import org.example.Request;

public class ManejadorCienMil extends BaseHandler{

    public ManejadorCienMil() {
    }


    /*Este método recibe la request y verifica si el valor a dispensar es mayor o igual a 100000 con el objetivo de
    verificar si debe devolver uno o más billetes de 100000. Si hay que dispensar billetes de 100000 o no,
     el sistema pasa la request al siguiente objeto de la cadena. */
    @Override
    public void handle(Request request) {
        if(request.getValorDispensar() >= 100000){
            int cantidadBilletes = (int) Math.floor(request.getValorDispensar())/100000;
            request.setCantidadBilletes(0, cantidadBilletes);
            request.setValorDispensar(request.getValorDispensar() - 100000*cantidadBilletes);
            this.nextHandler.handle(request);
        }else{
            this.nextHandler.handle(request);
        }
    }
}
