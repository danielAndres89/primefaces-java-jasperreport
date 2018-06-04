package com.cid.dao;


public class WsDAO {

//	private MainWebServiceProxy proxyAcces;
//	private Producto[] lstProductos;
//	private ProductoKardex[] lstProductoKardex;
//	private BinCard[] lstDatosBinCard;
//	private EntradaPlanta[] lstDatosIncio;
//	private EntradaPlanta[] lstDatosAnalisis;
//	private Ubicacion[] lstDatosUbicacion;
//	private AprobacionAnalisis[] lstInfoReanalisis;
//	private AprobacionAnalisis aprobacionAnalisis;
//
//	private int resultado;
//
//	public WsDAO() {
//
//		proxyAcces = new MainWebServiceProxy();
//		lstProductos = null;
//		lstProductoKardex = null;
//		lstDatosBinCard = null;
//		lstDatosIncio = null;
//		lstDatosAnalisis = null;
//		lstDatosUbicacion = null;
//		lstInfoReanalisis = null;
//		aprobacionAnalisis = new AprobacionAnalisis();
//		resultado = 0;
//
//	}
//
//	public Producto[] obtenerProductos() {
//
//		lstProductos = null;
//		try {
//			lstProductos = proxyAcces.traerProductos();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return lstProductos;
//
//	}
//
//	public ProductoKardex[] obtenerKardex(String codProducto,
//			String numEntradaPlanta, boolean mostrarStock) {
//		lstProductoKardex = null;
//		try {
//			lstProductoKardex = proxyAcces.traerInfoKardex(codProducto,
//					numEntradaPlanta, mostrarStock);
//			System.out.println(lstProductoKardex.length);
//		} catch (Exception e) {
//			System.out.println("Se cayo obtenerKardex");
//			lstProductoKardex = null;
//			e.printStackTrace();
//		}
//		return lstProductoKardex;
//
//	}
//
//	public BinCard[] obtenerDatosBinCard(String codProducto, String codLote,
//			String codEntrada, String anio) {
//		lstDatosBinCard = null;
//		try {
//			lstDatosBinCard = proxyAcces.traerDatosBinCard(codProducto,
//					codLote, codEntrada, anio);
//		} catch (Exception e) {
//			lstDatosBinCard = null;
//			System.out.println("genera error a obtenerdatos bincard");
//			e.printStackTrace();
//		}
//
//		return lstDatosBinCard;
//	}
//
//	public EntradaPlanta[] obtenerIncioEntradaPlanta(String codProducto,
//			String codLote, String codEntrada, String anio) {
//
//		lstDatosIncio = null;
//		try {
//			lstDatosIncio = proxyAcces.datosInicialesEntradaPlanta(codProducto,
//					codLote, codEntrada, anio);
//		} catch (Exception e) {
//			lstDatosIncio = null;
//			e.printStackTrace();
//		}
//
//		return lstDatosIncio;
//	}
//
//	public EntradaPlanta[] obtenerDatosAnalisis(String codProducto,
//			String codLote, String codEntrada) {
//
//		lstDatosAnalisis = null;
//
//		try {
//			lstDatosAnalisis = proxyAcces.traerDatosAnalisis(codProducto,
//					codLote, codEntrada);
//		} catch (Exception e) {
//			lstDatosAnalisis = null;
//			e.printStackTrace();
//		}
//
//		return lstDatosAnalisis;
//
//	}
//
//	public Ubicacion[] obtenerUbicacion(String idProducto, String numEntrada) {
//
//		lstDatosUbicacion = null;
//		try {
//			lstDatosUbicacion = proxyAcces.traerDatosUbicacion(idProducto,
//					numEntrada);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			lstDatosUbicacion = null;
//			e.printStackTrace();
//		}
//
//		return lstDatosUbicacion;
//	}
//
//	public int actualizarUbicacion(int tipo, String localizacion,
//			String observacion, String fecha, String usuario, String codigo,
//			String ep, String lote) {
//		resultado = 0;
//		try {
//			resultado = proxyAcces
//					.insertActualDatosUbicacion(tipo, localizacion,
//							observacion, fecha, usuario, codigo, ep, lote);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return resultado;
//
//	}
//
//	public int aprobarAnalisis(AprobacionAnalisis obj) {
//		resultado = 0;
//		try {
//			resultado = proxyAcces.insertAprobacionAnalisis(obj);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return resultado;
//	}
//
//	public AprobacionAnalisis[] obtenerInfoReanalisis(String codProducto,
//			String codEntradaPlanta) {
//		lstInfoReanalisis = null;
//
//		try {
//			lstInfoReanalisis = proxyAcces.traerInfoReAnalisis(codProducto,
//					codEntradaPlanta);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return lstInfoReanalisis;
//	}
//
//	public AprobacionAnalisis traerAprobacionAnalisis(String codProducto,
//			String numControl, String numEntradaPlanta) {
//
//		aprobacionAnalisis = new AprobacionAnalisis();
//		try {
//			aprobacionAnalisis = proxyAcces.traerAprobacionAnalisis(
//					codProducto, numControl, numEntradaPlanta);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return aprobacionAnalisis;
//
//	}
//
//	public String traerUsuarioAnalisis(String codProducto,
//			String codEntradaPlanta, String anio, String mes) {
//		String nombreAnalista = "";
//		try {
//
//			nombreAnalista = proxyAcces.traerUsuarioReAnalisis(codProducto,
//					codEntradaPlanta, anio, mes);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			nombreAnalista = "";
//		}
//		return nombreAnalista;
//	}

}
