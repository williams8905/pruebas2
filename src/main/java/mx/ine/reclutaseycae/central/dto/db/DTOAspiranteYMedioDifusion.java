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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author guadalupe.burgos
 *
 */
@Entity
@Table(schema = "SUPYCAP", name = "ASPIRANTES_MEDIOS_DIFUSION")
public class DTOAspiranteYMedioDifusion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -898085285199553970L;

	@EmbeddedId
//    @AttributeOverrides({        
//        @AttributeOverride(name = "idDetalleProceso", column = @Column(name = "ID_DETALLE_PROCESO", nullable = false, precision = 7, scale = 0)),
//        @AttributeOverride(name = "idParticipacion", column = @Column(name = "ID_PARTICIPACION", nullable = false, precision = 9, scale = 0)),
//        @AttributeOverride(name = "idAspirante", column = @Column(name = "ID_ASPIRANTE", nullable = false, precision = 5, scale = 0)),
//        @AttributeOverride(name = "idMedioDifusion", column = @Column(name = "ID_MEDIO_DIFUSION", nullable = false, precision = 2, scale = 0)) })
    private DTOAspiranteConMedioId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({        
        @JoinColumn(name = "ID_DETALLE_PROCESO", referencedColumnName = "ID_DETALLE_PROCESO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PARTICIPACION", referencedColumnName = "ID_PARTICIPACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_ASPIRANTE", referencedColumnName = "ID_ASPIRANTE", nullable = false, insertable = false, updatable = false) })
    private DTOAspirante aspirante;
    
    @Column(name = "ID_PROCESO_ELECTORAL", nullable = false, precision = 5, scale = 0)
    private int idProcesoElectoral;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MEDIO_DIFUSION", nullable = false, insertable = false, updatable = false)
    private DTOCMedioDifusionAspirante medioDifusion;
    
    @Column(name = "USUARIO", nullable = false, length = 50)
    private String usuario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_HORA", nullable = false)
    private Date fechaHora;
    
    @Column(name = "IP_USUARIO", length = 15)
    private String ipUsuario;
	
}
