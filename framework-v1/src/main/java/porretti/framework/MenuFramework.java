package porretti.framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class MenuFramework {

    private final List<Accion> acciones;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * @param pathConfig ruta del archivo *.properties* o *.txt*
     *                   que contiene la línea:
     *                   acciones.conf = paquete.A1 ; paquete.A2
     */
    public MenuFramework(String pathConfig) {
        this.acciones = cargarAcciones(pathConfig);
    }


    public void ejecutar() {
        while (true) {
            mostrarMenu();
            int opcion = leerOpcion();

            // Salir
            if (opcion == acciones.size() + 1) {
                System.out.println("¡Hasta luego!");
                break;
            }

            // Ejecutar acción elegida
            if (opcion >= 1 && opcion <= acciones.size()) {
                Accion acc = acciones.get(opcion - 1);
                System.out.println("─".repeat(50));
                try {
                    acc.ejecutar();
                    System.out.println("✔ Acción finalizada con éxito.");
                } catch (Exception e) {
                    System.out.println("✖ Falló la acción: " + e.getMessage());
                }
                System.out.println("─".repeat(50));
            }
        }
    }


    private List<Accion> cargarAcciones(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("#") || linea.isBlank()) continue;

                if (linea.startsWith("acciones")) {
                    String listado = linea.split(":", 2)[1];
                    return Arrays.stream(listado.split(";"))
                            .map(String::trim)
                            .filter(s -> !s.isBlank())
                            .map(this::instanciar)
                            .collect(Collectors.toList());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("No pude leer config: " + e.getMessage(), e);
        }
        throw new IllegalStateException("El archivo no contiene la clave 'acciones.conf:'");
    }

    private Accion instanciar(String fqcn) {
        try {
            return (Accion) Class.forName(fqcn).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("No pude instanciar " + fqcn, e);
        }
    }

    private void mostrarMenu() {
        System.out.println("\nBienvenido, estas son sus opciones:");
        for (int i = 0; i < acciones.size(); i++) {
            Accion a = acciones.get(i);
            System.out.printf("%d. %s (%s)%n",
                    i + 1, a.nombreItemMenu(), a.descripcionItemMenu());
        }
        System.out.printf("%d. Salir%n", acciones.size() + 1);
    }

    private int leerOpcion() {
        System.out.print("Ingrese su opción: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Debe ingresar un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
