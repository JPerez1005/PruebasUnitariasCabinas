package com.demo.pruebasunitariascabinas.service;

import com.demo.pruebasunitariascabinas.models.Usuario;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author perez
 */
public class ServiceUsuario {
    
    private ArrayList<Usuario> usuarios;
    ServiceUniversal<Usuario> service = new ServiceUniversal<>();
    
    public ServiceUsuario() {
        this.usuarios = new ArrayList<>();
    }
    
    /*con esto obtenemos la lista de las cabinas*/
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    /* Método para enviar la lista de cabinas */
    public void enviarUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.usuarios = listaUsuarios;
    }
    
    public void crear(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Registre el id: "));
        String nombre=JOptionPane.showInputDialog(null, "nombre:");
        int edad=Integer.parseInt(JOptionPane.showInputDialog(null, "edad: "));
        String rol=JOptionPane.showInputDialog(null, "rol:");
        String password=JOptionPane.showInputDialog(null, "contraseña:");
        Usuario u=new Usuario(id,nombre,edad,rol,password);
        service.guardarDatosEnLista(u, usuarios, "Los_Usuarios");
    }
    
    public void crearUsuario(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Registre el id: "));
        String nombre=JOptionPane.showInputDialog(null, "nombre:");
        int edad=Integer.parseInt(JOptionPane.showInputDialog(null, "edad: "));
        String rol="usuario";
        String password=JOptionPane.showInputDialog(null, "contraseña:");
        Usuario u=new Usuario(id,nombre,edad,rol,password);
        service.guardarDatosEnLista(u, usuarios, "Los_Usuarios");
    }
    
    public void enlistar(){
        service.enlistarDatos(usuarios,"Los_Usuarios");
    }
    
    public void buscarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a buscar: "));
        Usuario u=service.buscarObjetoPorId(id, usuarios, Usuario.class, "Los_Usuarios");
        System.out.println("=====================");
        System.out.println("");
        System.out.println("id: "+u.getId());
        System.out.println("nombre: "+u.getNombre());
        System.out.println("edad: "+u.getEdad());
        System.out.println("rol: "+u.getRol());
        System.out.println("contraseña: "+u.getPassword());
        System.out.println("");
    }
    
    public Usuario retornarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a buscar: "));
        Usuario u=service.buscarObjetoPorId(id, usuarios, Usuario.class, "Los_Usuarios");
        System.out.println("=====================");
        System.out.println("");
        System.out.println("id: "+u.getId());
        System.out.println("nombre: "+u.getNombre());
        System.out.println("edad: "+u.getEdad());
//        System.out.println("rol: "+u.getRol());
//        System.out.println("contraseña: "+u.getPassword());
        System.out.println("");
        return u;
    }
    
    public void eliminarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a eliminar: "));
        service.eliminarObjetoPorId(id, usuarios, Usuario.class, "Los_Usuarios");
    }
    
    public void modificarPorId(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el id a eliminar: "));
        String nombre=JOptionPane.showInputDialog(null, "nombre:");
        int edad=Integer.parseInt(JOptionPane.showInputDialog(null, "edad: "));
        String rol=JOptionPane.showInputDialog(null, "rol:");
        String password=JOptionPane.showInputDialog(null, "contraseña:");
        Usuario u=new Usuario(id,nombre,edad,rol,password);
        service.modificarObjetoPorId(id, usuarios, Usuario.class, "Los_Usuarios",u);
    }
}
