package AE2;

public class Cliente {

    // Encapsulamiento
    private String cedula;
    private String nombre;

    public Cliente(String cedula, String nombre) {
        if (cedula == null || cedula.isEmpty() || nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Cédula y nombre no pueden estar vacíos");
        }
        this.cedula = cedula;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Datos del cliente: Cédula: " + cedula + ", Nombre: " + nombre + " }";
    }
}
