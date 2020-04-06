package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;

public class DTOfiltrosConsultaAspirante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -877657161892834756L;

	private Integer folio;
	private Integer claveElector;
	private Integer estatusRegistro;
	private Integer bObservacion;
	private Integer bAcudirJDE;
	private Integer bPlatica;
	private Integer bValidaCorreo;
	
	
	
	
	/*getters y setters*/
	public Integer getEstatusRegistro() {
		return estatusRegistro;
	}
	public void setEstatusRegistro(Integer estatusRegistro) {
		this.estatusRegistro = estatusRegistro;
	}
	public Integer getbObservacion() {
		return bObservacion;
	}
	public void setbObservacion(Integer bObservacion) {
		this.bObservacion = bObservacion;
	}
	public Integer getbAcudirJDE() {
		return bAcudirJDE;
	}
	public void setbAcudirJDE(Integer bAcudirJDE) {
		this.bAcudirJDE = bAcudirJDE;
	}
	public Integer getbPlatica() {
		return bPlatica;
	}
	public void setbPlatica(Integer bPlatica) {
		this.bPlatica = bPlatica;
	}
	public Integer getbValidaCorreo() {
		return bValidaCorreo;
	}
	public void setbValidaCorreo(Integer bValidaCorreo) {
		this.bValidaCorreo = bValidaCorreo;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public Integer getClaveElector() {
		return claveElector;
	}
	public void setClaveElector(Integer claveElector) {
		this.claveElector = claveElector;
	}
	
	
	
	
}
