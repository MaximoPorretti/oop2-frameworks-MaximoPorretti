package porretti.utilizacion;

import porretti.framework.Accion;

public class AccionUno implements Accion {

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando AccionUno... (fetch de tweets de José)");
        // lógica real…
    }

    @Override
    public String nombreItemMenu() {
        return "Accion 1";
    }

    @Override
    public String descripcionItemMenu() {
        return "Esto es para traer los twitts de José...";
    }
}
