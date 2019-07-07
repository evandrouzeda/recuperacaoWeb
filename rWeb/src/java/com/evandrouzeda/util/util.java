/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author evandrouzeda
 */
public class util {
    public static String getMensagemErro(Exception e){
            while (e.getCause() != null){
                if(e.getCause() instanceof Exception) //pode ser java.lang.StackOverflowError
                    e = (Exception) e.getCause();
            }
            String retorno = e.getMessage();
            if (retorno.contains("viola restrição de chave estrangeira")){
                    retorno = "Registro não pode ser excluido por possuir uma referência "
                                    + "em outras partes do sistema";
            }
            return retorno;
    }

    public static void mensagemInformacao(String mensagem){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.getExternalContext().getFlash().setKeepMessages(true);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,"");
            contexto.addMessage(null, msg);
    }

    public static void mensagemErro(String mensagem){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.getExternalContext().getFlash().setKeepMessages(true);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem,"");
            contexto.addMessage(null, msg);
    }    
}
