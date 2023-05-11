package xyz.android.ejercicio03practicacalificada02.model;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private Integer anioNacimiento;

    public Persona(String nombre, Integer anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }
}
