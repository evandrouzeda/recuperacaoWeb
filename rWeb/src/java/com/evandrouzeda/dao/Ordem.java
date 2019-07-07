/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.dao;

import java.io.Serializable;

/**
 *
 * @author evandrouzeda
 */
public class Ordem implements Serializable{
    private String atributo;
    private String label;
    private String operador;

    public Ordem(String atributo, String label, String operador) {
        this.atributo = atributo;
        this.label = label;
        this.operador = operador;
    }

    public String getAtributo() {
        return atributo;
    }

    public String getLabel() {
        return label;
    }

    public String getOperador() {
        return operador;
    }
    
    
}
