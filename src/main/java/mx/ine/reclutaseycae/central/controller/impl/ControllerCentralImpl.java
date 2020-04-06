package mx.ine.reclutaseycae.central.controller.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import mx.ine.reclutaseycae.central.bsd.BSDOperacionesSpringDataInterface;
import mx.ine.reclutaseycae.central.controller.ControllerCentralInterface;
import mx.ine.reclutaseycae.central.dto.DTOCTiposTaller;
import mx.ine.reclutaseycae.central.dto.DTOUsuarioLogin;
import mx.ine.reclutaseycae.central.dto.request.DTORequest;
import mx.ine.reclutaseycae.central.model.response.ModelResponseLogin;
import mx.ine.reclutaseycae.central.model.response.ModelVersion;
import mx.ine.reclutaseycae.central.util.Constantes;


@Scope("prototype")
@Component("controllerOperaciones")
public class ControllerCentralImpl implements ControllerCentralInterface{
	
	private static final Log LOGGER = LogFactory.getLog(ControllerCentralImpl.class);
	
	@Autowired
	@Qualifier("bsdOperacionesSpringData")
	BSDOperacionesSpringDataInterface operaciones;
	
	
	@Override
	public Response ejecutarOperaciones(DTORequest dtoRequest) throws Exception {
		ModelResponseLogin response = new ModelResponseLogin();
		
		
		try {
			//ejecuta una serie de operaciones usando spring data
			operaciones.ejecutarOperacionesSpringData();
			
			/*respuesta con resultado OK*/
			response.setWsrest(new ModelVersion());
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

}
