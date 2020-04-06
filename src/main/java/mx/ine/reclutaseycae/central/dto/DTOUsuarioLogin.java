/**
 * @(#)DTOUsuarioLogin.java 26/06/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Clase que contiene los datos del usuario que se autentica.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 26/06/2017
 */

public class DTOUsuarioLogin extends User implements Serializable {

	/**
	 * Elemento para la serializaci&oacute;n de los objetos generados por esta clase
	 */
	private static final long serialVersionUID = -4336100606417681594L;

	/**
	 * Id Estado al que pertenece el usuario.
	 */
	private Integer idEstado;

	private String estado;
	
	private String distrito;
	
	/**
	 * Nombre completo del usuario
	 */
	private String nombre;

	/**
	 * Id distrito al que pertenece el usuario.
	 */
	private Integer idDistrito;
	
	

	/**
	 * Rol que el usuario tiene dentro del sistema.
	 */
	private List<String> rolesUsuario;

	/**
	 * Id asociacion
	 */
	private Integer idAsociacion;

	/**
	 * Tipo asociacion
	 */
	private Integer tipoAsociacion;

	/**
	 * Id sistema
	 */
	private Integer idSistema;

	/**
	 * Ip del usuario
	 */
	private String ip;

	/**
	 * &Aacute;rea a la que pertenece el usuario
	 */
	private String areaAdscripcion;

	/**
	 * Puesto del usuario.
	 */
	private String puesto;

	/**
	 * Correo electr&oacute;nico.
	 */
	private String mail;
	
	private String tknJWT;
	
	private Integer idProcesoElectoral;
	
	private Integer IdDetalle;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}

	public List<String> getRolesUsuario() {
		return rolesUsuario;
	}

	public void setRolesUsuario(List<String> rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}

	public Integer getIdAsociacion() {
		return idAsociacion;
	}

	public void setIdAsociacion(Integer idAsociacion) {
		this.idAsociacion = idAsociacion;
	}

	public Integer getTipoAsociacion() {
		return tipoAsociacion;
	}

	public void setTipoAsociacion(Integer tipoAsociacion) {
		this.tipoAsociacion = tipoAsociacion;
	}

	public Integer getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAreaAdscripcion() {
		return areaAdscripcion;
	}

	public void setAreaAdscripcion(String areaAdscripcion) {
		this.areaAdscripcion = areaAdscripcion;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getTknJWT() {
		return tknJWT;
	}

	public void setTknJWT(String tknJWT) {
		this.tknJWT = tknJWT;
	}

	/*
	 * Constructor con par&aacute;metros que incializa los datos del usuario en
	 * sesi&oacute;n.
	 *
	 * @param username usuario de sesi&oacute;n.
	 * 
	 * @param password password del usuario de sesi&oacute;n.
	 * 
	 * @param enabled indicador si usuario est&aacute; habilitado.
	 * 
	 * @param accountNonExpired indicador de expiraci&oacute;n del usuario.
	 * 
	 * @param credentialsNonExpired indicador de expiraci&oacute;n del password.
	 * 
	 * @param accountNonLocked indicador de bloqueo del usuario.
	 * 
	 * @param authorities lista de roles asociados al usuario.
	 *
	 * @author Jos&eacute; Carlos Ortega Romano
	 * 
	 **/
	public DTOUsuarioLogin(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public Integer getIdProcesoElectoral() {
		return idProcesoElectoral;
	}

	public void setIdProcesoElectoral(Integer idProcesoElectoral) {
		this.idProcesoElectoral = idProcesoElectoral;
	}

	public Integer getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		IdDetalle = idDetalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


}
