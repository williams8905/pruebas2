package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Fecha de creación: 24/07/2019
* Copyright (c) 2019 Instituto Nacional Electoral
* 
* CEtiquetas.java
*
* @author Julio Lopez
* @version 1.0
*/

@Entity
@Table(name = "MOV_BITACORA_LOGIN", schema = "APLICACIONES_MOVILES")
public class DTOCMov_Bitacora_login implements Serializable {
	private static final long serialVersionUID = -8331644139842153592L;

	/**
	 * Identificador de la bitacora
	 */
	@Id
	@Column(name = "ID_BITACORA", unique = true, nullable = false, precision = 5, scale = 0)
	private Integer idBitacora;
	
	/**
	 * Identificador del Usuario 
	 */
	@Id
	@Column(name = "USUARIO", unique = true, nullable = false, precision = 50, scale = 0) //	@Column(name = "TIPO_JUNTA", unique = true, nullable = false, precision = 2, scale = 0)
	private String usuario;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "FECHA_LOGUEO", nullable = false)
	private Date fechaLogueo;
	
	/**
	 * Fecha y hora del cierra de sesion
	 *  
	 */
	@Column(name = "FECHA_CIERRE_SESION", nullable = true)
	private Date fechaCierredeSesion;

	/**
	 * Version de la aplicacion que consume el servicio
	 *  
	 */
	@Column(name = "VERSION_APLICACION", unique = true, nullable = false, precision = 50, scale = 0)
	private String versionAplicacion;
	
	/**
	 * Estatus en que se encuentra el usuario
	 * 0: inactivo, 1: activo 
	 */
	@Column(name = "ESTATUS", unique = true, nullable = false, precision = 1, scale = 0)
	private Integer estatus;

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getIdBitacora() {
		return idBitacora;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setIdBitacora(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}

	/**
	 * Método que obtiene el valor de el atributo usuario
	 *
	 * @return String : valor que tiene el atributo usuario
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Método que ingresa el valor de el atributo usuario
	 *
	 * @param etiqueta : valor que ingresa a el atributo usuario
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Método que obtiene el valor de el atributo fechaLogueo
	 *
	 * @return Date : valor que tiene el atributo fechaLogueo
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Date getFechaLogueo() {
		return fechaLogueo;
	}
	
	/**
	 * Método que ingresa el valor de el atributo fechaLogueo
	 *
	 * @param etiqueta : valor que ingresa a el atributo fechaLogueo
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setFechaLogueo(Date fechaLogueo) {
		this.fechaLogueo = fechaLogueo;
	}

	/**
	 * Método que obtiene el valor de el atributo fechaCierredeSesion
	 *
	 * @return Date : valor que tiene el atributo fechaCierredeSesion
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Date getFechaCierredeSesion() {
		return fechaCierredeSesion;
	}

	/**
	 * Método que ingresa el valor de el atributo fechaCierredeSesion
	 *
	 * @param etiqueta : valor que ingresa a el atributo fechaCierredeSesion
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setFechaCierredeSesion(Date fechaCierredeSesion) {
		this.fechaCierredeSesion = fechaCierredeSesion;
	}

	/**
	 * Método que obtiene el valor de el atributo versionAplicacion
	 *
	 * @return String : valor que tiene el atributo versionAplicacion
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public String getVersionAplicacion() {
		return versionAplicacion;
	}

	/**
	 * Método que ingresa el valor de el atributo versionAplicacion
	 *
	 * @param etiqueta : valor que ingresa a el atributo versionAplicacion
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setVersionAplicacion(String versionAplicacion) {
		this.versionAplicacion = versionAplicacion;
	}

	/**
	 * Método que obtiene el valor de el atributo estatus
	 *
	 * @return Integer : valor que tiene el atributo estatus
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * Método que ingresa el valor de el atributo estatus
	 *
	 * @param etiqueta : valor que ingresa a el atributo estatus
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaCierredeSesion == null) ? 0 : fechaCierredeSesion.hashCode());
		result = prime * result + ((fechaLogueo == null) ? 0 : fechaLogueo.hashCode());
		result = prime * result + ((idBitacora == null) ? 0 : idBitacora.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((versionAplicacion == null) ? 0 : versionAplicacion.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOCMov_Bitacora_login other = (DTOCMov_Bitacora_login) obj;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (fechaCierredeSesion == null) {
			if (other.fechaCierredeSesion != null)
				return false;
		} else if (!fechaCierredeSesion.equals(other.fechaCierredeSesion))
			return false;
		if (fechaLogueo == null) {
			if (other.fechaLogueo != null)
				return false;
		} else if (!fechaLogueo.equals(other.fechaLogueo))
			return false;
		if (idBitacora == null) {
			if (other.idBitacora != null)
				return false;
		} else if (!idBitacora.equals(other.idBitacora))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (versionAplicacion == null) {
			if (other.versionAplicacion != null)
				return false;
		} else if (!versionAplicacion.equals(other.versionAplicacion))
			return false;
		return true;
	}

	
}