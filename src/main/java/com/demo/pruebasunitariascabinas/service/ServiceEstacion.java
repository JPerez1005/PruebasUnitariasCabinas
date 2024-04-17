package com.demo.pruebasunitariascabinas.service;

import com.demo.pruebasunitariascabinas.models.Estacion;
import com.demo.pruebasunitariascabinas.models.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author perez
 */
public class ServiceEstacion {
    private ArrayList<Estacion> estaciones;
    ServiceUniversal<Estacion> service = new ServiceUniversal<>();
    
    public ServiceEstacion() {
        this.estaciones = new ArrayList<>();
    }
    
    /*con esto obtenemos la lista de las cabinas*/
    public ArrayList<Estacion> getUsuarios() {
        return estaciones;
    }
    
    /* Método para enviar la lista de cabinas */
    public void enviarEstaciones(ArrayList<Estacion> listaUsuarios) {
        this.estaciones = listaUsuarios;
    }
    
    public void crear(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Registre el id: "));
        String nombre=JOptionPane.showInputDialog(null, "nombre:");
        Estacion e=new Estacion(id,nombre);
        service.guardarDatosEnLista(e, estaciones, "Las_Estaciones");
    }
    
    public void enlistar(){
        service.enlistarDatos(estaciones,"Las_Estaciones");
    }
    
    public Estacion buscarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a buscar: "));
        Estacion e=service.buscarObjetoPorId(id, estaciones, Estacion.class, "Las_Estaciones");
        System.out.println("=====================");
        System.out.println("");
        System.out.println("id: "+e.getId());
        System.out.println("nombre: "+e.getNombre());
        System.out.println("");
        return e;
    }
    
    public void eliminarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a eliminar: "));
        service.eliminarObjetoPorId(id, estaciones, Estacion.class, "Las_Estaciones");
    }
    
    public void modificarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a modificar: "));
        String nombre=JOptionPane.showInputDialog(null, "nombre:");
        Estacion e=new Estacion(id,nombre);
        service.modificarObjetoPorId(id, estaciones, Estacion.class, "Las_Estaciones",e);
    }
}
