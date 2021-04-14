import java.util.*;

public class ProductManagerImpl implements ProductManager{
    private HashMap<String, Usuario> usuarios;
    private List<Producto> listaProductos;
    private Queue<Pedido> colaPedidosPendientes;

    private static ProductManagerImpl instance;

    private ProductManagerImpl()
    {
        listaProductos = new ArrayList<Producto>();
        usuarios = new HashMap<String, Usuario>();
        colaPedidosPendientes = new LinkedList<Pedido>();
    }

    public static ProductManagerImpl getInstance()
    {
        if(instance == null)
            instance = new ProductManagerImpl();

        return instance;

    }

    public void AnadirProducto(Producto producto)
    {
        this.listaProductos.add(producto);
    }

    public void AnadirUsuario(Usuario usuario)
    {
        this.usuarios.put(usuario.getID(), usuario);
    }

    public int getNumeroPedidos(){ return this.colaPedidosPendientes.size(); }

    public static void sort(List<Producto> vector) {
        Collections.sort(vector);
    }

    //lista ordenada por precios ASC
    public List<Producto> getListaProductosPorPrecio() {
        sort(listaProductos);
        return listaProductos;
    }

    public List<Producto> getListaProductos()
    {
        return listaProductos;
    }

    public Queue<Pedido> getColaPedidosPendientes()
    {
        return this.colaPedidosPendientes;
    }

    public HashMap<String, Usuario> getUsuarios()
    {
        return this.usuarios;
    }

    public void realizarPedido(Pedido pedido) {
        colaPedidosPendientes.add(pedido);
        Usuario cliente = pedido.getUsuario();
        cliente.getListaRealizados().add(pedido);
    }

    public void servirPedido() {
        Pedido servido = colaPedidosPendientes.poll();
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
        List<Producto> lista = this.listaProductos;
        Collections.sort(lista, new OrderProductoByVendidos());
        return lista;
    }

}
