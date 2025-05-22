import java.util.Random;
import java.util.Scanner;

class Personaje {
    private String nombre;
    private int hp;
    private int maxDanoBase;
    private int minDanoBase;
    private String armaEquipada;
    private int bonusDanoArma;

    public Personaje(String nombre, int hp, int maxDanoBase, int minDanoBase) {
        this.nombre = nombre;
        this.hp = hp;
        this.maxDanoBase = maxDanoBase;
        this.minDanoBase = minDanoBase;
        this.armaEquipada = "Puños";
        this.bonusDanoArma = 0;
    }

    public void equiparArma(String arma, int bonusDano) {
        this.armaEquipada = arma;
        this.bonusDanoArma = bonusDano;
        System.out.println(nombre + " ha equipado: " + arma + " (+" + bonusDano + " daño)");
    }

    public void atacar(Personaje objetivo) {
        int dano = new Random().nextInt(
            (maxDanoBase + bonusDanoArma) - (minDanoBase + bonusDanoArma) + 1
        ) + (minDanoBase + bonusDanoArma);
        
        objetivo.recibirDano(dano);
        System.out.println(
            nombre + " ataca a " + objetivo.getNombre() + 
            " con " + armaEquipada + " y hace " + dano + " de daño!"
        );
    }

    public void recibirDano(int dano) {
        hp -= dano;
        if (hp <= 0) {
            hp = 0;
            System.out.println("☠️ " + nombre + " ha sido derrotado.");
        } else {
            System.out.println(nombre + " recibe " + dano + " de daño. Vida restante: " + hp);
        }
    }

    public boolean estaVivo() {
        return hp > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hp;
    }
}

class JuegoLucha {
    private Personaje personaje1;
    private Personaje personaje2;
    private Scanner scanner;

    // Menú de personajes (nombre, HP, maxDano, minDano)
    private static final String[][] PERSONAJES = {
        {"Snoop Dogg", "100", "15", "5"},  
        {"Ice-T", "110", "14", "6"},
        {"Lil' Kim", "90", "18", "8"},
        {"Sean Paul", "95", "16", "7"},
        {"Bubba Sparxxx", "120", "12", "4"}
    };

    // Menú de armas (nombre, bonus de daño)
    private static final String[][] ARMAS = {
        {"Bate de béisbol", "5"},  
        {"Botella rota", "3"},
        {"Cuchillo", "7"},
        {"Puñal", "8"},
        {"Cadena", "6"},
        {"Tubo de plomo", "9"},
        {"Navaja", "4"}
    };

    public JuegoLucha() {
        this.scanner = new Scanner(System.in);
    }

    private int mostrarMenu(String titulo, String[][] opciones) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i][0]);
        }
        System.out.print("Elige una opción (1-" + opciones.length + "): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return opcion - 1;
    }

    public void configurarJuego() {
        System.out.println("🔥 ¡STREET FIGHTER CALLEJERO! 🔥");

        // Personaje 1
        int p1 = mostrarMenu("SELECCIONA PERSONAJE 1", PERSONAJES);
        personaje1 = new Personaje(
            PERSONAJES[p1][0],
            Integer.parseInt(PERSONAJES[p1][1]),
            Integer.parseInt(PERSONAJES[p1][2]),
            Integer.parseInt(PERSONAJES[p1][3])
        );
        int armaP1 = mostrarMenu("ELIGE ARMA PARA " + PERSONAJES[p1][0], ARMAS);
        personaje1.equiparArma(ARMAS[armaP1][0], Integer.parseInt(ARMAS[armaP1][1]));

        // Personaje 2
        int p2 = mostrarMenu("SELECCIONA PERSONAJE 2", PERSONAJES);
        personaje2 = new Personaje(
            PERSONAJES[p2][0],
            Integer.parseInt(PERSONAJES[p2][1]),
            Integer.parseInt(PERSONAJES[p2][2]),
            Integer.parseInt(PERSONAJES[p2][3])
        );
        int armaP2 = mostrarMenu("ELIGE ARMA PARA " + PERSONAJES[p2][0], ARMAS);
        personaje2.equiparArma(ARMAS[armaP2][0], Integer.parseInt(ARMAS[armaP2][1]));
    }

    public void jugar() {
        boolean turnoP1 = true;
        while (personaje1.estaVivo() && personaje2.estaVivo()) {
            System.out.println("\n--- Turno de " + (turnoP1 ? personaje1.getNombre() : personaje2.getNombre()) + " ---");
            System.out.println("Presiona Enter para atacar...");
            scanner.nextLine(); // Espera directa

            if (turnoP1) {
                personaje1.atacar(personaje2);
            } else {
                personaje2.atacar(personaje1);
            }
            turnoP1 = !turnoP1;
        }

        System.out.println("\n¡FIN DEL JUEGO!");
        System.out.println("🏆 GANADOR: " + (personaje1.estaVivo() ? personaje1.getNombre() : personaje2.getNombre()));
    }

    public static void main(String[] args) {
        JuegoLucha juego = new JuegoLucha();
        juego.configurarJuego();
        juego.jugar();
    }
}