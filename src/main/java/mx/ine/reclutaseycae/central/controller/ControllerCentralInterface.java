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
public interface ControllerCentralInterface {

	
	@PostMapping(path = "/operaciones", consumes = "application/json", produces = "application/json")
	public @ResponseBody Response ejecutarOperaciones(@RequestBody DTORequest dtoRequest) throws Exception;
	
	
}
