/**
 * 
 */
package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author guadalupe.burgos
 *
 */
@Embeddable
public class DTOAspiranteConMedioId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 135000725240130575L;

	@Basic(optional = false)
	@Column(name = "ID_DETALLE_PROCESO", nullable = false, precision = 7, scale = 0)
    private int idDetalleProceso;
	
	@Basic(optional = false)
    @Column(name = "ID_PARTICIPACION", nullable = false, precision = 9, scale = 0)
    private int idParticipacion;
    
	@Basic(optional = false)
    @Column(name = "ID_ASPIRANTE", nullable = false, precision = 5, scale = 0)
    private int idAspirante;
    
	@Basic(optional = false)
    @Column(name = "ID_MEDIO_DIFUSION", nullable = false, precision = 2, scale = 0)
    private Integer idMedioDifusion;

	/**
	 * @return the idDetalleProceso
	 */
	public int getIdDetalleProceso() {
		return idDetalleProceso;
	}

	/**
	 * @param idDetalleProceso the idDetalleProceso to set
	 */
	public void setIdDetalleProceso(int idDetalleProceso) {
		this.idDetalleProceso = idDetalleProceso;
	}

	/**
	 * @return the idParticipacion
	 */
	public int getIdParticipacion() {
		return idParticipacion;
	}

	/**
	 * @param idParticipacion the idParticipacion to set
	 */
	public void setIdParticipacion(int idParticipacion) {
		this.idParticipacion = idParticipacion;
	}

	/**
	 * @return the idAspirante
	 */
	public int getIdAspirante() {
		return idAspirante;
	}

	/**
	 * @param idAspirante the idAspirante to set
	 */
	public void setIdAspirante(int idAspirante) {
		this.idAspirante = idAspirante;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(idAspirante, idDetalleProceso, idMedioDifusion, idParticipacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOAspiranteConMedioId other = (DTOAspiranteConMedioId) obj;
		return idAspirante == other.idAspirante && idDetalleProceso == other.idDetalleProceso
				&& Objects.equals(idMedioDifusion, other.idMedioDifusion) && idParticipacion == other.idParticipacion;
	}
	
}
