package mx.ine.reclutaseycae.central.enums;


import java.util.Arrays;

import mx.ine.reclutaseycae.central.util.Constantes;

/**
 * @author INE
 * @copyright Direcci&oacute;n de Sistemas - INE
 * @since 17/10/2018
 */
public enum EnumRol {
	/**
	 * Rol de administrador: CUESTIONARIOS.ADMIN.OC
	 */
	ADMIN(Constantes.ROLES_SISTEMA+"ADMIN.OC"),
	/**
	 * Rol de captura: CUESTIONARIOS.ADMIN.CAPTURA
	 */
	CAPTURA(Constantes.ROLES_SISTEMA+"ADMIN.CAPTURA");
	
	/**
	 * Descripci&oacute;n del rol
	 */
	/*@Getter*/
	private final String descripcionRol;
	
	public String getDescripcionRol() {
		return descripcionRol;
	}

	/**
	 * Constructor para inicializar los valores del enum.
	 *
	 * @author INE
	 * @since 17/10/2018
	 * @param descripcionRol
	 */
	private EnumRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	public static EnumRol getByDescripcion(String descripcionRol) {
		return Arrays.stream(values())
				.filter(rol -> rol.descripcionRol.equals(descripcionRol.replaceAll(Constantes.LDAP_ROL, "")))
				.findFirst()
				.map(rol -> rol )
				.orElse(null);
	}
}