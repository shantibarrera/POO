package AE2;

import java.text.SimpleDateFormat;
import java.util.Date;

// Clase que relaciona Cliente con Productos: Ejemplo de Agregacion
public class Pedido {

    // Encapsulamiento
    private Cliente cliente;
    private Producto[] productos;
    private Date fecha;
    private int numeroTarjetaCredito;

    public Pedido(Cliente cliente, Producto[] productos, Date fecha, int numeroTarjetaCredito) {
        if (cliente == null || productos == null || fecha == null) {
            throw new IllegalArgumentException("Ningún parámetro del pedido puede ser nulo");
        }
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto[] getProductos() {
        return productos != null ? productos.clone() : new Producto[0];
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaFormateada = sdf.format(fecha); 
        String resumen = "Pedido realizado por: " + cliente + "\nFecha: " + fechaFormateada + "\nProductos:\n";

        // validación para evitar error si productos es null
        if (productos != null && productos.length > 0) {
            for (Producto p : productos) {
                resumen += "- " + p.getDescripcion() + "\n";
            }
        } else {
            resumen += "No hay productos.\n";
        }

        resumen += "Pago con tarjeta Número: **" + (numeroTarjetaCredito % 10000) + "\n";
        return resumen;
    }
}
