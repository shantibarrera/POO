package Clase4;
import java.util.Scanner;


// Clase Moto
class Moto {
    private String placa;
    private boolean esAltoCilindraje;
    private int tiempoEstacionado; // Tiempo en minutos

    public Moto(String placa, boolean esAltoCilindraje) {
        this.placa = placa;
        this.esAltoCilindraje = esAltoCilindraje;
        this.tiempoEstacionado = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean esAltoCilindraje() {
        return esAltoCilindraje;
    }

    public int getTiempoEstacionado() {
        return tiempoEstacionado;
    }

    public void setTiempoEstacionado(int tiempoEstacionado) {
        this.tiempoEstacionado = tiempoEstacionado;
    }
}


// Clase Parqueadero
class Parqueadero {
    private Moto[] motosBajoCilindraje;
    private Moto[] motosAltoCilindraje;

    public Parqueadero() {
        motosBajoCilindraje = new Moto[20];
        motosAltoCilindraje = new Moto[10];
    }

    public boolean placaExiste(String placa) {
        // Buscar en motos de bajo cilindraje
        for (Moto moto : motosBajoCilindraje) {
            if (moto != null && moto.getPlaca().equals(placa)) {
                return true;
            }
        }
        // Buscar en motos de alto cilindraje
        for (Moto moto : motosAltoCilindraje) {
            if (moto != null && moto.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrarMoto(Moto moto, boolean esAltoCilindraje, int puesto) {
        if (placaExiste(moto.getPlaca())) {
            System.out.println("Error: Ya existe una moto con la placa " + moto.getPlaca() + ".");
            return false;
        }

        if (esAltoCilindraje) {
            if (puesto < 1 || puesto > motosAltoCilindraje.length) {
                System.out.println("Puesto no válido para motos de alto cilindraje.");
                return false;
            }
            if (motosAltoCilindraje[puesto - 1] == null) {
                motosAltoCilindraje[puesto - 1] = moto;
                return true;
            } else {
                System.out.println("El puesto " + puesto + " ya está ocupado.");
                return false;
            }
        } else {
            if (puesto < 1 || puesto > motosBajoCilindraje.length) {
                System.out.println("Puesto no válido para motos de bajo cilindraje.");
                return false;
            }
            if (motosBajoCilindraje[puesto - 1] == null) {
                motosBajoCilindraje[puesto - 1] = moto;
                return true;
            } else {
                System.out.println("El puesto " + puesto + " ya está ocupado.");
                return false;
            }
        }
    }

    public int calcularCobro(String placa, int tiempoEstacionado) {
        // Buscar la moto en los puestos de bajo cilindraje
        for (int i = 0; i < motosBajoCilindraje.length; i++) {
            Moto moto = motosBajoCilindraje[i];
            if (moto != null && moto.getPlaca().equals(placa)) {
                moto.setTiempoEstacionado(tiempoEstacionado);
                if (tiempoEstacionado <= 30) {
                    return 0;
                } else if (tiempoEstacionado <= 60) {
                    return 800;
                } else {
                    return 2000;
                }
            }
        }

        // Buscar la moto en los puestos de alto cilindraje
        for (int i = 0; i < motosAltoCilindraje.length; i++) {
            Moto moto = motosAltoCilindraje[i];
            if (moto != null && moto.getPlaca().equals(placa)) {
                moto.setTiempoEstacionado(tiempoEstacionado);
                if (tiempoEstacionado <= 30) {
                    return 0;
                } else if (tiempoEstacionado <= 60) {
                    return 800;
                } else {
                    return 2000;
                }
            }
        }

        System.out.println("No se encontró ninguna moto con la placa " + placa + ".");
        return -1;
    }

    public boolean desocuparPuesto(String placa) {
        // Buscar y desocupar en motos de bajo cilindraje
        for (int i = 0; i < motosBajoCilindraje.length; i++) {
            if (motosBajoCilindraje[i] != null && motosBajoCilindraje[i].getPlaca().equals(placa)) {
                motosBajoCilindraje[i] = null;
                System.out.println("Puesto " + (i + 1) + " desocupado.");
                return true;
            }
        }

        // Buscar y desocupar en motos de alto cilindraje
        for (int i = 0; i < motosAltoCilindraje.length; i++) {
            if (motosAltoCilindraje[i] != null && motosAltoCilindraje[i].getPlaca().equals(placa)) {
                motosAltoCilindraje[i] = null;
                System.out.println("Puesto " + (i + 1) + " desocupado.");
                return true;
            }
        }

        System.out.println("No se encontró ninguna moto con la placa " + placa + ".");
        return false;
    }

    public void mostrarDisponibilidad() {
        System.out.println("\n=== Parqueadero de Motos ===");
        System.out.println("=== Motos de Bajo Cilindraje (20 puestos) ===");
        mostrarCuadricula(motosBajoCilindraje, 4); // 4 filas x 5 columnas

        System.out.println("\n=== Motos de Alto Cilindraje (10 puestos) ===");
        mostrarCuadricula(motosAltoCilindraje, 2); // 2 filas x 5 columnas
    }

    private void mostrarCuadricula(Moto[] motos, int filas) {
        int columnas = motos.length / filas;
        System.out.println("+--------+--------+--------+--------+--------+");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int puesto = i * columnas + j;
                String estado = (motos[puesto] == null) ? "✔" : "✖"; // ✔: Disponible, ✖: Ocupado
                System.out.print("| Puesto " + (puesto + 1) + estado + " ");
            }
            System.out.println("|");
            System.out.println("+--------+--------+--------+--------+--------+");
        }
    }
}


// Clase Menu
public class Menu {
    private Parqueadero parqueadero;
    private Scanner scanner;

