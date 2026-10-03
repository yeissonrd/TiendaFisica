import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {

    private byte idVendedor;
    private String horario;

    // Constructores
    public Vendedor() {
        super();
    }

    public Vendedor(byte idVendedor, String horario) {
        super();
        this.idVendedor = idVendedor;
        this.horario = horario;
    }

    // Getters y Setters
    public byte getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(byte idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    // Métodos
    public void ingresarVentas(Venta venta) {
        venta.calcularTotal();
        Tienda.ventas.add(venta);
        System.out.println("Venta " + venta.getIdVenta() + " registrada.");
    }

    // Sobrecarga 1: todos los productos
    public List<Producto> consultarProductos() {
        return new ArrayList<>(Tienda.productos);
    }

    // Sobrecarga 2: productos filtrados por tipo
    public List<Producto> consultarProductos(String tipo) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : Tienda.productos) {
            if (p.getTipo() != null && p.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public Factura generarFactura(String idVenta) {
        for (Venta v : Tienda.ventas) {
            if (v.getIdVenta().equals(idVenta)) {
                return new Factura("F-" + idVenta, v, this);
            }
        }
        System.out.println("No existe la venta " + idVenta);
        return null;
    }
}
