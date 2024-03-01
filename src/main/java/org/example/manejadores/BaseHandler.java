package org.example.manejadores;

import org.example.Request;

public class BaseHandler implements IHandler {

    IHandler nextHandler;

    @Override
    public void setNext(IHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handle(Request request) {

    }


}
