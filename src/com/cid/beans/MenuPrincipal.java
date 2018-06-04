/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.beans;

import com.cid.dao.MenuDAO;
import com.cid.model.Menu;
import com.cid.utils.MensajesError;
import com.cid.utils.MensajesPagina;
import com.cid.utils.Redirect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dguilcapi
 */
//@Named(value = "menuPrincipal")
@SessionScoped
public class MenuPrincipal implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    MenuDAO menuDao;
    private List<Menu> menus;
    private List<Menu> subMenus;
    private String pagina;
    private String user;
    private String codMenu;
    private int maxTime;


    /**
     * Creates a new instance of MenuPrincipal
     */
    public MenuPrincipal() {
        menuDao = new MenuDAO();
        menus = new ArrayList<Menu>();
        maxTime = 600; //30 minutos
        HttpSession miSession = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(maxTime);

        obtenerMenus();
        
    }

    @PostConstruct
    public void init() {
        obtenerMenus();
    }

    public void obtenerMenus() {
        user = (String) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario");
        System.out.println("USUARIO EN MENU ES: " + user);
        try {
            menus = menuDao.obtenerMenus(user, "0", 7);
        } catch (Exception ex) {
            if (menus == null) {
                menus = new ArrayList<Menu>();
                System.out.checkError();

                MensajesPagina.mostrarMensajeError(MensajesError.ERROR_MENU);
                
            }
        }
    }

    public String navegar() {

        System.out.println(codMenu);
//        subMenus = new ArrayList<>();
//        subMenus = obtenerMenus(user.getNombrUsuario(), codMenu, 2);
//
//        System.out.println("SUBMENUS: " + subMenus.size());

        System.out.println("Redirecciona a " + pagina);

        Redirect.redireccionar("paginas/" + pagina);
        return null;
    }

    public String navInicio() {
        return "inicio.xhtml";
    }

    public String navMenuBack() {
        return "menu?faces-redirect=true";
    }

    public List<Menu> getMenus() {
        if (menus == null) {
            init();
        }
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(String codMenu) {
        this.codMenu = codMenu;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

}
