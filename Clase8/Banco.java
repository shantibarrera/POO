package Clase8;

public class Banco {

    private String nombre;
    private String direccion;
    private String cuenta;

    public Banco(String nombre, String direccion, String cuenta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuenta = cuenta;
    }

    public String consultarCliente(Cliente cliente) {
        return cliente.toString();
    }

    public String toString() {
        return "Banco { Nombre: " + nombre +
                " Direccion: " + direccion +
                " Cuenta: " + cuenta + "}";
    }

}