/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dguilcapi
 */
public class SQLAPP {
    
    @SuppressWarnings("finally")
	
	public static Connection GetConnection() {
		Connection conexion = null;
		try {
			String url = "";
			String userName = Application.getString("app.bdd.sqlUser");
			String password = Application.getString("app.bdd.sqlPass");
			url = Application.getString("app.bdd.app");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error1 en la Conexi�n con la BD "
					+ ex.getMessage());
			conexion = null;
		} catch (SQLException ex) {
			System.out.println("Error2 en la Conexi�n con la BD "
					+ ex.getMessage());
			conexion = null;
		} catch (Exception ex) {
			System.out.println("Error3 en la Conexi�n con la BD "
					+ ex.getMessage());
			conexion = null;
		} finally {
			return conexion;
		}
	}
    
}
