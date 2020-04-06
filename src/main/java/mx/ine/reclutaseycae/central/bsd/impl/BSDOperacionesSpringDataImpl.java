package mx.ine.reclutaseycae.central.bsd.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ine.reclutaseycae.central.as.ASOperacionesSpringDataInterface;
import mx.ine.reclutaseycae.central.bsd.BSDOperacionesSpringDataInterface;
@Service("bsdOperacionesSpringData")
@Scope("prototype")
public class BSDOperacionesSpringDataImpl implements BSDOperacionesSpringDataInterface{

	@Autowired
	@Qualifier("asOperacionesSpringData")
	private ASOperacionesSpringDataInterface operaciones;
	
	@Override
	public void ejecutarOperacionesSpringData() {
		
		operaciones.operacionGuardar();
		operaciones.operacionActualizar();
		operaciones.operacionBorrar();
		operaciones.ejecutarBusquedaCompuesta();
		operaciones.ejecutarQueryDTOEntidad();
		operaciones.ejecutarQueryDTOSinEntidad();
		
	}

}
