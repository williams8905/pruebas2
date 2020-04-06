/**
 * @(#)JwtTokenProvider.java 22/08/2018
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import mx.ine.reclutaseycae.central.dto.DTOUsuarioLogin;
import mx.ine.reclutaseycae.central.util.Constantes;
import mx.ine.servicio.admin.dto.DTOResultado;

/**
 * Construye el JWT.
 * 
 * @author INE
 * @copyright Direcci&oacute;n de Sistemas - INE
 * @since 22/08/2018
 */
@Component
//@CommonsLog
public class JwtTokenProvider {
	/**
	 * Llave para firmar el JWT.
	 */
	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	/**
	 * Tiempo de vida del JWT.
	 */
	@Value("${app.jwtExpirationInMs}")
	private long jwtExpirationInMs;
	
	/**
	 * Genera el JWT
	 *
	 * @param authentication bean de autenticaci&oacute;n.
	 * @return JWT construido.
	 *
	 * @author INE
	 * @since 22/08/2018
	 */
	public String generateToken(DTOUsuarioLogin usuario) {
//		DTOUsuarioLogin usuario = (DTOUsuarioLogin) authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		Map<String, Object> claims = new HashMap<>();
		
		claims.put(Constantes.NOMBRE, usuario.getNombre());
		claims.put(Constantes.ID_ESTADO, usuario.getIdEstado());
		claims.put(Constantes.ID_DISTRITO, usuario.getIdDistrito());
		claims.put(Constantes.ROL, usuario.getRolesUsuario());
		claims.put(Constantes.PUESTO, usuario.getPuesto());
		claims.put(Constantes.CORREO, usuario.getMail());
		claims.put(Constantes.AREA_ADSCRIPCION, usuario.getAreaAdscripcion());

		usuario.setRolesUsuario(null);//Los roles ya vienen usuario.getAuthorities()
		return Jwts.builder()
					.setSubject(usuario.getUsername())
					.addClaims(claims)
					.setIssuedAt(new Date())
					.setExpiration(expiryDate)
					.signWith(SignatureAlgorithm.HS512, jwtSecret)
					.compact();
	}
	
	/**
	 * Obtiene el usuario contenido en el JWT.
	 *
	 * @param token JWT.
	 * @return usuario.
	 *
	 * @author INE
	 * @since 22/08/2018
	 */
	@SuppressWarnings("unchecked")
	public DTOResultado getUserFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody();
		DTOResultado dtoResultado = new DTOResultado();
//		((List<String>) claims.get(Constantes.ROL)).replaceAll(rol -> rol.replace("ROLE_", "") );
		
		dtoResultado.setUid(claims.getSubject());
		dtoResultado.setCn((String)claims.get(Constantes.NOMBRE));
		dtoResultado.setIdEdo((Integer)claims.get(Constantes.ID_ESTADO));
		dtoResultado.setIdDto((Integer)claims.get(Constantes.ID_DISTRITO));
		dtoResultado.setRoles((List<String>) claims.get(Constantes.ROL)) ;
		dtoResultado.setTituloPersonal((String)claims.get(Constantes.PUESTO));
		dtoResultado.setOu((String)claims.get(Constantes.AREA_ADSCRIPCION));
		dtoResultado.setMail((String)claims.get(Constantes.CORREO));
		
		return dtoResultado;
		
		/*
    	DTOUsuarioLogin user = new DTOUsuarioLogin(claims.getSubject(), "", true, true, true, true, (Collection<GrantedAuthority>) claims.get(Constantes.ROL));
    	user.setIdEstado((Integer)claims.get(Constantes.ID_ESTADO));
    	user.setIdDistrito((Integer)claims.get(Constantes.ID_DISTRITO));
    	user.setNombre((String)claims.get(Constantes.NOMBRE));
    	user.setPuesto((String)claims.get(Constantes.PUESTO));
    	user.setAreaAdscripcion((String)claims.get(Constantes.AREA_ADSCRIPCION));
    	user.setMail((String)claims.get(Constantes.CORREO));
//    	user.setIp(obtenerIP());
    	return user;
 */
	}
	
	/**
	 * Valida el JWT recibido.
	 *
	 * @param authToken JWT
	 * @return si es v&aacute;lido o no el JWT
	 *
	 * @author INE
	 * @since 22/08/2018
	 */
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			
			return true;
		} catch(SignatureException ex) {
			//log.error("Firma de token invalido");
		} catch(MalformedJwtException ex) {
			//log.error("Token invalido");
		} catch(ExpiredJwtException ex) {
			//log.error("Token caducado");
		} catch(UnsupportedJwtException ex) {
			//log.error("Token no soportado");
		} catch(IllegalArgumentException ex) {
			//log.error("Usuario de token invalido");
		}
		
		return false;
	}
}