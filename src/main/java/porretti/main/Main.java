package porretti.main;

import porretti.framework.MenuFramework;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Debe indicar la ruta del archivo de configuración.");
            System.exit(1);
        }
        String pathConfig = ClassLoader.getSystemResource("acciones.conf").getPath();
        new MenuFramework(pathConfig).ejecutar();
    }
}
