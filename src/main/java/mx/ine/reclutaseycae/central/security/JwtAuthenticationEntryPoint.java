/**
 * @(#)ConfigApplication.java 22/08/2018
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Manejador de petici&oacute;n sin autorizaci&oacute;.
 *
 * @author INE
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 22/08/2018
 */
@Component
//@CommonsLog
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException e) throws IOException, ServletException {
		//log.error("Sin acceso", e);
		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Sin acceso");
	}
}
