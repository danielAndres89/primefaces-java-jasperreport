package com.cid.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.*;

public class FTP {

	private String sFTP = Application.getString("app.ftp.servidor");
	private String sUser = Application.getString("app.ftp.user");
	private String sPassword = Application.getString("app.ftp.pass");
	private FTPClient cliente = new FTPClient();

	public boolean conectarFTP() {

		try {

			cliente.connect(sFTP);
			boolean login = cliente.login(sUser, sPassword);
			System.out.println("CONEXION EXITOSA");

			cliente.enterLocalPassiveMode();

			return login;

		} catch (IOException ioe) {
			System.out.println("ERROR ERROR ERROR ");

		}

		return false;

	}

	public void modoPasivo() {
		cliente.enterLocalPassiveMode();
	}

	public boolean obtenerRespuesta() {
		int respuesta = cliente.getReplyCode();
		boolean obtener = FTPReply.isPositiveCompletion(respuesta);
		return obtener;

	}

	public String directorioActual() {
		try {
			return cliente.printWorkingDirectory();
		} catch (IOException e) {
			System.out.println("IOException =" + e.getMessage());
			return null;
		}
	}

	public void moverDirectorio(String dir) {

		try {
			System.out.println("EXISTE O NO??? " + checkDirectoryExists(dir));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			cliente.changeWorkingDirectory(dir);
			System.out.println("SE MOVIO DE DIRECTORIO");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("NO SE MOVIO DE DIRECTORIO");
			e.printStackTrace();
		}
	}

	int returnCode = cliente.getReplyCode();

	public boolean checkDirectoryExists(String dirPath) throws IOException {
		cliente.changeWorkingDirectory(dirPath);
		System.out.println("SE CAMBIO DE DIRECTORIO, CHECK DIRECTORY");
		returnCode = cliente.getReplyCode();
		if (returnCode == 550) {
			System.out.println("NO SE CAMBIO DE DIRECTORIO, CHECK DIRECTORY");
			return false;
		}
		return true;
	}

	public String[] listarArchivos() {

		String[] lista = null;

		try {

			lista = cliente.listNames();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

	public void descargarArchivo(String nombreArchivo, String nombreOrden,
			String path) {

		try {

			String remoteFile1 = "/" + nombreOrden + "/" + nombreArchivo;
			File downloadFile1 = new File(path + "/" + nombreArchivo);

			System.out.println("remoteFIle1: " + remoteFile1);
			System.out.println("downloadFIle1: " + downloadFile1);

			OutputStream outputStream1 = new BufferedOutputStream(
					new FileOutputStream(downloadFile1));
			boolean success = cliente.retrieveFile(remoteFile1, outputStream1);

			outputStream1.close();

			if (success) {
				System.out.println("File " + nombreArchivo
						+ " has been downloaded successfully.");
			} else {
				System.out.println("File " + nombreArchivo
						+ " has not been downloaded.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean getFichero(String rutaFichero, String rutaLocal) {
		try {
			InputStream in = cliente.retrieveFileStream(rutaFichero);
			byte[] b = new byte[in.available()];
			in.read(b);
			FileOutputStream file = new FileOutputStream(new File(rutaLocal));
			file.write(b);
			file.close();
			in.close();
			return true;
		} catch (IOException e) {
			System.out.println("IOException =" + e.getMessage());
			return false;
		}
	}

	public void subirArchivo(String numOrden) {

		try {

			cliente.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
			BufferedInputStream buffIn = null;
			buffIn = new BufferedInputStream(new FileInputStream(
					Application.getString("app.ftp.directorioDescarga") + "/"
							+ numOrden + " completado.pdf"));
			cliente.enterLocalPassiveMode();
			cliente.storeFile("Approved " + numOrden + ".pdf", buffIn);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void subirSolicitud(String codSolicitud) {

		try {

			cliente.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
			BufferedInputStream buffIn = null;
			buffIn = new BufferedInputStream(new FileInputStream(
					Application
							.getString("app.ftp.directorioDescargaSolicitud")
							+ "/" + codSolicitud + " completado.pdf"));
			cliente.enterLocalPassiveMode();
			cliente.storeFile("Approved " + codSolicitud + ".pdf", buffIn);
			buffIn.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void subirArchivoPDF(String directorioActual, String nombreArchivo) {

		try {
			System.out
					.println("INICIA EL METODO PARA CARGAR DE ARCHIVOS AL FTP");
			System.out.println("ARCHIVO: " + directorioActual + "     NOMBRE: "
					+ nombreArchivo);

			// Activar que se envie cualquier tipo de archivo
			cliente.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
			cliente.setFileTransferMode(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
			cliente.enterLocalPassiveMode();

			BufferedInputStream buffIn = null;
			buffIn = new BufferedInputStream(new FileInputStream(
					directorioActual + "/" + nombreArchivo));

			cliente.storeFile(nombreArchivo, buffIn);
			buffIn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Algo malo sucedio");
		}

	}

	public boolean eliminarArchivoTemp(String archivoRuta) {

		boolean eliminar = false;

		File fichero = new File(archivoRuta);

		if (fichero.delete()) {
			eliminar = true;
		} else {
			eliminar = false;
		}

		return eliminar;
	}

	public void desconectarFTP() {
		try {
			cliente.logout();
			cliente.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void crearDirectorioSolicitud(String codCia, String numSolicitud) {

		try {
			cliente.makeDirectory("sp" + codCia + "-" + numSolicitud);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
