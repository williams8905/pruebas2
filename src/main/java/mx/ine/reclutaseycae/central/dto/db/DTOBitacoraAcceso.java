package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import mx.ine.reclutaseycae.central.dto.DTOAspiranteCustom;
import mx.org.ine.servicios.dto.DTOBase;
@Entity
/*
 * @SqlResultSetMapping(name = "FridayEmployeeResult", columns =
 * { @ColumnResult(name = "employeeId") }),
 */
@SqlResultSetMapping(
	    name = "mappingResultDTOAspiranteCustom",
	    		classes = @ConstructorResult(
	    				
	    				columns ={ 
	    			    		@ColumnResult(name = "idAspirante", type=Long.class),
	    		                @ColumnResult(name = "folio", type= Integer.class),
	    		                @ColumnResult(name = "claveElector",type= String.class),
	    		                @ColumnResult(name = "idConvocatoria",type= Integer.class),
	    		                @ColumnResult(name = "nombreCompleto",type= String.class),
	    		                @ColumnResult(name = "motivoParticipar",type= String.class),
	    		                @ColumnResult(name = "ponderacionExamen",type= Integer.class),
	    		                @ColumnResult(name = "promedioEntrevistaCae",type= Integer.class)
	    			    },
	    				
	    				targetClass = mx.ine.reclutaseycae.central.dto.DTOAspiranteCustom.class
	    				)
	    
	    
	    
		)




@Table(name = "BITACORA_ACCESO", schema = "SUPYCAP")
@DynamicInsert
public class DTOBitacoraAcceso /*extends DTOBase*/ implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2304150884082039403L;
	 @Id
	/*
	 * @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
	 * 
	 * @SequenceGenerator(name="my_entity_seq_gen", sequenceName="S_BITACORAACCESO")
	 */
	// @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_BITACORAACCESO")
	 @SequenceGenerator(name="SEQ_GEN", sequenceName="S_BITACORAACCESO", allocationSize=1)
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	 @Column(name = "ID_BITACORA_ACCESO", nullable = false)
	 private Integer idBitacoraAcceso;
	
	 /**
	  * Identificador único del sistema
	  */
	 @Column(name = "ID_SISTEMA")
	 private Integer idSistema;
	 
	 /**
	  * Usuario
	  */
	 @Column(name = "USUARIO")
	 private String usuario;
	 
	 
	 /**
	  * |Valor que seleccionó el usuario 
	  */
	 @Column(name = "ROL_USUARIO")
	 private String rolUsuario;
	 
	 /**
	  * Fecha y hora del inicio de sesión
	  */
	 @Column(name = "FECHA_HORA_INICIO")
	 private Date fechaHoraInicio;
	 
	 /**
	  * Fecha y hora del fin de sesión
	  */
	 @Column(name = "FECHA_HORA_FIN")
	 private Date fechaHoraFin;
	 
	 /**
	  * |Ip del usuario logueado
	  */
	 @Column(name = "IP_USUARIO")
	 private String ipUsuario;
	 
	 /**
	  * Ip del nodo donde se aloja la aplicación
	  */
	 @Column(name = "IP_NODO")
	 private String ipNodo;

	 
	 

	 /*getters y setters*/
	 
	 
	public Integer getIdBitacoraAcceso() {
		return idBitacoraAcceso;
	}

	public void setIdBitacoraAcceso(Integer idBitacoraAcceso) {
		this.idBitacoraAcceso = idBitacoraAcceso;
	}

	public Integer getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Date getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(Date fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public String getIpNodo() {
		return ipNodo;
	}

	public void setIpNodo(String ipNodo) {
		this.ipNodo = ipNodo;
	}

	/*
	 * @Override public Date getFechaHora() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public void setFechaHora(Date arg0) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 */
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

