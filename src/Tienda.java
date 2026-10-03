import java.util.ArrayList;
import java.util.List;

// "Base de datos" compartida entre Vendedor y Administrador
public class Tienda {

    public static final List<Producto> productos = new ArrayList<>();
    public static final List<Venta> ventas = new ArrayList<>();
}
