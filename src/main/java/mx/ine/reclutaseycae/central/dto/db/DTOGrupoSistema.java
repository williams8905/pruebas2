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
* DTOGrupoSistema.java
*
* @author Julio.Lopez
* @version 1.0
*/

@Entity
@Table(name = "GRUPOS_SISTEMAS", schema = "APLICACIONES_MOVILES")
public class DTOGrupoSistema implements Serializable {
	private static final long serialVersionUID = -8331644139842153592L;

	/**
	 * Identificador de la bitacora
	 */
	@Id
	@Column(name = "ID_SISTEMA", unique = true, nullable = false, precision = 3, scale = 0)
	private Integer idSistema;
	
	/**
	 * Identificador del Usuario 
	 */
	@Id
	@Column(name = "ID_GRUPO", unique = true, nullable = false, precision = 2, scale = 0) 	
	private Integer idGrupo;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "GRUPOS", unique = true, nullable = false, precision = 50, scale = 0) 
	private String grupo;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "DESCRIPCION", unique = true, nullable = false, precision = 300, scale = 0) 
	private String descripcion;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "VERSION_ROL", unique = true, nullable = false, precision = 2, scale = 0) 	
	private Integer versionRol;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "TIPO_ACCESO", unique = true, nullable = false, precision = 1, scale = 0) 	
	private Integer tipoAcceso;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "ID_TIPO_GRUPO", unique = true, nullable = false, precision = 2, scale = 0) 	
	private Integer idTipoGrupo;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "TIPO_CUENTA", unique = true, nullable = false, precision = 1, scale = 0) 
	private String tipoCuenta;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "ID_TIPO_ACTOR", unique = true, nullable = true, precision = 2, scale = 0) 	
	private Integer idTipoActor;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "GRUPO_DEFAULT", unique = true, nullable = true, precision = 1, scale = 0) 
	private String grupoDefault;
	
	/**
	 *Fecha y hora de logueo 
	 *
	 */
	@Column(name = "USUARIO", unique = true, nullable = false, precision = 50, scale = 0) 
	private String usuario;
	
	/**
	 * Fecha y hora del cierra de sesion
	 *  
	 */
	@Column(name = "FECHA_HORA", nullable = false)
	private Date fechaHora;


	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getIdSistema() {
		return idSistema;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getIdGrupo() {
		return idGrupo;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getVersionRol() {
		return versionRol;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setVersionRol(Integer versionRol) {
		this.versionRol = versionRol;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getTipoAcceso() {
		return tipoAcceso;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setTipoAcceso(Integer tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getIdTipoGrupo() {
		return idTipoGrupo;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setIdTipoGrupo(Integer idTipoGrupo) {
		this.idTipoGrupo = idTipoGrupo;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Integer getIdTipoActor() {
		return idTipoActor;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setIdTipoActor(Integer idTipoActor) {
		this.idTipoActor = idTipoActor;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public String getGrupoDefault() {
		return grupoDefault;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setGrupoDefault(String grupoDefault) {
		this.grupoDefault = grupoDefault;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Método que obtiene el valor de el atributo idbitacora
	 *
	 * @return Integer : valor que tiene el atributo etiqueta
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * Método que ingresa el valor de el atributo idBitacora
	 *
	 * @param etiqueta : valor que ingresa a el atributo idBitacora
	 *
	 * @author Julio Lopez
	 * @since 24/07/2019
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((grupoDefault == null) ? 0 : grupoDefault.hashCode());
		result = prime * result + ((idGrupo == null) ? 0 : idGrupo.hashCode());
		result = prime * result + ((idSistema == null) ? 0 : idSistema.hashCode());
		result = prime * result + ((idTipoActor == null) ? 0 : idTipoActor.hashCode());
		result = prime * result + ((idTipoGrupo == null) ? 0 : idTipoGrupo.hashCode());
		result = prime * result + ((tipoAcceso == null) ? 0 : tipoAcceso.hashCode());
		result = prime * result + ((tipoCuenta == null) ? 0 : tipoCuenta.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((versionRol == null) ? 0 : versionRol.hashCode());
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
		DTOGrupoSistema other = (DTOGrupoSistema) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (grupoDefault == null) {
			if (other.grupoDefault != null)
				return false;
		} else if (!grupoDefault.equals(other.grupoDefault))
			return false;
		if (idGrupo == null) {
			if (other.idGrupo != null)
				return false;
		} else if (!idGrupo.equals(other.idGrupo))
			return false;
		if (idSistema == null) {
			if (other.idSistema != null)
				return false;
		} else if (!idSistema.equals(other.idSistema))
			return false;
		if (idTipoActor == null) {
			if (other.idTipoActor != null)
				return false;
		} else if (!idTipoActor.equals(other.idTipoActor))
			return false;
		if (idTipoGrupo == null) {
			if (other.idTipoGrupo != null)
				return false;
		} else if (!idTipoGrupo.equals(other.idTipoGrupo))
			return false;
		if (tipoAcceso == null) {
			if (other.tipoAcceso != null)
				return false;
		} else if (!tipoAcceso.equals(other.tipoAcceso))
			return false;
		if (tipoCuenta == null) {
			if (other.tipoCuenta != null)
				return false;
		} else if (!tipoCuenta.equals(other.tipoCuenta))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (versionRol == null) {
			if (other.versionRol != null)
				return false;
		} else if (!versionRol.equals(other.versionRol))
			return false;
		return true;
	}


	
}