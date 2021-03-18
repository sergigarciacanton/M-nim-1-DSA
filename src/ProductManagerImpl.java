import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class ProductManagerImpl implements ProductManager{
    HashMap<String, Usuario> usuarios;
    List<Producto> listaProductos;
    List<Pedido> listaPeticiones;
    Queue<Pedido> colaPendientes;

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void realizarPedido(Pedido pedido) {
        colaPendientes.add(pedido);
    }

    public void servirPedido() {
        colaPendientes.poll();
    }

    public List<Pedido> getListaPedidosRealizados(Usuario usuario) {
        return null;
    }

    public List<Producto> getListaProductosPorVentas() {
        return null;
    }


}
