package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;

public class DTODatosCompletosAspirante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5545931475282915955L;


	private DTOAspirante aspirante;
	
	
	private Integer registroFUAR;


	public Integer getRegistroFUAR() {
		return registroFUAR;
	}


	public void setRegistroFUAR(Integer registroFUAR) {
		this.registroFUAR = registroFUAR;
	}


	public DTOAspirante getAspirante() {
		return aspirante;
	}


	public void setAspirante(DTOAspirante aspirante) {
		this.aspirante = aspirante;
	}
	
	
	
	
	
	
}
