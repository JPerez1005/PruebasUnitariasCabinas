import com.demo.pruebasunitariascabinas.service.ServiceUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author perez
 */
public class ServiceUsuarioTest {
    
    ServiceUsuario service = new ServiceUsuario();
    
    public ServiceUsuarioTest() {
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
    public void testCrearUsuario() {
        service.crear();
    }
    
    @Test
    public void testEnlistarUsuarios(){
        service.enlistar();
    }
    
    @Test
    public void testBuscarUsuarioPorId(){
        service.buscarPorId();
    }

    
}
