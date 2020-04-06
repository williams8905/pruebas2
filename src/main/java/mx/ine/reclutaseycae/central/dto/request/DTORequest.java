/**
 * @(#)DTOLoginRequest.java 26/06/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.dto.request;

/**
 * Clase para englobar la respuesta de autenticaci&oacute;n. 
 *
 * @author INE
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 22/08/2018
 */	
public class DTORequest {
	/**
	 * Usuario
	 */
	//@Getter @Setter 
	private String usuario;
	/**
	 * Contrase&ntilde;a
	 */
	
	//@Getter @Setter 
	private String password;
	
    private String versionAplicacion;
    
    private Integer idSistema;
    
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVersionAplicacion() {
		return versionAplicacion;
	}
	public void setVersionAplicacion(String versionAplicacion) {
		this.versionAplicacion = versionAplicacion;
	}
	public Integer getIdSistema() {
		return idSistema;
	}
	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}
	
	
}