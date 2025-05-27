// JuegoLucha.java
import java.util.Scanner;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;
    private Scanner scanner;

    public JuegoLucha() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.println("🔥 ¡STREET FIGHTER CALLEJERO! 🔥");
        configurarJugadores();
        jugar();
    }

    private void configurarJugadores() {
        System.out.println("\n--- CONFIGURACIÓN JUGADOR 1 ---");
        jugador1 = crearPersonaje();
        
        System.out.println("\n--- CONFIGURACIÓN JUGADOR 2 ---");
        jugador2 = crearPersonaje();
    }

    private Personaje crearPersonaje() {
        System.out.print("Nombre del personaje: ");
        String nombre = scanner.nextLine();
        
        System.out.print("HP: ");
        int hp = scanner.nextInt();
        
        System.out.print("Daño mínimo: ");
        int minDano = scanner.nextInt();
        
        System.out.print("Daño máximo: ");
        int maxDano = scanner.nextInt();
        
        scanner.nextLine(); // Limpiar buffer
        
        return new Jugador(nombre, hp, maxDano, minDano);
    }

    private Arma seleccionarArma() {
        System.out.println("\nArmas disponibles:");
        System.out.println("1. Bate de béisbol (+5 daño)");
        System.out.println("2. Botella rota (+3 daño)");
        System.out.println("3. Cuchillo (+7 daño)");
        System.out.println("4. Puñal (+8 daño)");
        System.out.println("5. Cadena (+6 daño)");
        System.out.println("6. Tubo de plomo (+9 daño)");
        System.out.println("7. Navaja (+4 daño)");
        System.out.print("Selecciona un arma (1-7): ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch(opcion) {
            case 1: return new BateBeisbol();
            case 2: return new BotellaRota();
            case 3: return new Cuchillo();
            case 4: return new Puñal();
            case 5: return new Cadena();
            case 6: return new TuboPlomo();
            case 7: return new Navaja();
            default: 
                System.out.println("Opción inválida, usando Bate de béisbol por defecto");
                return new BateBeisbol();
        }
    }

    private void jugar() {
        boolean turnoJugador1 = true;
        
        while(jugador1.estaVivo() && jugador2.estaVivo()) {
            Personaje atacante = turnoJugador1 ? jugador1 : jugador2;
            Personaje objetivo = turnoJugador1 ? jugador2 : jugador1;
            
            System.out.println("\n--- Turno de " + atacante.getNombre() + " ---");
            Arma arma = seleccionarArma();
            
            System.out.println("Presiona Enter para atacar...");
            scanner.nextLine();
            
            atacante.atacar(objetivo, arma);
            turnoJugador1 = !turnoJugador1;
        }
        
        System.out.println("\n¡FIN DEL JUEGO!");
        System.out.println("🏆 GANADOR: " + 
            (jugador1.estaVivo() ? jugador1.getNombre() : jugador2.getNombre()));
    }

    public static void main(String[] args) {
        JuegoLucha juego = new JuegoLucha();
        juego.iniciarJuego();
    }
}