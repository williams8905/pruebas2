package mx.ine.reclutaseycae.central.model.response;


import java.io.Serializable;


/**
 * @author Ricardo Rodr&iacute;guez de los Santos
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 21/12/2017
 */
public class ModelResponse implements Serializable{

    /**
     * Elemento para la serializaci&oacute;n de los objetos gnerados por esta clase
     */
    private static final long serialVersionUID = 2111085708625897519L;

    /**
     * Informacion de la version
     */
    private ModelVersion wsrest;

    /**
     * Codigo de respuesta
     */
    private Integer code;

    /**
     * Estado
     */
    private String status;

    /***
     * Mensaje obtenido
     */
    private String message;

    /**
     * Causa de error o excepcion
     */
    private String causa;

    public ModelVersion getWsrest() {
        return wsrest;
    }

    public void setWsrest(ModelVersion wsrest) {
        this.wsrest = wsrest;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
}
