package mx.ine.reclutaseycae.central.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Field;

import mx.ine.reclutaseycae.central.controller.WsLogin;
import mx.ine.reclutaseycae.central.dto.DTOCTiposTaller;
import mx.ine.reclutaseycae.central.dto.DTODataTablaBandeja;
import mx.ine.reclutaseycae.central.dto.DTOUsuarioLogin;
import mx.ine.reclutaseycae.central.dto.db.DTOBitacoraAcceso;
import mx.ine.reclutaseycae.central.dto.request.DTORequest;
import mx.ine.reclutaseycae.central.model.response.ModelResponseLogin;
import mx.ine.reclutaseycae.central.model.response.ModelVersion;
import mx.ine.reclutaseycae.central.security.JwtTokenProvider;
import mx.ine.reclutaseycae.central.util.Constantes;
import mx.ine.servicio.admin.dto.DTOResultado;
import mx.ine.servicio.admin.mb.MBServicioAdminLdap;


@Scope("prototype")
@Component("wsLogin")
public class WsLoginImpl implements WsLogin {
	

	
	
	
	

	/**
	 * Objeto para el servicio de autenticar de mensajes de la aplicaci&oacute;n.
	 */
	private static final Log LOGGER = LogFactory.getLog(WsLoginImpl.class);

   
	@Autowired
	AuthenticationManager authenticationManager;

	
	@Autowired
	MBServicioAdminLdap mbServicioAdminLdap;

	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Override
	public ResponseEntity<Object> holaMundo() {
		return new ResponseEntity<>("bienvenido a hola mundo", HttpStatus.OK);
	}

	
	
	
	
	
	
	@Override
	public Response login(DTORequest loginRequest) throws Exception {
		ModelResponseLogin response = new ModelResponseLogin();
		
		List<DTOCTiposTaller> tiposTaller;
		
		try {
			response.setWsrest(new ModelVersion());

			String password = loginRequest.getPassword(); //boValidaciones.desencriptaCadenaAESCBC256(loginRequest.getPassword());

			if (!StringUtils.isNotBlank(password)) {
				response.setCode(Constantes.CODIGO_400);
				response.setStatus(Constantes.ESTATUS_ERROR);
				response.setMessage(Constantes.MSG_NO_SE_LOGRO_AUTENTICAR);
				response.setCausa("2.- Información incorrecta.");
				return Response.ok((ModelResponseLogin) response).build();
			}
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsuario(), password
							));
			
			DTOUsuarioLogin usuario = (DTOUsuarioLogin) authentication.getPrincipal();
			
			
			String jwt = tokenProvider.generateToken(usuario);
			usuario.setTknJWT(jwt);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);

			usuario.setIdProcesoElectoral(Constantes.ID_PROCESO_PEL_2019);
			usuario.setIdDetalle(Constantes.ID_DETALLE_PROCESO);
			response.setDatosUsuario(usuario);

			response.setCode(Constantes.CODIGO_200);
			response.setStatus(Constantes.ESTATUS_EXITO);
			response.setMessage(Constantes.EMPTY);
			response.setCausa(Constantes.EMPTY);
			return Response.ok((ModelResponseLogin) response).build();
		} catch (Exception e) {
			LOGGER.error("==================== Ocurrio un error al autenticar=============== ", e);
			response.setCode(Constantes.CODIGO_500);
			response.setStatus(Constantes.ESTATUS_ERROR);
			response.setMessage(Constantes.MSG_NO_SE_LOGRO_AUTENTICAR);
			response.setCausa("10.- Ocurrio un error. Comunicate al CAU.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}
	}	

	
	
	@Override
	public Response cierraSesion(DTORequest loginRequest) throws Exception {
		ModelResponseLogin response = new ModelResponseLogin();

		try {
			response.setWsrest(new ModelVersion());

			String password = loginRequest.getPassword();//boValidaciones.desencriptaCadenaAESCBC256(loginRequest.getPassword());

			if (!StringUtils.isNotBlank(password)) {
				response.setCode(Constantes.CODIGO_400);
				response.setStatus(Constantes.ESTATUS_ERROR);
				response.setMessage(Constantes.MSG_NO_SE_LOGRO_AUTENTICAR);
				response.setCausa("2.- Información incorrecta.");
				return Response.ok((ModelResponseLogin) response).build();
			}
			
			DTOResultado usuario = mbServicioAdminLdap.getDTO(loginRequest.getUsuario(), password);
			DTOBitacoraAcceso dtoBitacora= componerDTOBitacoraAcceso(usuario);
			DTOBitacoraAcceso dtoBitacoraActualizar= null;
			
			response.setCode(Constantes.CODIGO_200);
			response.setStatus(Constantes.ESTATUS_EXITO);
			response.setMessage("");
			response.setCausa("");
			return Response.ok((ModelResponseLogin) response).build();
		} catch (Exception e) {
			LOGGER.error("==================== Ocurrio un error al autenticar=============== ", e);
			response.setCode(Constantes.CODIGO_500);
			response.setStatus(Constantes.ESTATUS_ERROR);
			response.setMessage(Constantes.MSG_NO_SE_LOGRO_AUTENTICAR);
			response.setCausa("10.- Ocurrio un error. Comunicate al CAU.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}
	}
	
	public DTOBitacoraAcceso componerDTOBitacoraAcceso(DTOUsuarioLogin usuario) {
		 DTOBitacoraAcceso bitacora = new DTOBitacoraAcceso();
		
		bitacora.setIdSistema(148);//TODO se cambiara el idSistema cuando se tenga
		bitacora.setUsuario(usuario.getUsername());
		bitacora.setRolUsuario("ELECINE.ADMIN.OC");//TODO se cambiara y se pondra el rol del usuario en el sistema
		HttpServletRequest request = ((ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder
				.currentRequestAttributes()).getRequest();
		bitacora.setIpUsuario(request.getRemoteAddr());
		bitacora.setIpNodo(request.getLocalAddr());
		
		return bitacora;
	}
	
	public DTOBitacoraAcceso componerDTOBitacoraAcceso(DTOResultado usuario) {
		 DTOBitacoraAcceso bitacora = new DTOBitacoraAcceso();
			
			bitacora.setIdSistema(148);//TODO se cambiara el idSistema cuando se tenga
			bitacora.setUsuario(usuario.getUid());
			bitacora.setRolUsuario("ELECINE.ADMIN.OC"); //TODO se cambiara y se pondra el rol del usuario en el sistema
			HttpServletRequest request = ((ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder
					.currentRequestAttributes()).getRequest();
			bitacora.setIpUsuario(request.getRemoteAddr());
			bitacora.setIpNodo(request.getLocalAddr());
			
			return bitacora;
	}
	
}
