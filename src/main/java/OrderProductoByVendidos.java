import java.util.Comparator;

public class OrderProductoByVendidos implements Comparator<Producto> {
    public int compare(Producto p1, Producto p2)
    {
        return p1.getVendidos() - p2.getVendidos();
    }
}
