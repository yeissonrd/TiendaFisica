import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {

    private String idVenta;
    private Date fechaVenta;
    private double total;

    // Listas extra para saber qué se vendió y cuánto
    private List<Producto> productos = new ArrayList<>();
    private List<Integer> cantidades = new ArrayList<>();

    // Constructores
    public Venta() {
        this.fechaVenta = new Date();
    }

    public Venta(String idVenta, Date fechaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
    }

    // Getters y Setters
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    // Método extra: agrega un producto a la venta si hay stock
    public boolean agregarProducto(Producto p, int cantidad) {
        if (p.venderProducto(cantidad)) {
            productos.add(p);
            cantidades.add(cantidad);
            return true;
        }
        return false;
    }

    // Métodos
    public double calcularTotal() {
        total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }

    public String mostrarDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta: ").append(idVenta).append(" | Fecha: ").append(fechaVenta).append("\n");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            sb.append("  - ").append(p.getNombre())
              .append(" x").append(cantidades.get(i))
              .append(" = $").append(p.getPrecio() * cantidades.get(i)).append("\n");
        }
        sb.append("Total: $").append(total);
        return sb.toString();
    }
}
