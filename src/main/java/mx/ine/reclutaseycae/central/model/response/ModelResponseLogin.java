/**
 * @(#)ModelResponseLogin.java 15/01/2018
 * <p>
 * Copyright (C) 2018 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.model.response;

import java.util.List;

import mx.ine.reclutaseycae.central.dto.DTOUsuarioLogin;
import mx.ine.reclutaseycae.central.dto.db.DTOGrupoSistema;


/**
 * @author Ricardo Rodr&iacute;guez de los Santos
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 15/01/2018
 *
 * 
 */
public class ModelResponseLogin extends ModelResponse {
    
    /**
     * 
     */
    private static final long serialVersionUID = 783785074661345622L;

    DTOUsuarioLogin datosUsuario;
    
    List<DTOGrupoSistema> lsGrupoSistemas;
    
    /**
     * Obtiene el valor del atributo {@code datosUsuario}
     *
     * @return valor del atributo {@code datosUsuario}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos
     * @since 15/01/2018
     */
    public DTOUsuarioLogin getDatosUsuario() {
        return datosUsuario;
    }

    /**
     * Coloca el valor al atributo {@code datosUsuario}
     *
     * @param datosUsuario valor a colocar correspondiente al atributo {@code datosUsuario}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos  
     * @since 15/01/2018
     */
    public void setDatosUsuario(DTOUsuarioLogin datosUsuario) {
        this.datosUsuario = datosUsuario;
    }


    /**
     * Obtiene el valor del atributo {@code lsGrupoSistemas}
     *
     * @return valor del atributo {@code lsGrupoSistemas}
     *
     * @author Julio.Lopez
     */
	public List<DTOGrupoSistema> getLsGrupoSistemas() {
		return lsGrupoSistemas;
	}

	/**
     * Coloca el valor al atributo {@code lsGrupoSistemas}
     *
     * @param lsGrupoSistemas valor a colocar correspondiente al atributo {@code lsGrupoSistemas}
     *
     * @author Julio.Lopez
     * @since 01/08/2018
     */
	public void setLsGrupoSistemas(List<DTOGrupoSistema> lsGrupoSistemas) {
		this.lsGrupoSistemas = lsGrupoSistemas;
	}
    

}
