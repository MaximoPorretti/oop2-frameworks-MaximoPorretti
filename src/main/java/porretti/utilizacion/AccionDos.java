package porretti.utilizacion;

import porretti.framework.Accion;

public class AccionDos implements Accion {

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando AccionDos... (consulta top-10 en la BD)");
        // lógica real…
    }

    @Override
    public String nombreItemMenu() {
        return "Accion 2";
    }

    @Override
    public String descripcionItemMenu() {
        return "Esto trae las primeras diez personas de la BD...";
    }
}
