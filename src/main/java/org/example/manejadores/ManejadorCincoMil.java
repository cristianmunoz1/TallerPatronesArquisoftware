package org.example.manejadores;

import org.example.Request;

public class ManejadorCincoMil extends BaseHandler{



    /*Este método recibe la request y verifica si el valor a dispensar es mayor o igual a 5000 con el objetivo de
    verificar si debe devolver uno o más billetes de 5000. Si hay que dispensar de estos billetes o no,
    la cadena de procesamiento termina en esta instancia. */
    @Override
    public void handle(Request request) {
        int valorDispensar = request.getValorDispensar();
        if(valorDispensar >= 5000){
            int cantidadBilletes = (int) Math.floor(request.getValorDispensar())/5000;
            request.setValorDispensar(valorDispensar - cantidadBilletes*5000);
            request.setCantidadBilletes(4, cantidadBilletes);
        }

        imprimir(request.getCantidadBilletes());
    }

    static void imprimir(int[] cantidadBilletes){
        String[] valores = new String[]{"$100.000", "$50.000", "$20.000", "$10.000", "$5.000"};
        for (int i = 0; i < cantidadBilletes.length; i++) {
            if (cantidadBilletes[i] != 0){
                System.out.println("Se dispensaron " + cantidadBilletes[i] + " de billetes de " + valores[i]);
            }else{
                System.out.println("No se dispensaron billetes de " + valores[i]);
            }
        }
    }
}
