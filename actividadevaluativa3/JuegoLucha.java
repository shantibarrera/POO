
// Importaciones necesarias para las clases Random y Scanner
import java.util.Random;
import java.util.Scanner;

/**
 * Clase Personaje: Representa a un luchador en el juego.
 * Contiene atributos como nombre, salud (HP), daño y armas equipadas.
 */
class Personaje {
    // Atributos privados del personaje
    private String nombre; // Nombre del personaje
    private int hp; // Puntos de salud (Hit Points)
    private int maxDanoBase; // Daño máximo base (sin armas)
    private int minDanoBase; // Daño mínimo base (sin armas)
    private String armaEquipada; // Nombre del arma equipada
    private int bonusDanoArma; // Bonificación de daño del arma

    /**
     * Constructor de Personaje.
     * 
     * @param nombre      Nombre del personaje
     * @param hp          Salud inicial
     * @param maxDanoBase Daño máximo base
     * @param minDanoBase Daño mínimo base
     */
    public Personaje(String nombre, int hp, int maxDanoBase, int minDanoBase) {
        this.nombre = nombre;
        this.hp = hp;
        this.maxDanoBase = maxDanoBase;
        this.minDanoBase = minDanoBase;
        this.armaEquipada = "Puños"; // Arma por defecto
        this.bonusDanoArma = 0; // Sin bonificación inicial
    }

    /**
     * Equipa un arma al personaje.
     * 
     * @param arma      Nombre del arma
     * @param bonusDano Bonificación de daño que proporciona el arma
     */
    public void equiparArma(String arma, int bonusDano) {
        this.armaEquipada = arma;
        this.bonusDanoArma = bonusDano;
        System.out.println(nombre + " ha equipado: " + arma + " (+" + bonusDano + " daño)");
    }

    /**
     * Realiza un ataque a otro personaje.
     * 
     * @param objetivo Personaje que recibe el ataque
     */
    public void atacar(Personaje objetivo) {
        // Calcula el daño aleatorio dentro del rango (considerando el arma)
        int dano = new Random().nextInt(
                (maxDanoBase + bonusDanoArma) - (minDanoBase + bonusDanoArma) + 1) + (minDanoBase + bonusDanoArma);

        objetivo.recibirDano(dano); // Aplica el daño al objetivo
        System.out.println(
                nombre + " ataca a " + objetivo.getNombre() +
                        " con " + armaEquipada + " y hace " + dano + " de daño!");
    }

    /**
     * Reduce la salud del personaje al recibir daño.
     * 
     * @param dano Cantidad de daño recibido
     */
    public void recibirDano(int dano) {
        hp -= dano;
        if (hp <= 0) {
            hp = 0;
            System.out.println("☠️ " + nombre + " ha sido derrotado.");
        } else {
            System.out.println(nombre + " recibe " + dano + " de daño. Vida restante: " + hp);
        }
    }

    /**
     * Verifica si el personaje sigue vivo.
     * 
     * @return true si tiene salud restante, false si está derrotado
     */
    public boolean estaVivo() {
        return hp > 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hp;
    }
}

/**
 * Clase JuegoLucha: Contiene la lógica principal del juego.
 * Maneja la interacción con el usuario y el flujo del juego.
 */
class JuegoLucha {
    private Personaje personaje1; // Primer jugador
    private Personaje personaje2; // Segundo jugador
    private Scanner scanner; // Para entrada de usuario

    // Base de datos de personajes (nombre, HP, maxDano, minDano)
    private static final String[][] PERSONAJES = {
            { "Snoop Dogg", "100", "15", "5" },
            { "Ice-T", "100", "14", "6" },
            { "Lil' Kim", "100", "18", "8" },
            { "Sean Paul", "100", "16", "7" },
            { "Bubba Sparxxx", "100", "12", "4" }
    };

    // Base de datos de armas (nombre, bonus de daño)
    private static final String[][] ARMAS = {
            { "Bate de béisbol", "5" },
            { "Botella rota", "3" },
            { "Cuchillo", "7" },
            { "Puñal", "8" },
            { "Cadena", "6" },
            { "Tubo de plomo", "9" },
            { "Navaja", "4" }
    };

    /**
     * Constructor: Inicializa el Scanner para entrada de usuario.
     */
    public JuegoLucha() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra un menú y recibe la selección del usuario.
     * 
     * @param titulo   Título del menú
     * @param opciones Array de opciones disponibles
     * @return Índice de la opción seleccionada
     */
    private int mostrarMenu(String titulo, String[][] opciones) {
        System.out.println("\n--- " + titulo + " ---");
        // Muestra cada opción numerada
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i][0]);
        }
        System.out.print("Elige una opción (1-" + opciones.length + "): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer del Scanner
        return opcion - 1; // Ajusta a índice base 0
    }

    /**
     * Configura los personajes y armas para el juego.
     */
    public void configurarJuego() {
        System.out.println("🔥 ¡STREET FIGHTER CALLEJERO! 🔥");

        // Selección del primer personaje
        int p1 = mostrarMenu("SELECCIONA PERSONAJE 1", PERSONAJES);
        personaje1 = new Personaje(
                PERSONAJES[p1][0],
                Integer.parseInt(PERSONAJES[p1][1]),
                Integer.parseInt(PERSONAJES[p1][2]),
                Integer.parseInt(PERSONAJES[p1][3]));
        // Selección de arma para el primer personaje
        int armaP1 = mostrarMenu("ELIGE ARMA PARA " + PERSONAJES[p1][0], ARMAS);
        personaje1.equiparArma(ARMAS[armaP1][0], Integer.parseInt(ARMAS[armaP1][1]));

        // Selección del segundo personaje
        int p2 = mostrarMenu("SELECCIONA PERSONAJE 2", PERSONAJES);
        personaje2 = new Personaje(
                PERSONAJES[p2][0],
                Integer.parseInt(PERSONAJES[p2][1]),
                Integer.parseInt(PERSONAJES[p2][2]),
                Integer.parseInt(PERSONAJES[p2][3]));
        // Selección de arma para el segundo personaje
        int armaP2 = mostrarMenu("ELIGE ARMA PARA " + PERSONAJES[p2][0], ARMAS);
        personaje2.equiparArma(ARMAS[armaP2][0], Integer.parseInt(ARMAS[armaP2][1]));
    }

    /**
     * Controla el flujo principal del juego (turnos y combate).
     */
    public void jugar() {
        boolean turnoP1 = true; // true = turno del jugador 1
        while (personaje1.estaVivo() && personaje2.estaVivo()) {
            System.out
                    .println("\n--- Turno de " + (turnoP1 ? personaje1.getNombre() : personaje2.getNombre()) + " ---");
            System.out.println("Presiona Enter para atacar...");
            scanner.nextLine(); // Espera a que el usuario presione Enter

            // Ejecuta el ataque según el turno
            if (turnoP1) {
                personaje1.atacar(personaje2);
            } else {
                personaje2.atacar(personaje1);
            }
            turnoP1 = !turnoP1; // Alterna el turno
        }

        // Fin del juego: muestra al ganador
        System.out.println("\n¡FIN DEL JUEGO!");
        System.out.println("🏆 GANADOR: " + (personaje1.estaVivo() ? personaje1.getNombre() : personaje2.getNombre()));
    }

    /**
     * Punto de entrada principal del programa.
     */
    public static void main(String[] args) {
        JuegoLucha juego = new JuegoLucha(); // Crea una instancia del juego
        juego.configurarJuego(); // Configura personajes y armas
        juego.jugar(); // Inicia el juego
    }
}