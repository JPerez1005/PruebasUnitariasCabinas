import com.demo.pruebasunitariascabinas.service.ServiceSolicitud;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author perez
 */
public class envioSolicitudesTest {
    
    ServiceSolicitud service=new ServiceSolicitud();
    
    public envioSolicitudesTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void enviarSolicitud() {
        service.crear();
    }
    
    @Test
    public void cambiarEstadoSolicitud() {
        service.modificarAceptacionDeSolicitud();
    }
}
