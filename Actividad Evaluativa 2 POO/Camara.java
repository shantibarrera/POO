package AE2;

// Camara hereda de Producto (Herencia)
public class Camara extends Producto {

    // Encapsulamiento
    private String marca;
    private String modelo;

    public Camara(int numero, String marca, String modelo) {
        super(numero); 
        this.marca = marca;
        this.modelo = modelo;
    }

    // Polimorfismo: sobrescribe getDescripcion()
    @Override
    public String getDescripcion() {
        return "Cámara: " + marca + " " + modelo + " (Número " + getNumero() + ")";
    }
}
