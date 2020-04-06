/**
 * 
 */
package mx.ine.reclutaseycae.central.dto.db.geofrafico;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author guadalupe.burgos
 *
 */
@Cacheable(true)
@Entity
@Table(schema = "GEOGRAFICOINE", name = "ESTADOS")
public class DTOEstado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9168921108504167824L;

	@Id
	@Column(name = "ID_ESTADO", nullable = false, precision = 2, scale = 0)
	private Integer idEstado;
	
//	@Id
	@Column(name = "ID_CORTE", nullable = false, precision = 2, scale = 0)
	private Integer idCorte;

	@Column(name = "NOMBRE_ESTADO", nullable = true, length = 50)
	private String nombreEstado;

	@Column(name = "ABREVIATURA", nullable = true, length = 6)
	private String abreviatura;

	@Column(name = "ID_CIRCUNSCRIPCION", nullable = false, precision = 1, scale = 0)
	private Integer idCircunscripcion;

	@Column(name = "CIRCUNSCRIPCION", nullable = true, length = 3)
	private String circunscripcion;

	/**
	 * @return the idEstado
	 */
	public Integer getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	/**
	 * @return the idCorte
	 */
	public Integer getIdCorte() {
		return idCorte;
	}

	/**
	 * @param idCorte the idCorte to set
	 */
	public void setIdCorte(Integer idCorte) {
		this.idCorte = idCorte;
	}

	/**
	 * @return the nombreEstado
	 */
	public String getNombreEstado() {
		return nombreEstado;
	}

	/**
	 * @param nombreEstado the nombreEstado to set
	 */
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
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
	 * @return the idCircunscripcion
	 */
	public Integer getIdCircunscripcion() {
		return idCircunscripcion;
	}

	/**
	 * @param idCircunscripcion the idCircunscripcion to set
	 */
	public void setIdCircunscripcion(Integer idCircunscripcion) {
		this.idCircunscripcion = idCircunscripcion;
	}

	/**
	 * @return the circunscripcion
	 */
	public String getCircunscripcion() {
		return circunscripcion;
	}

	/**
	 * @param circunscripcion the circunscripcion to set
	 */
	public void setCircunscripcion(String circunscripcion) {
		this.circunscripcion = circunscripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCorte, idEstado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOEstado other = (DTOEstado) obj;
		return Objects.equals(idCorte, other.idCorte) && Objects.equals(idEstado, other.idEstado);
	}

}
