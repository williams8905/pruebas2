/**
 * @(#)CustomUserDetailsService.java 23/06/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.ine.servicio.admin.dto.DTOResultado;
//import mx.ine.servicio.admin.exception.ServiceAdminLdapException;
//import mx.ine.servicio.admin.dto.DTOResultado;
import mx.ine.servicio.admin.exception.ServiceAdminLdapException;
import mx.ine.servicio.admin.mb.MBServicioAdminLdap;
import mx.ine.reclutaseycae.central.dto.DTOUsuarioLogin;
import mx.ine.reclutaseycae.central.enums.EnumRol;
import mx.ine.reclutaseycae.central.util.Constantes;

/**
 * Clase encargada de procesar la informaci&oacute;n del usuario que desea ingresar al sistema.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 23/06/2017
 */

@Service("userDetailsService")
//@CommonsLog
public class CustomUserDetailsService implements UserDetailsService {

    private static List<String> grupos;

    static {
        grupos = new ArrayList<>();
        grupos.add(EnumRol.ADMIN.getDescripcionRol());
        grupos.add(EnumRol.CAPTURA.getDescripcionRol());
    }
	
	  /*@Autowired
	  
	  @Qualifier("asServicioAdminLdap") private ASServicioAdminLdapInterface
	  asServicioAdminLdap;*/
	 
	@Autowired
	@Qualifier(value = "mbServicioAdminLdap")
	MBServicioAdminLdap mbServicioAdminLdap;

    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * Funci&oacute;n que obtiene la informaci&oacute;n completa del usuario
     *
     * @param authentication objeto con la informaci&oacute;n ingresada en la autenticaci&oacute;n del usuario.
     *
     * @return objeto con la informaci&oacute;n del usuario autenticado.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 23/06/2017
     */
    public UserDetails cargarUsuario(Authentication authentication) throws UsernameNotFoundException {
        // Se obtienen datos de autenticacion
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails user = null;
        // Se realiza autenticacion
        if(seleccionarTipoUsuario(username) == Constantes.USUARIO_JDE) {
        	user =  autenticacionLDAP(authentication);
        }else {
        	user = autenticacionUsuariosExternos(authentication);
        }
		return user;
        
       
       
    }
    
    /*Este metodo selecciona el tipo de usuario que esta pidiendo loguearse*/
    public boolean seleccionarTipoUsuario(String usuario) {
    	boolean tipoUsuario = false;
    	if(usuario!=null && usuario.contains(".")) {
    		tipoUsuario = Constantes.USUARIO_JDE;
    	}else{
    		tipoUsuario = Constantes.USUARIO_ONLINE;
    	}    	
		return tipoUsuario;
    }
    
    
    public UserDetails autenticacionLDAP(Authentication authentication) throws UsernameNotFoundException{
    	String username = authentication.getName();
        String password = authentication.getCredentials().toString();
    	try {
            // Informacion servicio LDAP
        	DTOResultado resultado = mbServicioAdminLdap.getDTO(username, password);
            
            // Valida resultado
            validaResultado(resultado);
            
            // Obtener informacion del usuario
            Set<GrantedAuthority> authorities = obtenerPermisos(resultado.getRoles());
            
            DTOUsuarioLogin user = new DTOUsuarioLogin(username, "", true, true, true, true, authorities);
            user.setRolesUsuario(resultado.getRoles());
            
            // Informacion general
            obtenerInfoGeneral(user, resultado);
            
            // si es nulo, es interno. Si no lo es, es externo
            if (resultado.getTipoAsc() != null) {
            	user.setAreaAdscripcion("area generica"
            			/*daoAreasAdministrativas.buscarPorId(resultadoFinal.getTipoAsc().
            			 * shortValue()).getDescripcionArea()
            			 * 
            			 * 
            			 */);
            }
            return user;
        } 
        catch (ServiceAdminLdapException ex) {
            //log.warn("Warn CustomUserDetailsService - cargaUsuario(): ", ex);
            throw new BadCredentialsException(ex.getMessage());
        }
        catch (BadCredentialsException ex) {
            //log.error("Error CustomUserDetailsService - Al obtener la informaci\u00F3n de Usuario: ", ex);
            throw ex;
        } catch (Exception ex) {
            //log.error("Error CustomUserDetailsService - Al obtener la informaci\u00F3n de Usuario: ", ex);
            throw new BadCredentialsException("mensaje_login_credenciales_invalidas");
        }
    }
    /**
     * Este metodo realiza la autenticacion de la tabla de base de datos, los usuarios que se registraron
     * y que tienen un folio(usuario) y clave de elector(password)
     * @param authentication
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails autenticacionUsuariosExternos(Authentication authentication) throws UsernameNotFoundException{
    	DTOUsuarioLogin user = null;
    	try {
    		//WS BD
    		 user.getAreaAdscripcion(); // TODO metodo busqueda de usuario
		} catch (Exception e) {
			 throw new BadCredentialsException("mensaje_login_credenciales_invalidas");
		}
    	return user;
    }
    
    public UserDetails cargarUsuarioToken(DTOResultado usuario) {
    	Set<GrantedAuthority> authorities = obtenerPermisos(usuario.getRoles());
    	
    	DTOUsuarioLogin user = new DTOUsuarioLogin(usuario.getUid(), "", true, true, true, true, authorities);
    	user.setIdEstado(usuario.getIdEdo());
    	user.setEstado(usuario.getEstado());
    	user.setIdDistrito(usuario.getIdDto());
    	user.setDistrito(usuario.getDistrito());
    	user.setNombre(usuario.getCn());
    	user.setPuesto(usuario.getTituloPersonal());
    	user.setTipoAsociacion(usuario.getTipoAsc());
    	user.setAreaAdscripcion(usuario.getOu());
    	user.setMail(usuario.getMail());
//    	user.setIp(obtenerIP());
    	user.setRolesUsuario(usuario.getRoles());
        user.setIdAsociacion(usuario.getIdAsociacion());
    	
    	return user;
    }

    /**
     * Metodo encargado de validar el resultado del servicio LDAP
     *
     * @param resultadoFinal objeto con la infromaci&oacute;n del usuario
     *
     * @author Jos&eacute; Antonio L&oacute;pez Torres
     * @since 29/06/2017
     */
    private void validaResultado(DTOResultado resultadoFinal) {
    	
        if (resultadoFinal == null) {
//            if (resultadoFinal == null || CollectionUtils.isEmpty(resultadoFinal.getRoles())) {
            throw new BadCredentialsException("mensaje_login_credenciales_invalidas");
       }
    }

