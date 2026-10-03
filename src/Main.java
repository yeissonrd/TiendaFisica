import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // 1. Crear administrador y vendedor
        Administrador admin = new Administrador((byte) 1, "Gerente");
        admin.setIdPersona("1001");
        admin.setNombre("Laura Gómez");

        Vendedor vendedor = new Vendedor((byte) 1, "8:00 - 17:00");
        vendedor.setIdPersona("2001");
        vendedor.setNombre("Carlos Pérez");
        vendedor.actualizarDatos("carlos@tienda.com", "3001234567");
        System.out.println(vendedor.consultarDatos());

        // 2. El administrador agrega productos
        Producto p1 = new Producto("P01", "Mouse", 50000);
        p1.setTipo("Accesorio");
        p1.getStock().agregarStock(20);

        Producto p2 = new Producto("P02", "Teclado", 120000);
        p2.setTipo("Accesorio");
        p2.getStock().agregarStock(10);

        Producto p3 = new Producto("P03", "Monitor", 750000);
        p3.setTipo("Pantalla");
        p3.getStock().agregarStock(3);

        admin.agregarProducto(p1);
        admin.agregarProducto(p2);
        admin.agregarProducto(p3);

        // 3. El vendedor consulta productos
        System.out.println("\n--- Todos los productos ---");
        for (Producto p : vendedor.consultarProductos()) {
            System.out.println(p.consultarProducto());
        }

        System.out.println("\n--- Solo accesorios ---");
        for (Producto p : vendedor.consultarProductos("Accesorio")) {
            System.out.println(p.consultarProducto());
        }

        // 4. Registrar una venta
        Venta venta = new Venta("V001", new Date());
        venta.agregarProducto(p1, 2);
        venta.agregarProducto(p3, 1);
        vendedor.ingresarVentas(venta);

        // 5. Generar factura
        Factura factura = vendedor.generarFactura("V001");
        if (factura != null) {
            System.out.println("\n" + factura.mostrarFactura());
        }

        // 6. El administrador consulta el historial
        System.out.println("\nVentas registradas: " + admin.consultarHistorial().size());
    }
}
