/**
 * @(#)Constantes.java 21/12/2017
 * <p>
 * Copyright (C) 2018 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.util;


/**
 * @author Ricardo Rodr&iacute;guez de los Santos
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 21/12/2017
 *
 * 
 */
public class Constantes {
    /**
     * Fecha de versi&oacute;n
     */
    public static final String FECHA_VERSION = "25-03-2019";

    /**
     * Versi&oacute;n
     */
    public static final String VERSION = "1.1 Rev 3";

    /**
     * Descripci&oacute;n
     */
    public static final String DESCRIPCION = "Web service para autenticar, cambiar contraseña y cerrar sesi\u00F3n de usuarios para app m\u00F3vil";

    /**
     * Fecha de actualizaci&oacute;n
     */
    public static final String ACTUALIZACION = "11-03-2019";

    /**
     * Estatus de Error
     */
    public static final String ESTATUS_ERROR = "Error";

    /**
     * Estatus de &eacute;xito
     */
    public static final String ESTATUS_EXITO = "\u00C9xito";

    /**
     * Estatus de warning
     */
    public static final String ESTATUS_ADVERTENCIA = "Warning";

    /**
     * Mensaje de &eacute;xito
     */
    public static final String MSG_EXITO = "La consulta se realiz\u00F3 con \u00E9xito";

    /**
     * Mensaje exception
     */
    public static final String MSG_ERROR_WS = "Error en web service de representantes reportes";

    /**
     * Causa de no existen datos
     */
    public static final String CAUSA_NO_EXISTEN_DATOS = "No se encontr\u00F3 registro";

    /**
     * Mensaje de valor null
     */
    public static final String MSG_VALOR_NULL = "Par\u00E1metro de entrada nulo o incorrecto";

    /**
     * Mensaje exception
     */
    public static final String MSG_ERROR_SERVLET = "La URL o los par\u00E1metros capturados son inv\u00E1lidos.";

    /**
     * Causa de Exception
     */
    public static final String CAUSA_ERROR_WS = "Sucedi\u00F3 una excepci\u00F3n interna en el servidor al momento de consumir el servicio web.";

    /**
     * C&oacute;digo HTTP 400
     */
    public static final Integer CODIGO_400 = 400;

    /**
     * C&oacute;digo HTTP 404
     */
    public static final Integer CODIGO_404 = 404;

    /**
     * C&oacute;digo HTTP 500
     */
    public static final Integer CODIGO_500 = 500;

    /**
     * C&oacute;digo HTTP 200
     */
    public static final Integer CODIGO_200 = 200;
    
    /**
     * Mensaje de exception
     */
    public static final String MSG_NO_SE_LOGRO_AUTENTICAR = "No se logro autenticar";
    
    /**
     * Mensaje de exception
     */
    public static final String MSG_NO_SE_LOGRO_CERRAR_SESION = "No se logro cerrar sesión";
    
    
    /**
     * Mensaje de exception
     */
    public static final String MSG_USUARIO_CUENTA_CON_SESION_ACTIVA = "El usuario cuenta con una sesión activa";
    
    /**
     * Mensaje de exception
     */
    public static final String MSG_USUARIO_CERRAR_SESION_ACTIVA = "Se cerró la sesion activa del usuario";
    
    /**
     * Mensaje de exception
     */
    public static final String MSG_USUARIO_NO_CUENTA_CON_SESION_ACTIVA = "El usuario no cuenta con una sesión activa";
    
    /**
     * Mensaje exception
     */
    public static final String MSG_NO_SE_LOGRO_CAMBIAR_PASSWORD = "No se logro cambiar password";
    
    /**
     * Tipo de encriptación para el password
     */
    public static final String TIPO_ENCRIPTACION = "AES/CBC/PKCS5PADDING";
    
    /**
     * Vector de inicio que requiere la encriptaci&oacute;n
     */
    public static final String VECTOR_INICIO = "gqLOHUioQ0QjhuvI";
    
    /**
     * llave de para la encriptaci&oacute;n
     */
    public static final String LLAVE_DE_CIFRADO = "inC2H19lkVbAPfakxcrtTREdd0FloLyw";
    
    /**
     * id del sistema insa 2
     */
    public static final Integer ID_SISTEMA_INSA2 = 166;
    
    /**
     * ID del sistema verificaciones insa1
     */
    public static final Integer ID_SISTEMA_VERIFICACIONES_INSA1 = 167;
    
    public static final String GRUPO_LDAP_CAE = "ELECINE.CAPTURA_CAE.JD";
    public static final String GRUPO_LDAP_SE = "ELECINE.CAPTURA_SE.JD";
    public static final String GRUPO_LDAP_OC = "ELECINE.CAPTURA.OC";
    public static final String GRUPO_LDAP_JL = "ELECINE.CAPTURA.JL";
    public static final String GRUPO_LDAP_JD = "ELECINE.CAPTURA.JD";
    public static final String GRUPO_LDAP_ADMIN_OC = "ELECINE.ADMIN.OC";
    
    public static final Integer ID_ROL_ADMIN_OC = 3;
    public static final Integer ID_ROL_CAPTURA_OC = 4;
    public static final Integer ID_ROL_CAPTURA_JL = 5;
    public static final Integer ID_ROL_CAPTURA_JD = 6;
    public static final Integer ID_ROL_CE_JD = 7;
    
