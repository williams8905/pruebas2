package mx.ine.reclutaseycae.central.model.request;


/**
 * @(#)ModelParametrosLogin.java 11/01/2018
 * <p>
 * Copyright (C) 2018 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */


/**
 * Clase que representa el modelo de entrada de datos para el metodo iniciarSesion del servicio service-autentica.
 * 
 * @author Ricardo Rodr&iacute;guez de los Santos
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 11/01/2018
 *
 * 
 */
public class ModelParametrosLogin {

    private String username;
    
    private String password;
    
    private String versionAplicacion;
    
    private Integer idSistema;

    /**
     * Obtiene el valor del atributo {@code usuario}
     *
     * @return valor del atributo {@code usuario}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos
     * @since 11/01/2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * Coloca el valor al atributo {@code usuario}
     *
     * @param usuario valor a colocar correspondiente al atributo {@code usuario}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos  
     * @since 11/01/2018
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el valor del atributo {@code password}
     *
     * @return valor del atributo {@code password}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos
     * @since 11/01/2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * Coloca el valor al atributo {@code password}
     *
     * @param password valor a colocar correspondiente al atributo {@code password}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos  
     * @since 11/01/2018
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el valor del atributo {@code versionAplicacion}
     *
     * @return valor del atributo {@code versionAplicacion}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos
     * @since 11/01/2018
     */
    public String getVersionAplicacion() {
        return versionAplicacion;
    }

    /**
     * Coloca el valor al atributo {@code versionAplicacion}
     *
     * @param versionAplicacion valor a colocar correspondiente al atributo {@code versionAplicacion}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos  
     * @since 11/01/2018
     */
    public void setVersionAplicacion(String versionAplicacion) {
        this.versionAplicacion = versionAplicacion;
    }

    /**
     * Obtiene el valor del atributo {@code idSistema}
     *
     * @return valor del atributo {@code idSistema}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos
     * @since 11/01/2018
     */
    public Integer getIdSistema() {
        return idSistema;
    }

    /**
     * Coloca el valor al atributo {@code idSistema}
     *
     * @param idSistema valor a colocar correspondiente al atributo {@code idSistema}
     *
     * @author Ricardo Rodr&iacute;guez de los Santos  
     * @since 11/01/2018
     */
    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }
    
    
}
