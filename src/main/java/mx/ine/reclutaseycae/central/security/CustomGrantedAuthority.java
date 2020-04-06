/**
 * @(#)CustomGrantedAuthority.java 26/06/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Clase que representa las roles obtenidos en LDAP requeridos para validaciones de Spring Security.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 26/06/2017
 */
public class CustomGrantedAuthority implements GrantedAuthority {
    /**
     * Elemento para la serializaci&oacute;n de los objetos generados por esta clase.
     */
    private static final long serialVersionUID = -7955470893228167268L;

    /**
     * Rol
     */
    private String role;

    /**
     * Constructor con par&aacute;metros.
     *
     * @param role rol del usuario.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 26/06/2017
     */
    public CustomGrantedAuthority(String role) {
        this.role = role;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthority() {
        return role;
    }
}
