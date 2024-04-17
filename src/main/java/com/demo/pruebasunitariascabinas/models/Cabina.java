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
public class Cabina implements Serializable{

    private int id;
    private int capacidad_maxima;
    private String estado;
    private Estacion estacion_origen;
    private Estacion estacion_destino;

}
