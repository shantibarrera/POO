// Arma.java
public abstract class Arma {
    protected String nombre;
    protected int bonusDano;

    public Arma(String nombre, int bonusDano) {
        this.nombre = nombre;
        this.bonusDano = bonusDano;
    }

    public String getNombre() {
        return nombre;
    }

    public int getBonusDano() {
        return bonusDano;
    }
}

class BateBeisbol extends Arma {
    public BateBeisbol() {
        super("Bate de béisbol", 5);
    }
}

class BotellaRota extends Arma {
    public BotellaRota() {
        super("Botella rota", 3);
    }
}

class Cuchillo extends Arma {
    public Cuchillo() {
        super("Cuchillo", 7);
    }
}

class Puñal extends Arma {
    public Puñal() {
        super("Puñal", 8);
    }
}

class Cadena extends Arma {
    public Cadena() {
        super("Cadena", 6);
    }
}

class TuboPlomo extends Arma {
    public TuboPlomo() {
        super("Tubo de plomo", 9);
    }
}

class Navaja extends Arma {
    public Navaja() {
        super("Navaja", 4);
    }
}