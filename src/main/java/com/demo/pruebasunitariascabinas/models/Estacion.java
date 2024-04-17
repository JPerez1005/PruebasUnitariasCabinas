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
public class Estacion implements Serializable{
    private int id;
    private String nombre;
}
