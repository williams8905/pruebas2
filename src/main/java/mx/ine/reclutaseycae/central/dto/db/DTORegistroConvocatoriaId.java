/**
 * @(#)DTORegistroConvocatoriaId.java 29/08/2019
 * <p>
 * Copyright (C) 2019 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
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
public class DTORegistroConvocatoriaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1459140382798261480L;

	@Basic(optional = false)
	@Column(name = "ID_DETALLE_PROCESO", nullable = false, precision = 7, scale = 0)
	private Integer idDetalleProceso;
	
	@Basic(optional = false)
	@Column(name ="ID_PARTICIPACION", nullable = false, precision = 9, scale =0)
	private Integer idParticipacion;

	@Basic(optional = false)
	@Column(name = "ID_CONVOCATORIA", nullable = false, precision = 5, scale = 0)
	private Integer idConvocatoria;

	/**
	 * @return the idDetalleProceso
	 */
	public Integer getIdDetalleProceso() {
		return idDetalleProceso;
	}

	/**
	 * @param idDetalleProceso the idDetalleProceso to set
	 */
	public void setIdDetalleProceso(Integer idDetalleProceso) {
		this.idDetalleProceso = idDetalleProceso;
	}

	/**
	 * @return the idParticipacion
	 */
	public Integer getIdParticipacion() {
		return idParticipacion;
	}

	/**
	 * @param idParticipacion the idParticipacion to set
	 */
	public void setIdParticipacion(Integer idParticipacion) {
		this.idParticipacion = idParticipacion;
	}

	/**
	 * @return the idConvocatoria
	 */
	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}

	/**
	 * @param idConvocatoria the idConvocatoria to set
	 */
	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConvocatoria, idDetalleProceso, idParticipacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTORegistroConvocatoriaId other = (DTORegistroConvocatoriaId) obj;
		return Objects.equals(idConvocatoria, other.idConvocatoria)
				&& Objects.equals(idDetalleProceso, other.idDetalleProceso)
				&& Objects.equals(idParticipacion, other.idParticipacion);
	}
	
}
