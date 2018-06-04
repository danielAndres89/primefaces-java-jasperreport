package com.cid.reports;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.cid.dao.Application;
import com.cid.dao.SQLDAO;
import com.cid.reports.ReportConfigUtil;
import com.cid.utils.MensajesInformacion;
import com.cid.utils.MensajesPagina;

public abstract class AbstractReportBean extends SQLDAO {

	public enum ExportOption {

		PDF
	}

	private ExportOption exportOption;
	private final String COMPILE_DIR = "/";
	private String message;

	public AbstractReportBean() {
		super();
		setExportOption(ExportOption.PDF);
	}

	protected void prepareReport(String numDocument, String cia, String tipo)
			throws JRException, IOException {

		System.out.println(numDocument + "----" + cia);

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();

		ServletContext context = (ServletContext) externalContext.getContext();
		ReportConfigUtil.compileReport(context, getCompileDir(),
				getCompileFileName());
		File reportFile = new File(ReportConfigUtil.getJasperFilePath(context,
				getCompileDir(), getCompileFileName() + ".jasper"));
		Connection conn = null;
		try {
			if (cia.equalsIgnoreCase("001") || cia.equalsIgnoreCase("002"))
				if (tipo.equalsIgnoreCase("OC"))
					conn = SQLDAO.GetConnection("1");
				else
					conn = SQLDAO.GetConnectionSolicitud();
			else if (cia.equalsIgnoreCase("005")) {
				if (tipo.equalsIgnoreCase("OC"))
					conn = SQLDAO.GetConnection("2");
				else
					conn = SQLDAO.GetConnectionSolicitud();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		JasperPrint jasperPrint = ReportConfigUtil.fillReport(reportFile,
				getReportParameters(), conn);
		JasperExportManager.exportReportToPdfFile(jasperPrint,
				Application.getString("app.ftp.directorioDescarga")
						+ numDocument + " generadoApp.pdf");

		MensajesPagina
				.mostrarMensajeInformacion(MensajesInformacion.DOCUMENTO_GENERADO);

	}

	public ExportOption getExportOption() {
		return exportOption;
	}

	public void setExportOption(ExportOption exportOption) {
		this.exportOption = exportOption;
	}

	protected Map<String, Object> getReportParameters() {
		return new HashMap<String, Object>();
	}

	protected String getCompileDir() {
		return COMPILE_DIR;
	}

	protected abstract String getCompileFileName();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
