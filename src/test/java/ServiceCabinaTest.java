
import com.demo.pruebasunitariascabinas.service.ServiceCabina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author perez
 */
public class ServiceCabinaTest {
    
    ServiceCabina service = new ServiceCabina();
    
    public ServiceCabinaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCrearCabinaConJOptionPane() {
        service.crear();
    }

    @Test
    public void testListaDeCabinas() {
        service.enlistar();
    }
    
    @Test
    public void testBuscarCabinaPorId(){
        service.buscarPorId();
    }
    
    @Test
    public void testEliminarCabina() {
        service.eliminarPorId();
    }
}
