/**
 * 
 */
package mx.ine.reclutaseycae.central.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.ine.reclutaseycae.central.dto.db.DTORegistroConvocatoria;
import mx.ine.reclutaseycae.central.dto.db.DTORegistroConvocatoriaId;

/**
 * @author guadalupe.burgos
 *
 */
public interface REPORegistroConvocatorias extends JpaRepository<DTORegistroConvocatoria, DTORegistroConvocatoriaId>, JpaSpecificationExecutor<DTORegistroConvocatoria> {

	@Query(value = "SELECT " + 
					"    REG_CON.* " + 
					"FROM registro_convocatorias REG_CON" + 
					"    JOIN" + 
					"    (SELECT id_proceso_electoral, id_detalle_proceso, id_participacion, id_estado " + 
					"	 FROM participacion_geografica" + 
					"	 WHERE id_proceso_electoral= :idProcesoElectoral" + 
					"	 GROUP BY id_proceso_electoral, id_detalle_proceso, id_participacion, id_estado " + 
					"	 ) PAR_GEO " + 
					"		ON REG_CON.id_proceso_electoral = PAR_GEO.id_proceso_electoral AND REG_CON.id_detalle_proceso = PAR_GEO.id_detalle_proceso AND REG_CON.id_participacion = PAR_GEO.id_participacion " + 
					"    JOIN GEOGRAFICOINE.ESTADOS EST ON EST.id_estado = PAR_GEO.id_estado " + 
					"WHERE TO_DATE ('18/05/19', 'dd/mm/yy') BETWEEN REG_CON.fecha_registro_inicio " + 
					"AND REG_CON.fecha_registro_fin " + 
					"AND EST.id_corte = :idCorte"
			, nativeQuery = true)
	public List<DTORegistroConvocatoria> findAllConvocatoriasVigentes(@Param("idProcesoElectoral") Integer idProcesoElectoral, @Param("idCorte") Integer idCorte);

}
