import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerImplTest {
    ProductManagerImpl escenario;

    @Before
    public void setUp() {
        escenario = new ProductManagerImpl();
        escenario.AnadirProducto(new Producto("Fanta", 1, 10));
        escenario.AnadirProducto(new Producto("Café", 0.5F, 50));
        escenario.AnadirProducto(new Producto("Platano", 0.65F, 15));

        escenario.AnadirUsuario(new Usuario("123456789A","Arnau"));
        escenario.AnadirUsuario(new Usuario("987654321B","Sergi"));
        escenario.AnadirUsuario(new Usuario("456789123C","Toni"));
        escenario.AnadirUsuario(new Usuario("987321654D","Juan"));

        List<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("Fanta", 1, 2));
        escenario.realizarPedido(new Pedido(listaProductos, escenario.getUsuarios().get("987654321B")));
    }

    @After
    public void tearDown() {
        escenario.getColaPedidosPendientes().clear();
        escenario.getListaProductos().clear();
    }

    @Test
    public void testRealizarPedido() {
        Assert.assertEquals(1, escenario.getNumeroPedidos());

        List<Producto> listaProductos1 = new ArrayList<Producto>();
        listaProductos1.add(new Producto("Fanta", 1, 2));
        listaProductos1.add(new Producto("Platano", 0.65F, 3));
        escenario.realizarPedido(new Pedido(listaProductos1, escenario.getUsuarios().get("123456789A")));

        Assert.assertEquals(2, escenario.getNumeroPedidos());

        List<Producto> listaProductos2 = new ArrayList<Producto>();
        listaProductos2.add(new Producto("Platano", 0.65F, 3));
        escenario.realizarPedido(new Pedido(listaProductos2, escenario.getUsuarios().get("456789123C")));

        Assert.assertEquals(3, escenario.getNumeroPedidos());
    }

    @Test
    public void testServirPedido() {
        Assert.assertEquals(1, escenario.getNumeroPedidos());

        escenario.servirPedido();

        Assert.assertEquals(0, escenario.getNumeroPedidos());
    }
}
