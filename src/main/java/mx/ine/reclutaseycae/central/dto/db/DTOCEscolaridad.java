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
@Table(schema = "SUPYCAP", name = "C_ESCOLARIDADES")
public class DTOCEscolaridad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3049851519506379886L;
	
	@Id
	@Column(name = "ID_ESCOLARIDAD", unique = true, nullable = false, precision = 2, scale = 0)
	private Integer idEscolaridad;
	
	@Column(name = "ID_CAPTURA", nullable = false, precision = 1)
	private String idCaptura;
	
	@Column(name = "DESCRIPCION_ESCOLARIDAD", nullable = false, length = 50)
	private String descripcion;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "escolaridad")
//	private Set<DTOAspirante> aspirantes = new HashSet<DTOAspirante>(0);

	/**
	 * @return the idEscolaridad
	 */
	public Integer getIdEscolaridad() {
		return idEscolaridad;
	}

	/**
	 * @param idEscolaridad the idEscolaridad to set
	 */
	public void setIdEscolaridad(Integer idEscolaridad) {
		this.idEscolaridad = idEscolaridad;
	}

	/**
	 * @return the idCaptura
	 */
	public String getIdCaptura() {
		return idCaptura;
	}

	/**
	 * @param idCaptura the idCaptura to set
	 */
	public void setIdCaptura(String idCaptura) {
		this.idCaptura = idCaptura;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCaptura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOCEscolaridad other = (DTOCEscolaridad) obj;
		return Objects.equals(idCaptura, other.idCaptura);
	}

}
