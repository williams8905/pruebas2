/**
 * @(#)ENUMOpcionesSiNo.java 29/08/2019
 * <p>
 * Copyright (C) 2019 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.enums;

/**
 * @author guadalupe.burgos
 *
 */
public enum ENUMOpcionesSiNo {

	/**
     * Representa No Urbana
     */
    S("Si"),

    /**
     * Representa Mixta
     */
    N("No");

    /**
     * Descripci&oacute;n de la calidad del representante
     */
    private final String descripcion;
    
    /**
     * Constructor que incializa los valores del enum
     *
     * @param descripcion : Descripci&oacute;n
     */
    ENUMOpcionesSiNo(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * M�todo que obtiene el valor del atributo descripci�n
     *
     * @return String : valor que tiene el atributo descripci�n
     *
     * @author Jos� Guadalupe Burgos Colomoxcatl
     * @since 29/08/2019
     */
    public String getDescripcion() {
        return descripcion;
    }
	
}
