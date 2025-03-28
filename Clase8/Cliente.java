package Clase8;

public class Cliente {
    
private long cedula;
private String nombre;

public Cliente(long cedula, String nombre) {
    this.cedula = cedula;
    this.nombre = nombre;
}

public String toString() {
    return "Cliente { C.C: " + cedula +
            " Nombre: " + nombre + "}";
    }



}
