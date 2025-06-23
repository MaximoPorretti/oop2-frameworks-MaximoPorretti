package org.example;

import porretti.framework.Accion;

public class AccionDos implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("¡Acción Dos ejecutada!");
    }

    @Override
    public String nombreItemMenu() {
        return "Acción Dos";
    }

    @Override
    public String descripcionItemMenu() {
        return "Muestra un mensaje distinto";
    }
}
