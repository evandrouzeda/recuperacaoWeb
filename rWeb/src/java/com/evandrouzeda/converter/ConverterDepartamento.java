/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.converter;

import com.evandrouzeda.dao.DepartamentoDAO;
import com.evandrouzeda.modelo.Departamento;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author evandrouzeda
 */
@Named(value = "converterDepartamento")
@RequestScoped
public class ConverterDepartamento implements Serializable, Converter {
    @EJB
    private DepartamentoDAO dao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        return dao.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        Departamento d = (Departamento) value;    
        return d.getId().toString();
    }
}
