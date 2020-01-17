/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameta.model;

/**
 *
 * @author Cristhian
 */
public class ExtraData {
    private int edad_anos;
    private int edad_meses;
    private int edad_dias;
    private int vinculacion_anos;
    private int vinculacion_meses;
    private int vinculacion_dias;

    public int getEdad_anos() {
        return edad_anos;
    }

    public void setEdad_anos(int edad_anos) {
        this.edad_anos = edad_anos;
    }

    public int getEdad_meses() {
        return edad_meses;
    }

    public void setEdad_meses(int edad_meses) {
        this.edad_meses = edad_meses;
    }

    public int getEdad_dias() {
        return edad_dias;
    }

    public void setEdad_dias(int edad_dias) {
        this.edad_dias = edad_dias;
    }

    public int getVinculacion_anos() {
        return vinculacion_anos;
    }

    public void setVinculacion_anos(int vinculacion_anos) {
        this.vinculacion_anos = vinculacion_anos;
    }

    public int getVinculacion_meses() {
        return vinculacion_meses;
    }

    public void setVinculacion_meses(int vinculacion_meses) {
        this.vinculacion_meses = vinculacion_meses;
    }

    public int getVinculacion_dias() {
        return vinculacion_dias;
    }

    public void setVinculacion_dias(int vinculacion_dias) {
        this.vinculacion_dias = vinculacion_dias;
    }

    public ExtraData() {
    }

    @Override
    public String toString() {
        return "{" + "edad_anos=" + edad_anos + ", edad_meses=" + edad_meses + ", edad_dias=" + edad_dias + ", vinculacion_anos=" + vinculacion_anos + ", vinculacion_meses=" + vinculacion_meses + ", vinculacion_dias=" + vinculacion_dias + '}';
    }
    
}
