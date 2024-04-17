package com.demo.pruebasunitariascabinas.service;

/**
 * @author perez
 */
import com.demo.pruebasunitariascabinas.models.Cabina;
import com.demo.pruebasunitariascabinas.models.Estacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServiceCabina {

    private ArrayList<Cabina> cabinas;
    ServiceUniversal<Cabina> service = new ServiceUniversal<>();
    ServiceEstacion serviceEstacion = new ServiceEstacion();

    public ServiceCabina() {
        this.cabinas = new ArrayList<>();
    }
    
    public ArrayList<Cabina> getCabinas() {
        return cabinas;
    }
    
    public void enviarCabinas(ArrayList<Cabina> listaCabinas) {
        this.cabinas = listaCabinas;
    }
    
    public void crear(){
        serviceEstacion.enlistar();
        Estacion e1,e2;
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Registre el id: "));
        int capacidad_maxima=Integer.parseInt(JOptionPane.showInputDialog(null, "Capacidad maxima: "));
        String estado=JOptionPane.showInputDialog(null, "estado(activo/inactivo): ");
        do {     
            JOptionPane.showMessageDialog(null, "Digite la estación origen", "ESTACIÓN ORIGEN", JOptionPane.INFORMATION_MESSAGE);
            e1=serviceEstacion.buscarPorId();
            JOptionPane.showMessageDialog(null, "Digite la estación destino", "ESTACIÓN DEESTINO", JOptionPane.INFORMATION_MESSAGE);
            e2=serviceEstacion.buscarPorId();
        } while (e1==e2);
        
        Cabina c=new Cabina(id,capacidad_maxima,estado,e1,e2);
        service.guardarDatosEnLista(c, cabinas, "Las_Cabinas");
    }
    
    public void enlistar(){
        service.enlistarDatos(cabinas,"Las_Cabinas");
    }
    
    public Cabina buscarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a buscar: "));
        Cabina c=service.buscarObjetoPorId(id, cabinas, Cabina.class, "Las_cabinas");
        System.out.println("=====================");
        System.out.println("");
        System.out.println("id: "+c.getId());
        System.out.println("nombre: "+c.getCapacidad_maxima());
        System.out.println("estación origen: "+c.getEstacion_origen());
        System.out.println("estación destino: "+c.getEstacion_destino());
        System.out.println("");
        return c;
    }
    
    public void eliminarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a eliminar: "));
        service.eliminarObjetoPorId(id, cabinas, Cabina.class, "Las_cabinas");
    }
    
    public void modificarEstadoPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a modificar: "));
        Cabina c=service.buscarObjetoPorId(id, cabinas, Cabina.class, "Las_cabinas");
        String estado;
        if(c.getEstado().equals("activo")){
            estado="inactivo";
            c.setEstado(estado);
            service.modificarObjetoPorId(id, cabinas, Cabina.class, "Las_cabinas", c);
        }else{
            estado="activo";
            c.setEstado(estado);
            service.modificarObjetoPorId(id, cabinas, Cabina.class, "Las_cabinas", c);
        }
        JOptionPane.showMessageDialog(null, "Datos cambiados");
    }
    
}
