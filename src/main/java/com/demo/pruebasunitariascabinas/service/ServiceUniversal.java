package com.demo.pruebasunitariascabinas.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author perez
 */
public class ServiceUniversal<T> {

    public void guardarDatosEnLista(T clase, List<T> datos, String nombre_archivo) {
        datos = cargarDatosDesdeArchivo(nombre_archivo, new ArrayList<>());
        datos.add(clase);
        guardarDatosEnArchivo(nombre_archivo, datos);
    }

    public void enlistarDatos(List<T> datos, String nombreArchivo) {
        datos = cargarDatosDesdeArchivo(nombreArchivo, datos);
        datos.forEach(dato -> {
            Class<?> clazz = dato.getClass();
            System.out.println("========================");
            Arrays.stream(clazz.getDeclaredFields())
                    .forEach(field -> {
                        try {
                            String nombreCampo = field.getName();
                            Method getter = clazz.getMethod("get" + Character.toUpperCase(nombreCampo.charAt(0)) + nombreCampo.substring(1));
                            Object valor = getter.invoke(dato);
                            System.out.println(nombreCampo + ": " + valor);
                        } catch (Exception e) {
                            System.err.println("Error al acceder al campo: " + e.getMessage());
                        }
                    });
            System.out.println("========================");
        });
    }

    public T buscarObjetoPorId(int id, List<T> datos, Class<T> clase, String nombreArchivo) {
        datos = cargarDatosDesdeArchivo(nombreArchivo, datos);
        return datos.stream()
                .filter(dato -> clase.isInstance(dato))
                .filter(dato -> {
                    try {
                        Method getIdMethod = clase.getMethod("getId");
                        int idElemento = (int) getIdMethod.invoke(dato);
                        return idElemento == id;
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        System.err.println("Error al acceder al método getId: " + e.getMessage());
                        return false;
                    }
                })
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("No se encontró ningún elemento con el ID " + id);
                    return null;
                });
    }

    public void eliminarObjetoPorId(int id, List<T> datos, Class<T> clase, String nombreArchivo) {
        T objeto = buscarObjetoPorId(id, datos, clase, nombreArchivo);
        if (objeto != null) {
            datos.remove(objeto); // Elimina el objeto de la lista si se encuentra
            guardarDatosEnArchivo(nombreArchivo, datos); // Guarda los datos actualizados en el archivo
            JOptionPane.showMessageDialog(null, "datos eliminados", "peligro", 3);
        } else {
            System.out.println("No se encontró ningún objeto con el ID " + id);
        }
    }

    public void modificarObjetoPorId(int id, List<T> datos, Class<T> clase, String nombreArchivo, T nuevoObjeto) {
        T objeto = buscarObjetoPorId(id, datos, clase, nombreArchivo);
        if (objeto != null) {
            int indice = datos.indexOf(objeto); // Obtiene el índice del objeto en la lista
            if (indice != -1) { // Verifica si se encontró el objeto en la lista
                datos.set(indice, nuevoObjeto); // Reemplaza el objeto antiguo con el nuevo objeto
                guardarDatosEnArchivo(nombreArchivo, datos); // Guarda los datos actualizados en el archivo
                JOptionPane.showMessageDialog(null, "Datos modificados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún objeto con el ID " + id, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void guardarDatosEnArchivo(String nombreArchivo, List<T> datos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(datos);
            System.out.println("Los datos de los usuarios se han guardado en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos de las usuarios en el archivo: " + e.getMessage());
        }
    }

    public ArrayList<T> cargarDatosDesdeArchivo(String nombreArchivo, List<T> datos) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            datos = (ArrayList<T>) ois.readObject();
            System.out.println("Los datos de los usuarios se han cargado desde el archivo " + nombreArchivo);
            return (ArrayList<T>) datos;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos de las cabinas desde el archivo: " + e.getMessage());
            System.out.println("Le enviaremos los datos vacios");
            return (ArrayList<T>) datos;
        }
    }

    public void cargarDatosDesdeArchivo2(String nombreArchivo, List<T> datos) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            List<T> datosCargados = (ArrayList<T>) ois.readObject();
            datos.addAll(datosCargados);
            System.out.println("Los datos se han cargado desde el archivo " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos desde el archivo: " + e.getMessage());
        }
    }

}