    /**
     * Funci&oacute;n que convierte los roles de LDAP en GrantedAuthority para el manejor en spring security
     *
     * @param roles Roles LDAP
     *
     * @return Set<GrantedAuthority> Roles LDAP
     *
     * @author Jos&eacute; Antonio L&oacute;pez Torres
     * @since 20/02/2017
     */
    private Set<GrantedAuthority> obtenerPermisos(List<String> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        for (String rol : roles) {
            StringBuilder sb = new StringBuilder();
            sb.append(Constantes.LDAP_ROL).append(rol);
            GrantedAuthority authority = new CustomGrantedAuthority(sb.toString());
            authorities.add(authority);
        }

        return authorities;
    }

    /**
     * Metodo encargado de obtener el rol de uuario autenticado
     *
     * @param user  usuario
     * @param roles roles LDAP
     *
     * @author Jos&eacute; Antonio L&oacute;pez Torres
     * @since 29/06/2017
     */
    private void obtenerRol(DTOUsuarioLogin user, List<String> roles) {
//        user.setRolesLdap(roles);
//        user.setRolUsuario(localizaRol(roles));
    }

    /**
     * Funci&oacute;n que localiza los roles LDAP
     *
     * @param roles roles del usuario
     *
     * @return rol rol LDAP
     *
     * @author Jos&eacute; Antonio L&oacute;pez Torres
     * @since 13/02/2017
     */
    private String localizaRol(List<String> roles) {
        return roles.stream()
                .filter(arg -> arg.toUpperCase().contains(Constantes.ROLES_SISTEMA))
//                .filter(arg -> arg.toUpperCase().contains(Constantes.ROLES_SISTEMA))
                .findFirst().orElse(null);
    }

    /**
     * Metodo encargado de obtener la informaci&oacuten general de usuario
     *
     * @param user           usuario
     * @param resultadoFinal objeto con informaci&oacuten del usuario
     *
     * @author Jos&eacute; Antonio L&oacute;pez Torres
     * @since 29/06/2017
     */
    private void obtenerInfoGeneral(DTOUsuarioLogin user, DTOResultado resultadoFinal) {
        user.setIdEstado(resultadoFinal.getIdEdo() == null ? 0 : resultadoFinal.getIdEdo());
        user.setEstado(resultadoFinal.getEstado());
        user.setIdDistrito(resultadoFinal.getIdDto() == null ? 0 : resultadoFinal.getIdDto());
        user.setDistrito(resultadoFinal.getDistrito());
        user.setNombre(resultadoFinal.getCn());
        user.setPuesto(resultadoFinal.getTituloPersonal());
        user.setTipoAsociacion(resultadoFinal.getTipoAsc());
        user.setAreaAdscripcion(resultadoFinal.getOu());
        user.setMail(resultadoFinal.getMail());
        user.setIp(obtenerIP());
    }

    /**
     * Metodo encargado de obtener la ip del usuario
     *
     * @return ip
     *
     * @author Jos&eacute; Antonio L&oacute;pez Torres
     * @since 22/01/2018
     */
    private String obtenerIP() {
        String ip = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (StringUtils.isBlank(ip)) {
            ip = httpServletRequest.getRemoteAddr();
        }
        return ip;
    }

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
