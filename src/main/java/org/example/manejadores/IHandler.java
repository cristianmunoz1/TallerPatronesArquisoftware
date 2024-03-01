package org.example.manejadores;

import org.example.Request;

public interface IHandler {
    void setNext(IHandler handler);
    void handle(Request request);
}
