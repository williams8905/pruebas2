package mx.ine.reclutaseycae.central.dao;

import java.io.Serializable;
import java.util.List;

import mx.ine.reclutaseycae.central.dto.DTOCFechasCaptura;
import mx.ine.reclutaseycae.central.dto.DTOCTiposTaller;

public interface DAOCatalogos  extends Serializable{
	
	public List<DTOCFechasCaptura> obtenFechasCaptura(Integer idParametroFecha);
	
	public List<DTOCTiposTaller> obtenTiposTaller();
	
	public List<DTOCTiposTaller> obtenTiposTallerReportes();
}
