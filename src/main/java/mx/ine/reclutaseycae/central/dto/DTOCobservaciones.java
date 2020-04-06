package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;


/**
 * Clase que contiene los atributos necesarios para contener los valores del
 * cat�logo de observaciones.
 * @author irene.lorza
 *
 */
public class DTOCobservaciones implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7701237132620142845L;
	
	/**
	 * Atributo que identifica la observaci�n
	 */
	private Integer idObservacion;
	
	/**
     * Atributo que identifica el dientificador de la captura
     */
    private Character idCaptura;
    
    /**
     * Descripci�n de la observaci�n
     */
    private String descripcion;
    
    /**
     * Identifica la etapa en que se encuentra: 1.- Primera insaculaci�n 2.-
     * Segunda insaculaci�n
     */
    private Integer idCategoria;

    private Integer orden;

	public Integer getIdObservacion() {
		return idObservacion;
	}

	public void setIdObservacion(Integer idObservacion) {
		this.idObservacion = idObservacion;
	}

	public Character getIdCaptura() {
		return idCaptura;
	}

	public void setIdCaptura(Character idCaptura) {
		this.idCaptura = idCaptura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "DTOCobservaciones [idObservacion=" + idObservacion + ", idCaptura=" + idCaptura + ", descripcion="
				+ descripcion + ", idCategoria=" + idCategoria + ", orden=" + orden + "]";
	}

    
    
}
