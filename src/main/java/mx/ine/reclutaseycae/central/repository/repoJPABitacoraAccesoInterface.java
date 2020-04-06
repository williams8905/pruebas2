package mx.ine.reclutaseycae.central.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.ine.reclutaseycae.central.dto.DTOAspiranteCustom;
import mx.ine.reclutaseycae.central.dto.db.DTOBitacoraAcceso;




public interface repoJPABitacoraAccesoInterface  extends JpaRepository<DTOBitacoraAcceso, Integer>
{
	
	
	
	public List<DTOBitacoraAcceso>  findByidSistemaAndUsuarioAndRolUsuario(
			 Integer idSistema, 
	         String usuario, 
	         String rolUsuario		
			)	
	;
	
	@Query(value = "SELECT * FROM BITACORA_ACCESO B WHERE"
			+ " B.ID_SISTEMA = :idSistema "
			+ " AND B.USUARIO = :usuario "
			+ " AND B.ROL_USUARIO  = :rol",
			nativeQuery = true
			
	)
	 public List<DTOBitacoraAcceso> pruebaBusquedaQuery(
	            @Param("idSistema")Integer idSistema, 
	            @Param("usuario")String usuario, 
	            @Param("rol")String rol);
	
	
	
	/*
	 * @Query(nativeQuery = true, name = "findAllDataMapping")
	 * List<DTOAspiranteCustom> pruebaBusquedaQueryCustom();
	 */
}
