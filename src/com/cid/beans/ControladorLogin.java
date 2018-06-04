/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.beans;

import com.cid.dao.ServicioLogin;
import com.cid.model.Usuario;
import com.cid.utils.MensajesError;
import com.cid.utils.MensajesInformacion;
import com.cid.utils.MensajesPagina;
import com.cid.utils.Redirect;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author dguilcapi
 */
//@Named(value = "controladorLogin")
//@ViewScoped
public class ControladorLogin implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@EJB
    private ServicioLogin srvLogin;
    
    private Usuario usuario;
    
    @ManagedProperty(value="#{usuarioDataManager}")
    private UsuarioDataManager usuarioDataManager;

    /**
     * Creates a new instance of ControladorLogin
     */
    public ControladorLogin() {
        usuario = new Usuario();
        srvLogin = new ServicioLogin();
    }

    @PostConstruct
    public void init() {
        try {
            usuarioDataManager.getUsuario();
            System.out.println("Ya esta Logeado, redirigiendo a su pagina por defecto");
            Redirect.redireccionar("index.xhtml");
        } catch (NullPointerException ex) {
            System.out.println("No esta Logeado, continuando normalmente");
        }
    }

    /**
     * Permite autenticar al usuario con las credenciales correspondientes, y
     * llena el DataManager correspondiente.
     */
    public void autenticar() {
        System.out.println("------------------>entra al metodo autenticar");
//        System.out.println("valores " + usuario.getNombrUsuario());
//        System.out.println("valores " + usuario.getContrUsuario());
        
        

        if (srvLogin.autenticar(usuario)) {
            usuarioDataManager = new UsuarioDataManager();
            usuarioDataManager.setUsuario(usuario.getNombrUsuario());
            
            System.out.println("NOMBRE DATAMANAGER " + usuarioDataManager.getUsuario());
            Redirect.redireccionar("index.xhtml");
            MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.USUARIO_EXITO);
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario.getNombrUsuario());
            
        } else {
            usuario.setContrUsuario("");
            MensajesPagina.mostrarMensajeError(MensajesError.USUARIO_ERROR);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setUsuarioDataManager(UsuarioDataManager usuarioDataManager) {
        System.out.println("Se almacena " + usuarioDataManager.getUsuario());
        this.usuarioDataManager = usuarioDataManager;
    }

}
