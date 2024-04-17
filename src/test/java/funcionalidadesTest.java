
import com.demo.pruebasunitariascabinas.models.Usuario;
import com.demo.pruebasunitariascabinas.service.*;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author perez
 */
public class funcionalidadesTest {

    ServiceCabina sc = new ServiceCabina();
    ServiceEstacion se = new ServiceEstacion();
    ServiceUsuario su = new ServiceUsuario();
    ServiceSolicitud ss = new ServiceSolicitud();

    public funcionalidadesTest() {
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
    public void menuGeneral() {
        int de = Integer.parseInt(JOptionPane.showInputDialog(null,
                "ingrese una desición:\n\n1.ingresar\n2.entrar como invitado\n3.Salir..."));
        switch (de) {
            case 1 -> {
                Usuario u = su.retornarPorId();
                if (u != null) {
                    String password = JOptionPane.showInputDialog(null, "Ingrese su contraseña");
                    if (!u.getPassword().equals(password)) {
                        JOptionPane.showMessageDialog(null, "contraseña incorrecta");
                        System.out.println("saliendo...");
                        menuGeneral();
                    } else {
                        if (u.getRol().equalsIgnoreCase("administrador")) {
                            JOptionPane.showMessageDialog(null, "Bienvenid@ administrador");
                            menuAdministrador();
                        } else if (u.getRol().equalsIgnoreCase("auxiliar")) {
                            JOptionPane.showMessageDialog(null, "Bienvenid@ auxiliar");
                            menuAuxiliar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Bienvenid@ usuario");
                            menuUsuario();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "id incorrecto");
                    System.out.println("saliendo...");
                    menuGeneral();
                }
            }
            case 2 ->
                menuInvitado();
            case 3 ->
                JOptionPane.showMessageDialog(null, "saliendo...");
            default ->
                throw new AssertionError();
        }
    }

    @Test
    public void menuInvitado() {
        int de;
        do {
            de = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "ingrese una desición:\n\n1.gestión estaciones\n2.gestión cabinas\n3.crear cuenta\n4.salir"));
            switch (de) {
                case 1 ->menuEstaciones();
                case 2 ->menuCabinas();
                case 3 ->crearUsuario2();
                case 4 ->menuGeneral();
                default ->throw new AssertionError();
            }
        } while (de != 5);
    }

