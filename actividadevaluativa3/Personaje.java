// Personaje.java
import java.util.Random;

public class Personaje {
    protected String nombre;
    protected int hp;
    protected int maxDanoBase;
    protected int minDanoBase;

    public Personaje(String nombre, int hp, int maxDanoBase, int minDanoBase) {
        this.nombre = nombre;
        this.hp = hp;
        this.maxDanoBase = maxDanoBase;
        this.minDanoBase = minDanoBase;
    }

    public void atacar(Personaje objetivo, Arma arma) {
        int dano = new Random().nextInt(
                (maxDanoBase + arma.getBonusDano()) - (minDanoBase + arma.getBonusDano()) + 1) 
                + (minDanoBase + arma.getBonusDano());

        objetivo.recibirDano(dano);
        System.out.println(
                nombre + " ataca a " + objetivo.getNombre() +
                " con " + arma.getNombre() + " y hace " + dano + " de daño!");
    }

    public void recibirDano(int dano) {
        hp -= dano;
        if (hp <= 0) {
            hp = 0;
            System.out.println("☠️   " + nombre + " ha sido derrotado.");
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
}