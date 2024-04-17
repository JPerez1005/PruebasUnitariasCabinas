import com.demo.pruebasunitariascabinas.models.Estacion;
import com.demo.pruebasunitariascabinas.service.ServiceEstacion;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author perez
 */
public class ServiceEstacionTest {
    
    ServiceEstacion service = new ServiceEstacion();
    
    public ServiceEstacionTest() {
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
    public void testCrearEstacion() {
        service.crear();
    }
    
    @Test
    public void testEnlistarEstaciones(){
        service.enlistar();
    }
    
    @Test
    public void testBuscarEstacionPorId(){
        service.buscarPorId();
    }
}
