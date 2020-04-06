package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;

/**
 * Clase que contiene el modelo de C_PARAMETROS
 * Para obtener el rango de captura de fechas.
 * @author irene.lorza
 *
 */
public class DTOCFechasCaptura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3641358737946367138L;
	
	
	
	/**
     * valor del id estado
     */
    private Integer idEstado;
    
    /**
     * valor del id DISTRITO.
     */
    private Integer idDistrito;
    
    /**
     * valor de la fecha en c_parametros.
     */
    private String fecha;
    
    
    
    

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	@Override
	public String toString() {
		return "HELPFechasCaptura [idEstado=" + idEstado + ", idDistrito=" + idDistrito + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDistrito == null) ? 0 : idDistrito.hashCode());
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOCFechasCaptura other = (DTOCFechasCaptura) obj;
		if (idDistrito == null) {
			if (other.idDistrito != null)
				return false;
		} else if (!idDistrito.equals(other.idDistrito))
			return false;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		return true;
	}
    
    
    
    
    
    

}
