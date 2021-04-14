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
        escenario = ProductManagerImpl.getInstance();
        escenario.AnadirProducto(new Producto("Fanta", 1, 10));
        escenario.AnadirProducto(new Producto("Café", 0.5F, 50));
        escenario.AnadirProducto(new Producto("Platano", 0.65F, 15));

        escenario.AnadirUsuario(new Usuario("123456789A","Arnau"));
        escenario.AnadirUsuario(new Usuario("987654321B","Sergi"));
        escenario.AnadirUsuario(new Usuario("456789123C","Toni"));
        escenario.AnadirUsuario(new Usuario("987321654D","Juan"));

        Pedido pedido = new Pedido(escenario.getUsuarios().get("987654321B"));
        pedido.anadirProducto(new Producto("Fanta", 1, 2));
        escenario.realizarPedido(pedido);
    }

    @After
    public void tearDown() {
        escenario.getColaPedidosPendientes().clear();
        escenario.getListaProductos().clear();
    }

    @Test
    public void testRealizarPedido() {
        Assert.assertEquals(1, escenario.getNumeroPedidos());

        Pedido pedido1 = new Pedido(escenario.getUsuarios().get("123456789A"));
        pedido1.anadirProducto(new Producto("Fanta", 1, 2));
        pedido1.anadirProducto(new Producto("Platano", 0.65F, 3));
        escenario.realizarPedido(pedido1);

        Assert.assertEquals(2, escenario.getNumeroPedidos());

        Pedido pedido2 = new Pedido(escenario.getUsuarios().get("456789123C"));
        pedido2.anadirProducto(new Producto("Platano", 0.65F, 3));
        escenario.realizarPedido(pedido2);

        Assert.assertEquals(3, escenario.getNumeroPedidos());

    }

    @Test
    public void testServirPedido() {
        Assert.assertEquals(1, escenario.getNumeroPedidos());

        escenario.servirPedido();

        Assert.assertEquals(0, escenario.getNumeroPedidos());
        Assert.assertEquals(2, escenario.getNumVentas());

    }
}
