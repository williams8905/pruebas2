package mx.ine.reclutaseycae.central.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.ColumnResult;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;


public class DTOAspiranteCustom implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Long  idAspirante;

	private Integer  folio;
    private String claveElector;
	private Integer idConvocatoria;
	private String nombreCompleto;
	private String motivoParticipar;
	private Integer ponderacionExamen;
	private Integer  promedioEntrevistaCae;

	
	public DTOAspiranteCustom() {}
	
	
	public DTOAspiranteCustom( 
	 Long idAspirante,
	 Integer folio,
	 String claveElector,
	 Integer idConvocatoria,
	 String nombreCompleto,
	 String motivoParticipar,
	 Integer ponderacionExamen,
	 Integer  promedioEntrevistaCae
	 ) {
		this.idAspirante = idAspirante;
		this.folio = folio;
		this.claveElector = claveElector;
		this.idConvocatoria= idConvocatoria;
		this.nombreCompleto =  nombreCompleto;
		this.motivoParticipar =  motivoParticipar;
		this.ponderacionExamen = ponderacionExamen;
		this.promedioEntrevistaCae = promedioEntrevistaCae;
		
	}



	



	public Long getIdAspirante() {
		return idAspirante;
	}


	public void setIdAspirante(Long idAspirante) {
		this.idAspirante = idAspirante;
	}


	public Integer getFolio() {
		return folio;
	}



	public void setFolio(Integer folio) {
		this.folio = folio;
	}


	public String getClaveElector() {
		return claveElector;
	}


	public void setClaveElector(String claveElector) {
		this.claveElector = claveElector;
	}


	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}


	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public String getMotivoParticipar() {
		return motivoParticipar;
	}


	public void setMotivoParticipar(String motivoParticipar) {
		this.motivoParticipar = motivoParticipar;
	}


	public Integer getPonderacionExamen() {
		return ponderacionExamen;
	}


	public void setPonderacionExamen(Integer ponderacionExamen) {
		this.ponderacionExamen = ponderacionExamen;
	}


	public Integer getPromedioEntrevistaCae() {
		return promedioEntrevistaCae;
	}


	public void setPromedioEntrevistaCae(Integer promedioEntrevistaCae) {
		this.promedioEntrevistaCae = promedioEntrevistaCae;
	}

	
	
	
	
}
