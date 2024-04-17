package com.demo.pruebasunitariascabinas.models;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author perez
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud implements Serializable{
    private int id;
    private String fecha;
    private String aceptado;
    private Cabina cabina;
    private Usuario usuario;
    private Usuario superUsuario;

    public Solicitud(int id, String fecha, String aceptado,Cabina cabina ,Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.aceptado = aceptado;
        this.cabina=cabina;
        this.usuario = usuario;
    }
    
}
