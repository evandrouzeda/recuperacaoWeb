/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.controle;

import com.evandrouzeda.dao.DepartamentoDAO;
import com.evandrouzeda.modelo.Departamento;
import com.evandrouzeda.util.util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author evandrouzeda
 */
@Named(value = "controleDepartamento")
@ViewScoped
public class ControleDepartamento implements Serializable {

    @EJB
    private DepartamentoDAO dao;

    private Departamento objeto;

    public ControleDepartamento() {

    }

    public String listar() {
        return "/privado/departamento/index?faces-redirect=true";
    }

    public void novo() {
        objeto = new Departamento();
    }

    public DepartamentoDAO getDao() {
        return dao;
    }

    public void alterar(Object id) {
        try {
            setObjeto(dao.getObjectById(id));
        } catch (Exception e) {
            util.mensagemErro("Erro ao recuperar objeto: "
                    + util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            setObjeto(dao.getObjectById(id));
            dao.remover(getObjeto());
            util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            util.mensagemErro("Erro ao remover objeto: "
                    + util.getMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (getObjeto().getId() == null) {
                dao.persist(getObjeto());
            } else {
                dao.merge(getObjeto());
            }
            util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            util.mensagemErro("Erro ao persistir objeto: "
                    + util.getMensagemErro(e));
        }
    }

    public Departamento getObjeto() {
        return objeto;
    }

    public void setObjeto(Departamento objeto) {
        this.objeto = objeto;
    }
}
