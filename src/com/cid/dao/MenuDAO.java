/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.dao;

import com.cid.model.Menu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dguilcapi
 */

public class MenuDAO {

    private Connection miConexion;
    private List<Menu> menus = new ArrayList<Menu>();
    private List<Menu> subMenus = new ArrayList<Menu>();

    public List<Menu> obtenerMenus(String user, String padre, int codApp) {
        menus = new ArrayList<Menu>();
        menus = obtener(user, padre, codApp);
        for (int x = 0; x < menus.size(); x++) {
            subMenus = new ArrayList<Menu>();
            subMenus = obtener(user, menus.get(x).getCode(), codApp);
            menus.get(x).setLstSubmenus(subMenus);
        }
        return menus;
    }

    public List<Menu> obtener(String usuario, String padre, int app) {

        CallableStatement procedimiento = null;
        List<Menu> tmp = new ArrayList<Menu>();
        try {
            miConexion = SQLAPP.GetConnection();
            if (miConexion != null) {
                procedimiento = miConexion
                        .prepareCall("{call PROC_PERFIL_USUARIO(?,?,?)}");
                procedimiento.setString(1, usuario);
                procedimiento.setString(2, padre);
                procedimiento.setInt(3, app);
                procedimiento.execute();
                ResultSet rs;
                rs = procedimiento.getResultSet();

                while (rs.next()) {
                    Menu temp = new Menu();
                    temp.setCode(rs.getString(1));
                    temp.setName(rs.getString(2));
                    temp.setUrl(rs.getString(3));
                    temp.setIcon(rs.getString(4));
                    temp.setDescription(rs.getString(5));
                    tmp.add(temp);
                }
            }
        } catch (SQLException e) {
            tmp = null;
        } finally {
            try {
                miConexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block

            }
        }

        return tmp;

    }

}
