package com.cid.model;

import java.util.HashMap;
import java.util.Map;

import com.cid.reports.AbstractReportBean;

public class ReportsBean extends AbstractReportBean {

	private final String COMPILE_FILE_NAME;
	private String codCia;
	private String codDocument;
	private String codTipo;

	public ReportsBean(String codCia, String codDocument, String codTipo) {

		this.codCia = codCia;
		this.codDocument = codDocument;
		this.codTipo = codTipo;

		if (codTipo.equalsIgnoreCase("OC"))
			COMPILE_FILE_NAME = "rptOrdenCompra";
		else
			COMPILE_FILE_NAME = "rptSolicitud";

		System.out.println(COMPILE_FILE_NAME);

	}

	@Override
	protected String getCompileFileName() {
		return COMPILE_FILE_NAME;
	}

	@Override
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> reportParameters = new HashMap<String, Object>();

		if (this.codTipo.equalsIgnoreCase("OC")) {
			reportParameters.put("OC", this.codDocument);
			reportParameters.put("Cia", this.codCia);
		} else {
			reportParameters.put("NumeroSolicitud", this.codDocument);
			reportParameters.put("Cia", this.codCia);
		}

		return reportParameters;
	}

	public String execute() {
		try {
			System.out.println("INICIA EJECUTAR GENERAR PDF: "
					+ this.codDocument + "   " + this.codCia);

			super.prepareReport(this.codDocument, this.codCia, this.codTipo);
		} catch (Exception e) {
			// make your own exception handling
			e.printStackTrace();
		}

		return null;
	}
}
