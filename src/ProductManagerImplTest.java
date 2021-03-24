import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProductManagerImplTest {
    ProductManagerImpl escenario;

    @Before
    public void setUp() {
        escenario = new ProductManagerImpl();
        escenario.listaProductos.add(new Producto("Fanta", 1, 10));
        escenario.listaProductos.add(new Producto("Café", 0.5F, 50));
        escenario.listaProductos.add(new Producto("Plátano", 0.65F, 15));

        escenario.usuarios.put("123456789A", new Usuario("Arnau"));
        escenario.usuarios.put("987654321B", new Usuario("Sergi"));
        escenario.usuarios.put("456789123C", new Usuario("Toni"));
        escenario.usuarios.put("987321654D", new Usuario("Juan"));
    }

    @After
    public void tearDown() {
        escenario.usuarios.clear();
        escenario.listaProductos.clear();
    }

    @Test
    public void testRealizarPedido() {
        Assert.assertEquals(0, escenario.colaPendientes.size());
        List<Producto> pedido = new List<Producto>();
        pedido.add(new Producto("Fanta", 1));
        pedido.add(new Producto("Plátano", 2));
        escenario.realizarPedido(new Pedido(pedido, escenario.usuarios.get("123456789A")));
        Assert.assertEquals(1, escenario.colaPendientes.size());
    }
}
