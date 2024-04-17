package com.demo.pruebasunitariascabinas.service;

import com.demo.pruebasunitariascabinas.models.Cabina;
import com.demo.pruebasunitariascabinas.models.Solicitud;
import com.demo.pruebasunitariascabinas.models.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author perez
 */
public class ServiceSolicitud {
    private ArrayList<Solicitud> solicitudes;
    ServiceUniversal<Solicitud> service = new ServiceUniversal<>();
    ServiceCabina serviceCabina = new ServiceCabina();
    ServiceUsuario serviceusuario = new ServiceUsuario();
    
    public ServiceSolicitud() {
        this.solicitudes = new ArrayList<>();
    }
    
    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }
    
    public void enviarListaSolicitudes(ArrayList<Solicitud> listaSolicitudes) {
        this.solicitudes = listaSolicitudes;
    }
    
    public void crear(){
        Cabina c;
        Usuario u;
        String password;
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Registre el id: "));
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualString = fechaActual.format(formatter);
        String aceptado="no";
        do {            
            u=serviceusuario.retornarPorId();
            password=JOptionPane.showInputDialog(null, "Digite la contraseña de ese usuario");
            if(!u.getPassword().equals(password)){
                JOptionPane.showMessageDialog(null, "usted es quien dice ser?", "contraseña incorrrecta", 3);
            }
        } while (!u.getPassword().equals(password));
        serviceCabina.enlistar();
        c=serviceCabina.buscarPorId();
        int capacidad=c.getCapacidad_maxima();
        capacidad=capacidad-1;
        c.setCapacidad_maxima(capacidad);
        if(c.getCapacidad_maxima()==-1){
             JOptionPane.showMessageDialog(null, "En esta cabina ya tiene muchos pasajeros, se cancela la solicitud", "Capacidad maxima alcanzada", 3);
        }else{
            Solicitud s=new Solicitud(id, fechaActualString, aceptado, c, u);
            service.guardarDatosEnLista(s, solicitudes, "Las_solicitudes");
        }
    }
    
    public void modificarAceptacionDeSolicitud(){
        service.enlistarDatos(solicitudes, "Las_solicitudes");
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "digite el id a modificar: "));
        Solicitud s=service.buscarObjetoPorId(id, solicitudes, Solicitud.class, "Las_solicitudes");
        String aceptado;
        if(s.getAceptado().equalsIgnoreCase("no")){
            aceptado="si";
            s.setAceptado(aceptado);
            service.modificarObjetoPorId(id, solicitudes, Solicitud.class, "Las_solicitudes", s);
        }else{
            Cabina c=s.getCabina();
            int capacidad=c.getCapacidad_maxima();
            capacidad=capacidad+1;
            c.setCapacidad_maxima(capacidad);
            aceptado="no";
            s.setAceptado(aceptado);
            service.modificarObjetoPorId(id, solicitudes, Solicitud.class, "Las_solicitudes", s);
        }
        JOptionPane.showMessageDialog(null, "Datos cambiados");
    }

    public void enlistar(){
        service.enlistarDatos(solicitudes,"Las_solicitudes");
    }
}
