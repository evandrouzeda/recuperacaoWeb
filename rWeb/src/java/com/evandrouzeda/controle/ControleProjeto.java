/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.controle;

import com.evandrouzeda.dao.DepartamentoDAO;
import com.evandrouzeda.dao.ProjetoDAO;
import com.evandrouzeda.dao.TipoDAO;
import com.evandrouzeda.modelo.Departamento;
import com.evandrouzeda.modelo.Projeto;
import com.evandrouzeda.modelo.Tipo;
import com.evandrouzeda.util.util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author evandrouzeda
 */
@Named(value = "controleProjeto")
@ViewScoped
public class ControleProjeto implements Serializable {

    @EJB
    private ProjetoDAO dao;

    private Projeto objeto;

    @EJB
    private TipoDAO tipoDAO;

    private Tipo tipo;

    @EJB
    private DepartamentoDAO departamentoDAO;

    private Departamento departamento;

    public ControleProjeto() {

    }

    public String listar() {
        return "/privado/projeto/index?faces-redirect=true";
    }

    public void novo() {
        objeto = new Projeto();
    }

    public ProjetoDAO getDao() {
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

    public Projeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Projeto objeto) {
        this.objeto = objeto;
    }

    public DepartamentoDAO getDepartamentoDAO() {
        return departamentoDAO;
    }

    public void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public TipoDAO getTipoDAO() {
        return tipoDAO;
    }

    public void setTipoDAO(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
