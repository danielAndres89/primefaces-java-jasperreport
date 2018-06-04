/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.beans;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author dguilcapi
 */

public class PlantillaController implements Serializable{

    private static final long serialVersionUID = 1L;
    private String user;

    /**
     * Creates a new instance of PlantillaController
     */
    public PlantillaController() {
        user="";
    }

    public void verificarSesion(ComponentSystemEvent ev) {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            user = (String) context.getExternalContext().getSessionMap()
                    .get("usuario");
            //System.out.println("USUARIO EN VERIFICAR SESION: " + user);

            if (user != null && !user.equals("")) {
                System.out.println("Manteniendo la sesion iniciada");
            } else {
                context.getExternalContext().redirect("errores/404.xhtml");
            }

        } catch (IOException e1) {

        }
    }

}