    @Test
    public void menuUsuario() {
        int de;
        do {
            de = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "ingrese una desición:\n\n1.gestión estaciones\n2.gestión cabinas\n3.crear solicitud\n4.salir"));
            switch (de) {
                case 1 ->menuEstaciones();
                case 2 ->menuCabinas();
                case 3 ->crearSolicitud();
                case 4 ->menuGeneral();
                default ->throw new AssertionError();
            }
        } while (de != 5);
    }

    @Test
    public void menuAuxiliar() {
        int de, de2;
        do {
            de = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "ingrese una desición:\n\n1.gestión estaciones\n2.gestión cabinas\n3.gestion usuarios\n4.gestion solicitudes\n5.salir"));
            switch (de) {
                case 1 ->menuEstaciones();
                case 2 ->menuCabinas();
                case 3 -> {
                    do {
                        de2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "ingrese una desición:\n\n1.ver usuarios\n2.buscar usuario\n3.crear usuario"));
                        switch (de2) {
                            case 1 ->listarUsuarios();
                            case 2 ->buscarUsuario();
                            case 3 ->crearUsuario2();
                            case 4 ->JOptionPane.showMessageDialog(null, "Saliendo...");
                            default ->throw new AssertionError();
                        }
                    } while (de2 != 4);
                }
                case 4 ->menuSolicitudes();
                case 5 ->menuGeneral();
                default ->throw new AssertionError();
            }
        } while (de != 5);
    }

    @Test
    public void menuAdministrador() {
        int de, de2;
        do {
            de = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "ingrese una desición:"
                    + "\n\n1.gestión estaciones"
                    + "\n2.gestión cabinas"
                    + "\n3.gestion usuarios"
                    + "\n4.gestion solicitudes"
                    + "\n5.salir"));
            switch (de) {
                case 1 -> {
                    do {
                        de2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "ingrese una desición:\n\n1.ver estaciones"
                                + "\n2.buscar estacion"
                                + "\n3.crear estacion"
                                + "\n4.modificar estacion"
                                + "\n5.salir"));
                        switch (de2) {
                            case 1 ->listarEstaciones();
                            case 2 ->buscarEstacion();
                            case 3 ->crearEstacion();
                            case 4 ->modificarEstacion();
                            case 5 ->JOptionPane.showMessageDialog(null, "saliendo...");
                            default ->throw new AssertionError();
                        }
                    } while (de2 != 5);
                }
                case 2 -> {
                    do {
                        de2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "ingrese una desición:\n\n1.ver cabinas"
                                + "\n2.buscar cabina"
                                + "\n3.crear cabina."
                                + "\n4.eliminar cabina"
                                + "\n5.modificar cabina"
                                + "\n6.salir"));
                        switch (de2) {
                            case 1 ->listarCabinas();
                            case 2 ->buscarCabina();
                            case 3 ->crearCabina();
                            case 4 ->eliminarCabina();
                            case 5 ->modificarEstadoCabina();
                            case 6 ->JOptionPane.showMessageDialog(null, "saliendo...");
                            default ->throw new AssertionError();
                        }
                    } while (de2 != 6);
                }
                case 3 ->menuUsuarios();
                case 4 ->menuSolicitudes();
                case 5 ->menuGeneral();
                default ->throw new AssertionError();
            }
        } while (de != 5);
    }

    /*Gestión de las estaciones*/
    @Test
    public void menuEstaciones() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese una opción:\n\n1. Ver estaciones\n2. Buscar estación\n3. Salir"));

            switch (opcion) {
                case 1 -> listarEstaciones();
                case 2 -> buscarEstacion();
                case 3 -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida, por favor ingrese una opción válida");
            }
        } while (opcion != 3); // El bucle continuará mientras la opción ingresada no sea "3" (Salir)
    }

    @Test
    public void listarEstaciones() {
        se.enlistar();
    }

    @Test
    public void buscarEstacion() {
        se.buscarPorId();
    }

    @Test
    public void crearEstacion() {
        se.crear();
    }

    @Test
    public void modificarEstacion() {
        se.modificarPorId();
    }

    @Test
    public void eliminarEstacion() {
        se.eliminarPorId();
    }

    /*Gestión de las cabinas*/
    @Test
    public void menuCabinas() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese una opción:\n\n1. Ver cabinas\n2. Buscar cabina\n3. Salir"));
            switch (opcion) {
                case 1 -> listarCabinas();
                case 2 -> buscarCabina();
                case 3 -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida, por favor ingrese una opción válida");
            }
        } while (opcion != 3); // El bucle continuará mientras la opción ingresada no sea "3" (Salir)
    }

    @Test
    public void listarCabinas() {
        sc.enlistar();
    }

    @Test
    public void buscarCabina() {
        sc.buscarPorId();
    }

    @Test
    public void crearCabina() {
        sc.crear();
    }

    @Test
    public void eliminarCabina() {
        sc.eliminarPorId();
    }

    @Test
    public void modificarEstadoCabina() {
        sc.modificarEstadoPorId();
    }

    /*Gestión de los Usuarios*/
    @Test
    public void menuUsuarios() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese una opción:\n\n1. Ver usuarios\n2. Buscar usuario\n3. Crear usuario\n4. Modificar usuario\n5. Salir"));
            switch (opcion) {
                case 1 ->listarUsuarios();
                case 2 ->buscarUsuario();
                case 3 ->crearUsuario();
                case 4 ->modificarUsuario();
                case 5 ->JOptionPane.showMessageDialog(null, "Saliendo...");
                default ->JOptionPane.showMessageDialog(null, "Opción inválida, por favor ingrese una opción válida");
            }
        } while (opcion != 5);
    }

    @Test
    public void listarUsuarios() {
        su.enlistar();
    }

    @Test
    public void buscarUsuario() {
        su.buscarPorId();
    }

    @Test
    public void crearUsuario() {
        su.crear();
    }

    @Test
    public void crearUsuario2() {
        su.crearUsuario();
    }

    @Test
    public void modificarUsuario() {
        su.modificarPorId();
    }

    /*Gestión de las Solicitudes*/
    @Test
    public void menuSolicitudes() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese una opción:\n\n1. Ver solicitudes\n2. Crear solicitud\n3. Modificar solicitud\n4. Salir"));
            switch (opcion) {
                case 1 ->listarSolicitudes();
                case 2 ->crearSolicitud();
                case 3 ->modificarSolicitud();
                case 4 ->JOptionPane.showMessageDialog(null, "Saliendo...");
                default ->JOptionPane.showMessageDialog(null, "Opción inválida, por favor ingrese una opción válida");
            }
        } while (opcion != 4);
    }

    @Test
    public void listarSolicitudes() {
        ss.enlistar();
    }

    @Test
    public void crearSolicitud() {
        ss.crear();
    }

    @Test
    public void modificarSolicitud() {
        ss.modificarAceptacionDeSolicitud();
    }
}
