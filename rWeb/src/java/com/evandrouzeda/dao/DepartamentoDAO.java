/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.dao;

import com.evandrouzeda.converter.ConverterOrdem;
import com.evandrouzeda.modelo.Departamento;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author evandrouzeda
 */
@Stateful
public class DepartamentoDAO  extends DAOGenerico<Departamento> implements Serializable{

    public DepartamentoDAO() {
        super(Departamento.class);
        
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        ordemAtual = listaOrdem.get(1);
        
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
} 
