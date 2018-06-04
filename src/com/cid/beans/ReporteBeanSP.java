package com.cid.beans;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import com.cid.model.ReportsBean;

public class ReporteBeanSP implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ciaSelected;
	private String codDoc;

	public ReporteBeanSP() {
		ciaSelected = "001";
		codDoc = "";

	}

	public void generarDocumento(ActionEvent actionEvent) {

		System.out.println("Inicia Generar Documento");

		ReportsBean rb = new ReportsBean(ciaSelected, codDoc, "SP");
		rb.execute();

	}

	public String getCiaSelected() {
		return ciaSelected;
	}

	public void setCiaSelected(String ciaSelected) {
		this.ciaSelected = ciaSelected;
	}

	public String getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(String codDoc) {
		this.codDoc = codDoc;
	}

}
