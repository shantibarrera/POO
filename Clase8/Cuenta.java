package Clase8;

public class Cuenta {
 
    private int numero;
    private String tipo;
    private double saldo;
 
    public Cuenta(int numero, String tipo, double saldo) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
    }
 
    public String toString() {
        return "Cuenta { Número de cuenta: " + numero + " Tipo: " + tipo + " Saldo: " + saldo + "}";
    }
}