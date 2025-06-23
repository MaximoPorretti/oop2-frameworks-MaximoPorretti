package org.example;

import porretti.framework.Accion;

public class AccionUno implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("¡Acción Uno ejecutada desde el framework!");
    }

    @Override
    public String nombreItemMenu() {
        return "Acción Uno";
    }

    @Override
    public String descripcionItemMenu() {
        return "Ejecuta la primera acción de prueba";
    }
}
