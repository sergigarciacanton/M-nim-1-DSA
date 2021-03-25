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
        escenario.listaProductos.add(new Producto("Fanta", 1, 10));
        escenario.listaProductos.add(new Producto("Café", 0.5F, 50));
        escenario.listaProductos.add(new Producto("Platano", 0.65F, 15));

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
        List<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("Fanta", 1, 2));
        listaProductos.add(new Producto("Platano", 0.65F, 3));
        Pedido pedido1 = new Pedido(listaProductos, escenario.usuarios.get("123456789A"));

        escenario.realizarPedido(pedido1);
        Assert.assertEquals(1, escenario.colaPendientes.size());

        escenario.servirPedido();
        Assert.assertEquals(0, escenario.colaPendientes.size());
    }
}
