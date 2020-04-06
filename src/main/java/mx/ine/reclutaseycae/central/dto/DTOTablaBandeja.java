package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;
import java.util.List;

public class DTOTablaBandeja implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1701660698522506874L;
	
	List<DTOColumnasTablaBandeja> columnas;
	List<DTODataTablaBandeja> datos;
	
	
	
	public List<DTOColumnasTablaBandeja> getColumnas() {
		return columnas;
	}
	public void setColumnas(List<DTOColumnasTablaBandeja> columnas) {
		this.columnas = columnas;
	}
	public List<DTODataTablaBandeja> getDatos() {
		return datos;
	}
	public void setDatos(List<DTODataTablaBandeja> datos) {
		this.datos = datos;
	}
	
}
