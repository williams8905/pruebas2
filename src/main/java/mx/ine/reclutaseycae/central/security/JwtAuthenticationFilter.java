/**
 * @(#)JwtAuthenticationFilter.java 22/08/2018
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import mx.ine.servicio.admin.dto.DTOResultado;

//import mx.ine.servicio.admin.dto.DTOResultado;

/**
 * Filtro para validar el JWT.
 * @author INE
 * @copyright Direcci&oacute;n de Sistemas - INE
 * @since 22/08/2018
 */
//@CommonsLog
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
    private JwtTokenProvider tokenProvider;
	
	@Autowired
    private CustomUserDetailsService customUserDetailsService;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			if (request.getMethod().equalsIgnoreCase(RequestMethod.OPTIONS.name()))
				return;
			
			String jwt = getJwtFromRequest(request);
			
			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
				
				DTOResultado user = tokenProvider.getUserFromJWT(jwt);
				
				UserDetails userDetails = customUserDetailsService.cargarUsuarioToken(user);
				
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch(Exception ex) {
			System.out.println("--------->>> Error al autenticar al usuario en el contexto de seguridad");
			System.out.println("--------->>> Error > " + ex);
			//log.error("Error al autenticar al usuario en el contexto de seguridad", ex);
		}
		
		filterChain.doFilter(request,  response);
	}
	
	/**
	 * Recupera el JWT de la petici&oacute;n.
	 *
	 * @param request petici&oacute;n.
	 * @return JWT.
	 *
	 * @author INE
	 * @since 22/08/2018
	 */
	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken)) {
            return bearerToken;
        }
        return null;
	}
}
