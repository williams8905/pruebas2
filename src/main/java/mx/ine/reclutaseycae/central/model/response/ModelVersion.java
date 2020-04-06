package mx.ine.reclutaseycae.central.model.response;


import java.io.Serializable;

import mx.ine.reclutaseycae.central.util.Constantes;


/**
 * @author Ricardo Rodr&iacute;guez de los Santos
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 21/12/2017
 *
 * 
 */
public class ModelVersion implements Serializable{

    /**
     * Elemento para la serializaci&oacute;n de los objetos gnerados por esta clase
     */
    private static final long serialVersionUID = -2986696537676085482L;

    /**
     * Fecha de la primera version
     */
    private String fecha = Constantes.FECHA_VERSION;

    /**
     * Numero de version
     */
    private String version = Constantes.VERSION;

    /**
     * Descripcion general del servicio o cambio
     */
    private String descripcion = Constantes.DESCRIPCION;

    /**
     * Fecha de la ultima actualizacion
     */
    private String actualizacion = Constantes.ACTUALIZACION;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(String actualizacion) {
        this.actualizacion = actualizacion;
    }
}
