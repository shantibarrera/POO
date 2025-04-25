import java.util.Date;

public class Pedido {

    // Atributos
    private Cliente cliente;
    private Producto[] producto;
    private Date fecha;
    private int numeroTarjetaCredito;


    // Constructores
    public Pedido(Cliente cliente, Producto[] producto, Date fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }
    

    public Pedido(Cliente cliente1, Producto producto1, Date fecha2, int numeroTarjetaCredito2) {
        //TODO Auto-generated constructor stub
    }


    public Pedido(Cliente cliente1, Producto producto1, Date fecha2, String string) {
        //TODO Auto-generated constructor stub
    }


    // Metodos
    public Cliente getCliente() {
        return cliente;
    }

}
