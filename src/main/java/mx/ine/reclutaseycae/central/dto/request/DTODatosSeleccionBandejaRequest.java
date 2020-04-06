package mx.ine.reclutaseycae.central.dto.request;

import java.io.Serializable;

public class DTODatosSeleccionBandejaRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 766605238839338378L;

	
	private Integer bandejaSeleccionada;


	public Integer getBandejaSeleccionada() {
		return bandejaSeleccionada;
	}


	public void setBandejaSeleccionada(Integer bandejaSeleccionada) {
		this.bandejaSeleccionada = bandejaSeleccionada;
	}
	
	
}
