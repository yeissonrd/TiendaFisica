import java.util.Date;

// Esta clase no aparece en el diagrama, pero generarFactura() la necesita
public class Factura {

    private String idFactura;
    private Date fechaEmision;
    private Venta venta;
    private Vendedor vendedor;

    public Factura(String idFactura, Venta venta, Vendedor vendedor) {
        this.idFactura = idFactura;
        this.venta = venta;
        this.vendedor = vendedor;
        this.fechaEmision = new Date();
    }

    public String getIdFactura() {
        return idFactura;
    }

    public Venta getVenta() {
        return venta;
    }

    public String mostrarFactura() {
        return "===== FACTURA " + idFactura + " =====\n"
                + "Emitida: " + fechaEmision + "\n"
                + "Vendedor: " + vendedor.getNombre() + "\n"
                + venta.mostrarDatos() + "\n"
                + "============================";
    }
}
