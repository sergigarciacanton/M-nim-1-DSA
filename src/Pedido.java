import java.util.List;

public class Pedido {

    List<Producto> listaProductos;
    Usuario usuario;

    public Pedido(List<Producto> listaProductos, Usuario usuario) {
        this.listaProductos = listaProductos;
        this.usuario = usuario;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
