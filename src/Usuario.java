import java.util.List;

public class Usuario {

    String nombre;
    List<Pedido> listaRealizados;

    public Usuario (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pedido> getListaRealizados() {
        return listaRealizados;
    }

    public void setListaRealizados(List<Pedido> listaRealizados) {
        this.listaRealizados = listaRealizados;
    }
}
