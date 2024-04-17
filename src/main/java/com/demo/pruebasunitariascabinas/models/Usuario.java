package com.demo.pruebasunitariascabinas.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author perez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable{
    
    private int id;
    private String nombre;
    private int edad;
    private String rol;
    private String password;
    
}
