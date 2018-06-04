/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.beans;

import com.cid.utils.Redirect;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;

/**
 *
 * @author dguilcapi
 */
public class UsuarioDataManager implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean ingreso;
    private String usuario;

    /**
     * Creates a new instance of UsuarioDataManager
     */
    public UsuarioDataManager() {
        this.ingreso = false;
        usuario = "";
    }

    /**
     * Cierra la sesion del usuario y redirige al Login
     *
     */
    public String logout() {
        Map<String, Object> session = FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap();
        System.out.println("****-----****---- ESTO ME TRAE EL MAPA DE SESIONES: " + session);
        // session.remove("permisosDataManager");
        // session.remove("usuarioDataManager");
		for (String clave : session.keySet()) {
			System.out.println("//**//**//**//** elimina: " + clave);
			session.remove(clave);
		}
		System.out.println("MAPA QUE TIENE: " + session);
		Redirect.redireccionar("login.xhtml");
		return "login.xhtml";
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

}
