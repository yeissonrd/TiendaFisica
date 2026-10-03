import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administrador extends Persona {

    private byte idAdministrador;
    private String cargo;

    // Constructores
    public Administrador() {
        super();
    }

    public Administrador(byte idAdministrador, String cargo) {
        super();
        this.idAdministrador = idAdministrador;
        this.cargo = cargo;
    }

    // Getters y Setters
    public byte getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(byte idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Métodos
    public void agregarProducto(Producto p) {
        Tienda.productos.add(p);
        System.out.println("Producto agregado: " + p.getNombre());
    }

    public void removerProducto(String idProducto) {
        boolean eliminado = Tienda.productos.removeIf(p -> p.getProductoID().equals(idProducto));
        System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");
    }

    public void actualizarProducto(Producto p) {
        for (int i = 0; i < Tienda.productos.size(); i++) {
            if (Tienda.productos.get(i).getProductoID().equals(p.getProductoID())) {
                Tienda.productos.set(i, p);
                System.out.println("Producto actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Sobrecarga 1: todo el historial de ventas
    public List<Venta> consultarHistorial() {
        return new ArrayList<>(Tienda.ventas);
    }

    // Sobrecarga 2: ventas entre dos fechas
    public List<Venta> consultarHistorial(Date fechaInicio, Date fechaFin) {
        List<Venta> resultado = new ArrayList<>();
        for (Venta v : Tienda.ventas) {
            Date f = v.getFechaVenta();
            if (!f.before(fechaInicio) && !f.after(fechaFin)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
}
