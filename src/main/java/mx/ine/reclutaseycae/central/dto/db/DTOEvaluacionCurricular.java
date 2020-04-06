/**
 * 
 */
package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mx.ine.reclutaseycae.central.enums.ENUMOpcionesSiNo;

/**
 * @author guadalupe.burgos
 *
 */
@Entity
@Table(schema = "SUPYCAP", name = "EVALUACION_CURRICULAR")
public class DTOEvaluacionCurricular implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4738964559688495192L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idDetalleProceso", column = @Column(name = "ID_DETALLE_PROCESO", nullable = false, precision = 7, scale = 0)),
			@AttributeOverride(name = "idParticipacion", column = @Column(name = "ID_PARTICIPACION", nullable = false, precision = 9, scale = 0)),
			@AttributeOverride(name = "idAspirante", column = @Column(name = "ID_ASPIRANTE", nullable = false, precision = 5, scale = 0)) })
	private DTOAspiranteId id;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private DTOAspirante aspirante;
	
	@Column(name = "ID_PROCESO_ELECTORAL", nullable = false, precision = 5, scale = 0)
	private Integer idProcesoElectoral;
	
	@Column(name = "RFC", length = 13)
    private String rfc;

    @Column(name = "CURP", length = 18)
    private String curp;

    @Column(name = "LUGAR_NACIMIENTO", length = 50)
    private String lugarNacimiento;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "EDAD", nullable = false, precision = 2, scale = 0)
    private Integer edad;

    @Column(name = "SEXO", nullable = false, length = 1)
    private String sexo;

    @Column(name = "ID_ESTADO_DOM", precision = 2, scale = 0)
    private Integer idEstadoDom;
    
    @Column(name = "ID_MUNICIPIO_DOM", nullable = false, precision = 3, scale = 0)
    private Integer idMunicipioDom;

    @Column(name = "ID_LOCALIDAD_DOM", nullable = false, precision = 5, scale = 0)
    private Integer idLocalidad;
    
    @Column(name = "CALLE_NUMERO", nullable = false, length = 250)
    private String calleNumero;

    @Column(name = "COLONIA", length = 120)
    private String colonia;

    @Column(name = "CP", precision = 5, scale = 0)
    private String cp;    
	
	@Column(name = "CORREO_ELECTRONICO", length = 60)
    private String correoElectronico;

    @Column(name = "TELEFONO", length = 30)
    private String telefono;

    @Column(name = "CELULAR", length = 30)
    private String celular;
    
    @Column(name = "CARRERA", length = 50)
    private String carrera;

    @Column(name = "ESTUDIO_ACTUAL", length = 50)
    private String estudioActual;

    @Column(name = "INSTITUCION", length = 50)
    private String institucion;
	
	@Column(name = "MOTIVO_PARTICIPAR", length = 200)
	private String motivoParticipar;

	@Column(name = "PARTICIPO_PROCESO", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo participoProceso;

	@Column(name = "CUAL_PROCESO", length = 50)
	private String cualProceso;
	
	@Column(name = "PARTICIPO_SE", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo participoSe = ENUMOpcionesSiNo.N;
	
	@Column(name = "PARTICIPO_CAE", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo participoCae = ENUMOpcionesSiNo.N;
	
	@Column(name = "PARTICIPO_OTRO_ESPECIFIQUE", length = 100)
	private String participoOtroEspecifique;
	
//	@Column(name = "OBSERVACIONES", length = 1500)
//	private String observacion;
	
	@Column(name = "SABE_MANEJAR", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo sabeManejar;
	
	@Column(name = "TIENE_LICENCIA_MANEJO", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo tieneLicenciaManejo;
	
	@Column(name = "VEHICULO_PROPIO", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo vehiculoPropio;
	
	@Column(name = "MARCA_MODELO", length = 50)
	private String marcaModelo;
	
	@Column(name = "UTILIZAR_VEHICULO", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo utilizarVehiculo;
	
	@Column(name = "TIENE_CELULAR", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo tieneCelular;
	
	@Column(name = "COMPANIA_CELULAR", length = 50)
	private String companiaCelular;
	
	@Column(name = "UTILIZAR_CELULAR", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo utilizarCelular;
	
	@Column(name = "IMPARTIR_CAPACITACION", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo impartirCapacitacion;
	
	@Column(name = "DIPONIBILIDAD_TIEMPO_1", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo diponibilidadTiempo1;
	
	@Column(name = "EXPERIENCIA_MANEJO_GRUPOS_1", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo experienciaManejoGrupos1;

	@Column(name = "TIEMPO_TRANSLADO", length = 5)
	private String tiempoTraslado;

//	@Column(name = "REPRESENTANTE_PARTIDO_1", length = 1)
//	@Enumerated(EnumType.STRING)
//    private ENUMOpcionesSiNo representantePartido1;
	
	@Column(name = "SERVICIOS_FIN_SEM_FESTIVOS_1", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo serviciosFinSemFestivos1;
	
//	@Column(name = "MILITANTE_PARTIDO_1", length = 1)
//	@Enumerated(EnumType.STRING)
//    private ENUMOpcionesSiNo militantePartido1;
	
	@Column(name = "ACTIVIDADES_CAMPO", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo actividadesCampo;
	
	@Column(name = "AFINIDAD_FAM_CONSANGUINEO", length = 1)
	@Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo afinidadFamConsaguineo;
	
//	@Column(name = "ENTREGO_SOLICITUD", nullable = false, length = 1)
//	private String entregoSolicitud;
	
	@Column(name = "ESPECIFIQUE_MEDIO", length = 100)
	private String especifiqueMedio;
	
	@Column(name = "USUARIO", nullable = false, length = 50)
	private String usuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_HORA", nullable = false)
	private Date fechaHora;
	
	@Column(name = "IP_USUARIO", length = 15)
	private String ipUsuario;

}
