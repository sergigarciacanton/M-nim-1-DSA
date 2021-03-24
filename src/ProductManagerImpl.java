import java.util.*;

public class ProductManagerImpl implements ProductManager{
    HashMap<String, Usuario> usuarios;
    List<Producto> listaProductos;
    Queue<Pedido> colaPendientes;

    public static void sort(List<Producto> vector) {
        Collections.sort(vector);
    }

    public List<Producto> getListaProductos() {
        sort(listaProductos);
        return listaProductos;
    }

    public void realizarPedido(Pedido pedido) {
        colaPendientes.add(pedido);

        Usuario cliente = usuarios.get(pedido.getUsuario().getID());
        cliente.getListaRealizados().add(pedido);
    }

    public void servirPedido() {
        Pedido servido = colaPendientes.poll();
        for(int i = 0; i < servido.getListaProductos().size(); i++) {
            int j = 0;
            Boolean encontrado = false;
            while(!encontrado && j < listaProductos.size()) {
                if(listaProductos.get(j).getNombre() == servido.getListaProductos().get(i).getNombre()) {
                    encontrado = true;
                    listaProductos.get(j).setCantidad(listaProductos.get(j).getCantidad() - servido.getListaProductos().get(i).getCantidad());
                }
                j++;
            }
        }
    }

    public List<Pedido> getListaPedidosRealizados(Usuario usuario) {
        return usuarios.get(usuario.getID()).getListaRealizados();
    }

    public List<Producto> getListaProductosPorVentas() {
        return null;
    }


}
