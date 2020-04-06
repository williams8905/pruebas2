package mx.ine.reclutaseycae.central.dao;

import java.io.Serializable;

import mx.ine.reclutaseycae.central.dto.db.DTOBitacoraAcceso;

public interface DAOBitacoraAccesoInterface extends Serializable {
	
	public Integer obtenNumSecBitacora() throws Exception;
	public void agregarRegistroBitacora(DTOBitacoraAcceso bitacora) throws Exception;
	public void cerrarSesionRegistroBitacora(DTOBitacoraAcceso bitacora) throws Exception;
	public Integer obtenSesionActiva(DTOBitacoraAcceso bitacora);
	public DTOBitacoraAcceso obtenRegistroSesionActiva(DTOBitacoraAcceso bitacora);
}
