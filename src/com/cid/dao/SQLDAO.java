package com.cid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLDAO {
	@SuppressWarnings("finally")
	public static Connection GetConnection(String tipoCia) {

		String url = "";
		String userName = "";
		String password = "";

		System.out.println("EL TIPO PARA LA CONEXION ES: " + tipoCia);
		Connection conexion = null;

		if (tipoCia.equalsIgnoreCase("1")) {

			userName = Application.getString("app.bdd.sqlUser");
			password = Application.getString("app.bdd.sqlPass");
			url = Application.getString("app.bdd.sqlfcid");

		} else if (tipoCia.equalsIgnoreCase("2")) {

			userName = Application.getString("app.bdd.sqlUser");
			password = Application.getString("app.bdd.sqlPass");
			url = Application.getString("app.bdd.sqlblen");

		}

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(url, userName, password);

			// conexion = DriverManager.getConnection(url);

		} catch (ClassNotFoundException ex) {
			System.out.println("Error 1 Connection con la BD "
					+ ex.getMessage());
			conexion = null;
		} catch (SQLException ex) {
			System.out.println("Error 2  Connection con la BD "
					+ ex.getMessage());
			conexion = null;
		} catch (Exception ex) {
			System.out.println("Error 3  Connection con la BD "
					+ ex.getMessage());
			conexion = null;
		} finally {
			return conexion;
		}
	}

	@SuppressWarnings("finally")
	public static Connection GetConnectionSolicitud() {
		Connection conexion = null;

		try {
			String url = "";
			String userName = Application.getString("app.bdd.sqlUser");
			String password = Application.getString("app.bdd.sqlPass");
			url = Application.getString("app.bdd.sqlSolic");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(url, userName, password);

			// conexion = DriverManager.getConnection(url);

		} catch (ClassNotFoundException ex) {
			System.out.println("Error 1 Connection BDD "
					+ ex.getMessage());
			conexion = null;
		} catch (SQLException ex) {
			System.out.println("Error 2 Connection BDD "
					+ ex.getMessage());
			conexion = null;
		} catch (Exception ex) {
			System.out.println("Error 3 Connection BDD "
					+ ex.getMessage());
			conexion = null;
		} finally {
			return conexion;
		}
	}

}
