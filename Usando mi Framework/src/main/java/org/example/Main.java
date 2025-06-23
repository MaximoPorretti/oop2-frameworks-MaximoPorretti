package org.example;

import porretti.framework.MenuFramework;

public class Main {
    public static void main(String[] args) {
        MenuFramework menu =   new MenuFramework("src/main/resources/acciones.conf");
        menu.ejecutar();
    }
}
