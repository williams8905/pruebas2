/**
 * @(#)CustomAuthenticationProvider.java 23/06/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

//import mx.ine.servicio.admin.exception.ServiceAdminLdapException;

/**
 * Clase encargada de recuperar la informaci&oacute;n del usuario que esta intentando ingresar al sistema.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 23/06/2017
 */
@Service("authenticationProvider")
//@CommonsLog
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    @Qualifier("userDetailsService")
    private CustomUserDetailsService userDetailsService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws BadCredentialsException {
        try {
            UserDetails userDetails = userDetailsService.cargarUsuario(authentication);

            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//        } catch (ServiceAdminLdapException e) {
        } catch (Exception e) {
           // log.error("Error CustomAuthenticationProvider - authenticate(): ", e);
            throw new BadCredentialsException(e.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
