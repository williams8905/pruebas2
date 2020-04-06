package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;

public class DTODataTablaBandeja implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4278648227132332928L;

	String key;
	
	String nombre;
	
	String folio;
	
	String claveElector;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getClaveElector() {
		return claveElector;
	}

	public void setClaveElector(String claveElector) {
		this.claveElector = claveElector;
	}
	
	
	
}
