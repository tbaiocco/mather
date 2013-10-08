package com.nuovonet.mather.util;

public class Utilitaria {

	public static boolean doValidaZeros(String parametro) {
	    return parametro != null
	        && !"0".equals (parametro.trim ())
	        && !"0,00".equals (parametro.trim ())
	        && !"0,000".equals (parametro.trim ())
	        && !"0.00".equals (parametro.trim ())
	        && !"0.000".equals (parametro.trim ())
	        && !"".equals (parametro.trim ())
	        && !"null".equals (parametro.trim ().toLowerCase ());
	  }
	
	public static boolean doValida(String parametro) {
	    return parametro != null
	        && !"".equals (parametro.trim ())
	        && !"null".equals (parametro.trim ().toLowerCase ());
	  }
	
	public static String getValueDef (String value , String vdefault) {
	    return (doValida (value)) ? value : vdefault;
	  }
}
