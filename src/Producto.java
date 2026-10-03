import java.util.Date;

public class Producto {

    private String productoID;
    private String nombre;
    private Date fechaIngreso;
    private String proveedor;
    private String tipo;
    private double precio;
    private Stock stock = new Stock(); // cada producto tiene su stock

    // Constructores
    public Producto() {
        this.fechaIngreso = new Date();
    }

    public Producto(String productoID, String nombre, double precio) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaIngreso = new Date();
    }

    // Getters y Setters del diagrama
    public String getProductoID() {
        return productoID;
    }

    public void setProductoID(String id) {
        this.productoID = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Getters y Setters extra (necesarios para que funcionen otros métodos)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Stock getStock() {
        return stock;
    }

    // Métodos
    public String consultarProducto() {
        return "ID: " + productoID
                + " | Nombre: " + nombre
                + " | Tipo: " + tipo
                + " | Proveedor: " + proveedor
                + " | Precio: $" + precio
                + " | " + stock.mostrarDatos();
    }

    public void actualizarProducto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public boolean venderProducto(int cantidad) {
        return stock.reducirStock(cantidad);
    }
}
