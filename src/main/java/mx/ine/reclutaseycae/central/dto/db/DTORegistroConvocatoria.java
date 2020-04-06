/**
 * 
 */
package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author guadalupe.burgos
 *
 */
@Entity
@Table(schema = "SUPYCAP", name = "REGISTRO_CONVOCATORIAS")
public class DTORegistroConvocatoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4939826003975779793L;
	
	@EmbeddedId
	private DTORegistroConvocatoriaId id;
	
	@NotNull
	@Column(name = "ID_PROCESO_ELECTORAL", nullable = false, precision = 5, scale = 0)
	private Integer idProcesoElectoral;

	@NotNull
	@Column(name = "NUMERO_CONVOCATORIA", nullable = false, precision = 2, scale = 0)
	private Integer numeroConvocatoria;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO_INICIO", nullable = false, length = 7)
	private Date fechaRegistroInicio;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO_FIN", nullable = false, length = 7)
	private Date fechaRegistroFin;

	@Column(name = "DESCRIPCION_CONVOCATORIA", length = 1500)
	private String descripcionConvocatoria;

	@NotNull
	@Column(name = "USUARIO", nullable = false, length = 50)
	private String usuario;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_HORA", nullable = false)
	private Date fechaHora;
	
	@NotNull
	@Column(name= "IP_USUARIO", nullable = false, length = 15)
	private String ipUsuario;

	/**
	 * @return the id
	 */
	public DTORegistroConvocatoriaId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DTORegistroConvocatoriaId id) {
		this.id = id;
	}
	
	/**
	 * @return the idProcesoElectoral
	 */
	public Integer getIdProcesoElectoral() {
		return idProcesoElectoral;
	}

	/**
	 * @param idProcesoElectoral the idProcesoElectoral to set
	 */
	public void setIdProcesoElectoral(Integer idProcesoElectoral) {
		this.idProcesoElectoral = idProcesoElectoral;
	}

	/**
	 * @return the numeroConvocatoria
	 */
	public Integer getNumeroConvocatoria() {
		return numeroConvocatoria;
	}

	/**
	 * @param numeroConvocatoria the numeroConvocatoria to set
	 */
	public void setNumeroConvocatoria(Integer numeroConvocatoria) {
		this.numeroConvocatoria = numeroConvocatoria;
	}

	/**
	 * @return the fechaRegistroInicio
	 */
	public Date getFechaRegistroInicio() {
		return fechaRegistroInicio;
	}

	/**
	 * @param fechaRegistroInicio the fechaRegistroInicio to set
	 */
	public void setFechaRegistroInicio(Date fechaRegistroInicio) {
		this.fechaRegistroInicio = fechaRegistroInicio;
	}

	/**
	 * @return the fechaRegistroFin
	 */
	public Date getFechaRegistroFin() {
		return fechaRegistroFin;
	}

	/**
	 * @param fechaRegistroFin the fechaRegistroFin to set
	 */
	public void setFechaRegistroFin(Date fechaRegistroFin) {
		this.fechaRegistroFin = fechaRegistroFin;
	}

	/**
	 * @return the descripcionConvocatoria
	 */
	public String getDescripcionConvocatoria() {
		return descripcionConvocatoria;
	}

	/**
	 * @param descripcionConvocatoria the descripcionConvocatoria to set
	 */
	public void setDescripcionConvocatoria(String descripcionConvocatoria) {
		this.descripcionConvocatoria = descripcionConvocatoria;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the ipUsuario
	 */
	public String getIpUsuario() {
		return ipUsuario;
	}

	/**
	 * @param ipUsuario the ipUsuario to set
	 */
	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idProcesoElectoral);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTORegistroConvocatoria other = (DTORegistroConvocatoria) obj;
		return Objects.equals(id, other.id) && Objects.equals(idProcesoElectoral, other.idProcesoElectoral);
	}
	
}
