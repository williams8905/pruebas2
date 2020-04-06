/**
 * 
 */
package mx.ine.reclutaseycae.central.dto.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author guadalupe.burgos
 *
 */
@Entity
@Table(schema = "SUPYCAP", name = "C_MEDIOS_DIFUSION_ASPIRANTE")
public class DTOCMedioDifusionAspirante implements Serializable {

	@Id
    @Column(name = "ID_MEDIO_DIFUSION", unique = true, nullable = false, precision = 2, scale = 0)
    private Integer idMedioDifusion;
	
    @Column(name = "DESCRIPCION_MEDIO", nullable = false, length = 35)
    private String descripcionMedio;
    
    @Column(name = "ORDEN", precision = 2, scale = 0)
    private Integer orden;
	
}
