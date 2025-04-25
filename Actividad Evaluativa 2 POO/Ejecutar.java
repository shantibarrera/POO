package AE2;
import modelos.Camara;

import java.util.Date;

public class Ejecutar {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("1017298473", "Valentina Sanchez");

        Foto foto1 = new Foto("CumpleañosMamá.jpg");
        Foto foto2 = new Foto("CumpleañosPapá.jpg");
        Foto[] fotos = { foto1, foto2 };

        // Crear productos (herencia y polimorfismo)
        Camara camara = new Camara(1, "Sony", "ZV-1F");
        Impresion impresion = new Impresion(2, "Color", fotos);
        Producto[] productos = { camara, impresion };

        // Crear pedido (agregación)
        Pedido pedido = new Pedido(cliente, productos, new Date(), 12345678);

        System.out.println(pedido);

        // método mostrarFotos() de la clase Impresion
        impresion.mostrarFotos();
    }
}
