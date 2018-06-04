/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.dao;

import com.cid.model.Usuario;
import com.cid.utils.ActiveDirectoryAuthentication;
import com.cid.utils.MensajesError;
import com.cid.utils.MensajesInformacion;
import com.cid.utils.MensajesPagina;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dguilcapi
 */
//@Stateless
public class ServicioLogin implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dominio;
    private int maxTime = 0;

    /**
     * Realiza las consultas a la base para comprobar si existe el usuario con
     * esa clave y si esta dentro del rango de fechas.
     *
     * @param usuario
     *
     * @return <code>true</code> Si se encontro al usuario, caso contrario
     * <code>false</code>.
     */
    public boolean autenticar(Usuario usuario) {

        try {
            maxTime = 660;
            dominio = "CIDCORP.COM";
            HttpSession miSession = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(true);
            miSession.setMaxInactiveInterval(maxTime);

            ActiveDirectoryAuthentication authentication = new ActiveDirectoryAuthentication(
                    dominio);
        //System.out.println("SE CONECTO AL DOMINIO: " + dominio);
        //System.out.println("EL USUARIO: " + usuario.getNombrUsuario());
            boolean authResult = authentication.authenticate(
                    usuario.getNombrUsuario(), usuario.getContrUsuario());
                        
            //System.out.print("Autenticación: " + authResult);
            if (authResult) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", usuario.getNombrUsuario());
                MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.USUARIO_EXITO);
                return true;
            } else {
                return false;
            }

        } catch (LoginException ex) {
        	Logger.getLogger(ServicioLogin.class.getName()).log(Level.SEVERE, null, ex);
            
            MensajesPagina.mostrarMensajeError(MensajesError.USUARIO_ERROR);
            return false;
        }
    
    }

}

