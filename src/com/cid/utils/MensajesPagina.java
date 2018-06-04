/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dguilcapi
 */
public class MensajesPagina {

    public static void mostrarMensajeError(String mensajeError) {
        FacesContext.getCurrentInstance()
                .addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                mensajeError, ""));
    }

    public static void mostrarMensajeInformacion(String mensajeInfo) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, mensajeInfo, ""));
    }

    public static void mostrarMensajeError(String idComponente,
            String mensajeError) {
        FacesContext.getCurrentInstance()
                .addMessage(
                        idComponente,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                mensajeError, ""));
    }

    public static void mostrarMensajeInformacion(String idComponente,
            String mensajeInfo) {
        FacesContext.getCurrentInstance().addMessage(idComponente,
                new FacesMessage(FacesMessage.SEVERITY_INFO, mensajeInfo, ""));
    }

}
