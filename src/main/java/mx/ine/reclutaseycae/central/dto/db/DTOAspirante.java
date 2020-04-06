/**
 * @(#)DTOAspirante.java 29/08/2019
 * <p>
 * Copyright (C) 2019 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import mx.ine.reclutaseycae.central.enums.ENUMOpcionesSiNo;

/**
 * @author guadalupe.burgos
 *
 */
@Entity
@Table(schema = "SUPYCAP", name = "ASPIRANTES")
@DynamicInsert
@DynamicUpdate
public class DTOAspirante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6365535686762832129L;

	@EmbeddedId
//	@AttributeOverrides({			
//			@AttributeOverride(name = "idDetalleProceso", column = @Column(name = "ID_DETALLE_PROCESO", nullable = false, precision = 7, scale = 0)),
//			@AttributeOverride(name = "idParticipacion", column = @Column(name = "ID_PARTICIPACION", nullable = false, precision = 9, scale = 0)),
//			@AttributeOverride(name = "idAspirante", column = @Column(name = "ID_ASPIRANTE", nullable = false, precision = 5, scale = 0)) })
	private DTOAspiranteId id;

	@Basic(optional = false)
	@Column(name = "ID_PROCESO_ELECTORAL", nullable = false, precision = 5, scale = 0)
	private Integer idProcesoElectoral;
	
	@Basic(optional = false)
	@Column(name = "ID_CONVOCATORIA", nullable = false, precision = 5, scale = 0)
	private Integer idConvocatoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "ID_DETALLE_PROCESO", referencedColumnName = "ID_DETALLE_PROCESO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PARTICIPACION", referencedColumnName = "ID_PARTICIPACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_CONVOCATORIA", referencedColumnName = "ID_CONVOCATORIA", nullable = false, insertable = false, updatable = false) })
    private DTORegistroConvocatoria convocatoria;
	
	@Basic(optional = false)
	@Column(name = "FOLIO", nullable = false, precision = 4, scale = 0)
	private Integer folioPrincipal;
	
	@Basic(optional = false)
	@Column(name = "FOLIO_ACCESO", nullable = false, precision = 4, scale = 0)
	private Integer folioAcceso;
	
	@Basic(optional = false)
	@Column(name = "ORIGEN_REGISTRO", nullable = false, length = 18)
	private String origenRegistro;
	
	@Basic(optional = false)
	@Column(name = "CLAVE_ELECTOR_FUAR", nullable = false, length = 18)
	private String claveElectorFuar;

	@Basic(optional = false)
	@Column(name = "APELLIDO_PATERNO", length = 40)
	private String apellidoPaterno;

	@Basic(optional = true)
	@Column(name = "APELLIDO_MATERNO", length = 40)
	private String apellidoMaterno;

	@Basic(optional = false)
	@Column(name = "NOMBRE", nullable = false, length = 50)
	private String nombre;

	@Basic(optional = false)
	@Column(name = "SECCION_DOM", nullable = false, precision = 4, scale = 0)
	private Integer seccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESCOLARIDAD", nullable = false)
    private DTOCEscolaridad escolaridad;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
    private DTOEvaluacionCurricular evaluacionCurricular;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
    private Set<DTOAspiranteYMedioDifusion> mediosSeleccionados = new HashSet<DTOAspiranteYMedioDifusion>(0);
	
//	@Column(name = "ID_PLATICA", precision = 5, scale = 0)
//    private Integer idPlatica;
	
//	@Column(name = "ESTATUS", nullable = false, length = 1)
//    private String estatus;
    
//    @Column(name = "CORREO_CUENTA_CREADA", length = 60)
//    private String correoCtaCreada;
//    
//    @Column(name = "CORREO_CUENTA_NOTIFICACION", length = 60)
//    private String correoCtaNotificacion;
//    
//    @Column(name = "TELEFONO_CUENTA_CREADA", length = 25)
//    private String telefonoCtaCreada;
    
    @Basic(optional = false)
    @Column(name = "HABLA_LENGUA_INDIGENA", nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private ENUMOpcionesSiNo hablaLenguaIndigena;
    
	@Basic(optional = true)
    @Column(name = "CUAL_LENGUA_INDIGENA", length = 50)
    private String cualLenguaIndigena;
    
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_SOLICITUD", nullable = false)
	private Date fechaSolicitud;
    
//    @Column(name = "SERVICIO_USADO_CTA", nullable = true, precision = 1, scale = 0)
//    private Integer servicioUsadoCta; 
    
//    @Column(name = "ID_SISTEMA_ACTUALIZA", precision = 3)
//    private Integer idSistemaActualiza;
    
	@Basic(optional = false)
    @Column(name = "USUARIO", nullable = false, length = 50)
    private String usuario;

	@Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_HORA", nullable = false)
    private Date fechaHora;
    
    @Column(name = "IP_USUARIO", length = 15)
    private String ipUsuario;

}
