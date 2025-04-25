package AE2;

// Impresion también hereda de Producto
public class Impresion extends Producto {

    // Encapsulamiento
    private String color;
    private Foto[] fotos; // Composición: Impresion contiene fotos

    public Impresion(int numero, String color, Foto[] fotos) {
        super(numero);
        this.color = color;
        this.fotos = fotos;
    }

    public String getColor() {
        return color;
    }

    public Foto[] getFotos() {
        return fotos != null ? fotos.clone() : new Foto[0];
    }

    @Override
    public String getDescripcion() {
        return "Impresión a " + color + " con " + (fotos != null ? fotos.length : 0) + " foto(s) (Número " + getNumero() + ")";
    }

    // método para recorrer internamente las fotos
    public void mostrarFotos() {
        if (fotos != null && fotos.length > 0) {
            System.out.println("Fotos asociadas a esta impresión:");
            for (Foto f : fotos) {
                f.print();
            }
        } else {
            System.out.println("No hay fotos asociadas a esta impresión.");
        }
    }
}
