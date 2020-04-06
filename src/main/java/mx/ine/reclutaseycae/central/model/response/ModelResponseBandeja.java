package mx.ine.reclutaseycae.central.model.response;


import java.util.List;

import mx.ine.reclutaseycae.central.dto.DTOTablaBandeja;



public class ModelResponseBandeja extends ModelResponse{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1132011134857771771L;
	
	
	
	DTOTablaBandeja tablaBandeja;



	public DTOTablaBandeja getTablaBandeja() {
		return tablaBandeja;
	}



	public void setTablaBandeja(DTOTablaBandeja tablaBandeja) {
		this.tablaBandeja = tablaBandeja;
	}
	
  
}
