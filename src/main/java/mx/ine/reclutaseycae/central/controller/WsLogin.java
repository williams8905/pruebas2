package mx.ine.reclutaseycae.central.controller;

import javax.ws.rs.core.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.ine.reclutaseycae.central.dto.request.DTORequest;

@RestController
@RequestMapping(path = "/ws")
public interface WsLogin {

	@RequestMapping(path = "/holaMundo")
	public ResponseEntity<Object> holaMundo();
	
	@PostMapping(path = "/validateUser", consumes = "application/json", produces = "application/json")
	public @ResponseBody Response login(@RequestBody DTORequest loginRequest) throws Exception;
		
	@PostMapping(path = "/cierraSesion", consumes = "application/json", produces = "application/json")
	public @ResponseBody Response cierraSesion(@RequestBody DTORequest loginRequest) throws Exception;
	
}
