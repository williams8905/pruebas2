package mx.ine.reclutaseycae.central.model.request;


/**
 * @author Alfredo Temiquel
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 29/05/2019
 *
 */
public class ModelParametrosCerrarSesion {

	private String usuario;
	
    private String versionAplicacion;
    
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getVersionAplicacion() {
		return versionAplicacion;
	}

	public void setVersionAplicacion(String versionAplicacion) {
		this.versionAplicacion = versionAplicacion;
	}
	 
}
