/**
 * 
 */
package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author guadalupe.burgos
 *
 */
@Entity
@Table(schema = "SUPYCAP", name = "C_MEDIOS_DIFUSION")
public class DTOCMedioDifusion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -284788315084727839L;
	
	@Id
	@Column(name = "ID_MEDIO_DIFUSION", unique = true, nullable = false, precision = 2, scale = 0)
	private Integer idMedioDifusion;
	
	@Column(name = "DESCRIPCION_MEDIO", nullable = false, length = 50)
	private String descripcionMedio;
	
	@Column(name = "ABREVIATURA", length = 5)
	private String abreviatura;
	
	@Column(name = "UNIDAD_MEDIDA", nullable = false, length = 60)
	private String unidadMedida;
	
	@Column(name = "TIPO", nullable = false, length = 1)
	private String tipo;

	/**
	 * @return the idMedioDifusion
	 */
	public Integer getIdMedioDifusion() {
		return idMedioDifusion;
	}

	/**
	 * @param idMedioDifusion the idMedioDifusion to set
	 */
	public void setIdMedioDifusion(Integer idMedioDifusion) {
		this.idMedioDifusion = idMedioDifusion;
	}

	/**
	 * @return the descripcionMedio
	 */
	public String getDescripcionMedio() {
		return descripcionMedio;
	}

	/**
	 * @param descripcionMedio the descripcionMedio to set
	 */
	public void setDescripcionMedio(String descripcionMedio) {
		this.descripcionMedio = descripcionMedio;
	}

	/**
	 * @return the abreviatura
	 */
	public String getAbreviatura() {
		return abreviatura;
	}

	/**
	 * @param abreviatura the abreviatura to set
	 */
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedioDifusion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOCMedioDifusion other = (DTOCMedioDifusion) obj;
		return Objects.equals(idMedioDifusion, other.idMedioDifusion);
	}

}
