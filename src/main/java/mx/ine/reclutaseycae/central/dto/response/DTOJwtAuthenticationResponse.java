/**
 * @(#)DTOJwtAuthenticationResponse.java 26/06/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.dto.response;

/**
 * Clase para englobar la respuesta de autenticaci&oacute;n al usuario.
 *
 * @author INE
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 22/08/2018
 */
public class DTOJwtAuthenticationResponse {
	/**
	 * Contiene el JWT.
	 */
	// @Getter @Setter

	private String accessToken;

	/**
	 * Rol del usuario.
	 */
	// @Getter @Setter
//	private String rol;

	private String causa;

	private String message;

	private Integer code;
	
	private String estatus;

	/**
	 * Constructor con el JWT.
	 *
	 * @author INE
	 * @since 22/08/2018
	 * @param accessToken JWT.
	 */
	public DTOJwtAuthenticationResponse(Integer code, String estatus, String accessToken) {
		this.code = code;
		this.estatus = estatus;
		this.accessToken = accessToken;
//		this.rol = rol;
	}

	public DTOJwtAuthenticationResponse(Integer code, String estatus, String message, String causa) {
		super();
		this.code = code;
		this.estatus = estatus;
		this.message = message;
		this.causa = causa;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

//	public String getRol() {
//		return rol;
//	}
//
//	public void setRol(String rol) {
//		this.rol = rol;
//	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}