    public static final String GRUPO_LDAP_VERIF_ADMIN_OC = "VERIFINSA1.ADMIN.OC";
    public static final String GRUPO_LDAP_VERIF_CAPTURA_OC = "VERIFINSA1.CAPTURA.OC";
    public static final String GRUPO_LDAP_VERIF_CAPTURA_VOCAL_JL = "VERIFINSA1.CAPTURA_VOCAL.JL";
    public static final String GRUPO_LDAP_VERIF_CAPTURA_CONSEJ_JL = "VERIFINSA1.CAPTURA_CONSEJ.JL";
    public static final String GRUPO_LDAP_VERIF_CAPTURA_VOCAL_JD = "VERIFINSA1.CAPTURA_VOCAL.JD";
    public static final String GRUPO_LDAP_VERIF_CAPTURA_CONSEJ_JD = "VERIFINSA1.CAPTURA_CONSEJ.JD";

    public static final Integer ID_ROL_VERIF_ADMIN_OC = 6;
    public static final Integer ID_ROL_VERIF_CAPTURA_OC = 17;
    public static final Integer ID_ROL_VERIF_CAPTURA_VOCAL_JL = 7;
    public static final Integer ID_ROL_VERIF_CAPTURA_CONSEJ_JL = 8;
    public static final Integer ID_ROL_VERIF_CAPTURA_VOCAL_JD = 15; 
    public static final Integer ID_ROL_VERIF_CAPTURA_CONSEJ_JD =16;
    
    public static final Integer ESTATUS_ACTIVO = 1;
    
    public static final Integer ESTATUS_INACTIVO = 0;
    
    public static final Integer ID_PROCESO = 9;
    public static final Integer ID_PROCESO_PEL_2019 = 11;
    
    public static final Integer ID_DETALLE_PROCESO = 33;
    
    public static final Integer VALOR_ROL_ACTIVO = 1;
    
    public static final String CUENTA_ACTIVA = "S";

    public static final Integer ID_DETALLE_PROCESO_AGUASCALIENTES = 100;
    public static final Integer ID_DETALLE_PROCESO_BAJA_CALIF = 101;
    public static final Integer ID_DETALLE_PROCESO_DURANGO = 102;
    public static final Integer ID_DETALLE_PROCESO_QUIN_ROO = 103;
    public static final Integer ID_DETALLE_PROCESO_TAMAULIPAS = 104;
    public static final Integer ID_DETALLE_PROCESO_PUEBLA = 105;
    
    
    public static final int ID_ESTADO_AGUASCALIENTES = 1;
    public static final int ID_ESTADO_BAJA_CALIF = 2;
    public static final int ID_ESTADO_DURANGO = 10;
    public static final int ID_ESTADO_QUIN_ROO = 23;
    public static final int ID_ESTADO_TAMAULIPAS = 28;
    public static final int ID_ESTADO_PUEBLA = 21;
    
	/**
	 * Prefijo para el rol de ldap que posee el usuario.
	 */
	public static final String LDAP_ROL = "ROLE_";
	
	/**
	 * Prefijo correspondiente a los roles del sistema.
	 */
	public static final String ROLES_SISTEMA = "CUESTIONARIOS.";
	
	/**
	 * Cadena representativa del nombre completo del usuario.
	 */
	public static final String NOMBRE = "nombre";
	
	/**
	 * Cadena respresentantiva del correo del usuario.
	 */
	public static final String CORREO = "mail";
	
	/**
	 * Cadena representativa de id estado.
	 */
	public static final String ID_ESTADO = "idEstado";
	
	/**
	 * Cadena representativa de id distrito.
	 */
	public static final String ID_DISTRITO = "idDistrito";
	
	/**
	 * Cadena representativa del rol del usuario.
	 */
	public static final String ROL = "rol";
	
	/**
	 * Cadena representativa del area de adscripci&oacute;n del usuario.
	 */
	public static final String AREA_ADSCRIPCION = "area";
	
	/**
	 * Cadena representativa del puesto del usuario.
	 */
	public static final String PUESTO = "puesto";
	
	/**
	 * Cadena vacia.
	 */
	public static final String EMPTY = "";
	
	
	
	/*
	 *   Constantes de INSA1 ***********************
	 *  
	 */
	
	public static final Integer CONSULTA_INSACULADOS_POR_AREA = 1;
	public static final Integer FECHA_INICIO_CAPTURA = 12;
	public static final Integer FECHA_FIN_CAPTURA = 13;
	
	
	
	
	public static final Integer SESION_INACTIVA = -1;
	public static final Integer SESION_ACTIVA 	= -2;
	public static final Integer DURACION_SESION = 30;
	public static final boolean USUARIO_JDE 	= true;
	public static final boolean USUARIO_ONLINE 	= false;
	
	
	/*modulo bandeja*/
	public static final Integer BANDEJA_1 = 1;
	public static final Integer BANDEJA_2 = 2;
	public static final Integer BANDEJA_3 = 3;
	public static final Integer BANDEJA_4 = 4;
	public static final Integer BANDEJA_5 = 5;
    /**
     * Constructor privado
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 27/10/2017
     */
    private Constantes() {
        // Constructor privado utilizado para evitar la creaci&oacute;n de instancias.
    }
}
