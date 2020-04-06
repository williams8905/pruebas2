/**
 * @(#)ApplicationUtil.java 12/01/2018
 * <p>
 * Copyright (C) 2018 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.util;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author Ricardo Rodr&iacute;guez de los Santos
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 12/01/2018
 *
 * 
 */
public class ApplicationUtil {

    private ApplicationUtil() {
    }
    
    public static String obtenVariableContexto(String varContext) {
	String baseLdap = "";
	try {
	    Context initialContext = new InitialContext();

	    // Contiene el valor de la variable de la base ldap
	    baseLdap = (String) initialContext.lookup(varContext);
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return baseLdap;
    }
}