    public Menu() {
        parqueadero = new Parqueadero();
        scanner = new Scanner(System.in);
        // Mostrar disponibilidad al iniciar
        mostrarDisponibilidad();
    }

    public void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("+---------------------+");
        System.out.println("| 1. Registrar moto   |");
        System.out.println("| 2. Calcular cobro   |");
        System.out.println("| 3. Salir            |");
        System.out.println("+---------------------+");
        System.out.println("");
        System.out.print("Seleccione una opción: ");
    }

    public void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarMoto();
                break;
            case 2:
                calcularCobroYPagar();
                break;
            case 3:
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
        }
        // Mostrar disponibilidad después de cada operación
        mostrarDisponibilidad();
    }

    private void registrarMoto() {
        System.out.println("\n=== Registrar Moto ===");
        System.out.print("Ingrese la placa de la moto: ");
        String placa = scanner.next();
        System.out.print("Es de alto cilindraje? (Si/No): ");
        String respuesta = scanner.next();
        boolean esAltoCilindraje = respuesta.equalsIgnoreCase("Si");
        System.out.print("Ingrese el número de puesto: ");
        int puesto = scanner.nextInt();

        Moto moto = new Moto(placa, esAltoCilindraje);
        if (parqueadero.registrarMoto(moto, esAltoCilindraje, puesto)) {
            System.out.println("Moto de placa " + placa + " registrada exitosamente en el puesto " + puesto);
        } else {
            System.out.println("No se pudo registrar la moto.");
        }
    }

    private void calcularCobroYPagar() {
        System.out.println("\n=== Calcular Cobro y Pagar ===");
        System.out.print("Ingrese la placa de la moto: ");
        String placa = scanner.next();
        System.out.print("Ingrese el tiempo estacionado (en minutos): ");
        int tiempoEstacionado = scanner.nextInt();

        int cobro = parqueadero.calcularCobro(placa, tiempoEstacionado);
        if (cobro != -1) {
            System.out.println("El cobro para la moto con placa " + placa + " es: $" + cobro);
            System.out.print("¿Desea pagar y desocupar el puesto? (Si/No): ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("Si")) {
                if (parqueadero.desocuparPuesto(placa)) {
                    System.out.println("Pago realizado y puesto desocupado.");
                }
            } else {
                System.out.println("Pago no realizado. El puesto sigue ocupado.");
            }
        }
    }

    private void mostrarDisponibilidad() {
        parqueadero.mostrarDisponibilidad();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            menu.mostrarMenu();
            int opcion = menu.scanner.nextInt();
            menu.manejarOpcion(opcion);
        }
    }
}