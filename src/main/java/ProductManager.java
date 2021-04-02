import java.util.List;

public interface ProductManager {

    List<Producto> getListaProductos();
    void realizarPedido(Pedido pedido);
    void servirPedido();
    List<Pedido> getListaPedidosRealizados(Usuario usuario);
    List<Producto> getListaProductosPorVentas();
}
