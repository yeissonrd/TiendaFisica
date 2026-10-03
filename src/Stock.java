public class Stock {

    private int cantidad;
    private int umbralMinimo = 5;

    // Constructores
    public Stock() {
    }

    public Stock(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Métodos
    public void agregarStock(int cant) {
        if (cant > 0) {
            cantidad += cant;
        }
    }

    public boolean reducirStock(int cant) {
        if (cant <= 0 || cant > cantidad) {
            System.out.println("Stock insuficiente. Disponible: " + cantidad);
            return false;
        }
        cantidad -= cant;
        if (cantidad <= umbralMinimo) {
            System.out.println("Alerta: stock bajo (" + cantidad + " unidades).");
        }
        return true;
    }

    public String mostrarDatos() {
        return "Stock: " + cantidad + " (mínimo: " + umbralMinimo + ")";
    }
}
