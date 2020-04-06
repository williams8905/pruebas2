package mx.ine.reclutaseycae.central.as.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.reclutaseycae.central.as.ASOperacionesSpringDataInterface;
import mx.ine.reclutaseycae.central.dto.DTOAspiranteCustom;
import mx.ine.reclutaseycae.central.dto.db.DTOBitacoraAcceso;
import mx.ine.reclutaseycae.central.repository.repoJPABitacoraAccesoInterface;

@Service("asOperacionesSpringData")
@Scope("prototype")
public class ASOperacionesSpringDataImpl implements ASOperacionesSpringDataInterface{

	@PersistenceContext(unitName = "supycapPU") 
	 private EntityManager manager;
	 
	
	@Autowired
	private repoJPABitacoraAccesoInterface repo;
	
	
	
	/**
	 * Metodo para guardar en la base de datos 
	 */
	@Override
	@Transactional(value="supycapTransactionManager", propagation = Propagation.REQUIRED,readOnly = false, rollbackFor = { Exception.class })
	public void operacionGuardar() {
		//llenado de dto 
		DTOBitacoraAcceso objeto = new DTOBitacoraAcceso();
		objeto.setFechaHoraFin(new Date());
		objeto.setFechaHoraInicio(new Date());
		objeto.setIdSistema(148);
		objeto.setIpUsuario("12.55555.5555");
		objeto.setRolUsuario("rol.uisuario.pruiebna");
		objeto.setIpNodo("1256345.699");
		objeto.setUsuario("williams.pantoja");
		//guardar objeto
		repo.save(objeto);
		
	}

	@Override
	@Transactional(value="supycapTransactionManager", propagation = Propagation.REQUIRED,readOnly = false, rollbackFor = { Exception.class })
	public void operacionActualizar() {
		//encuentra objeto por  id
		DTOBitacoraAcceso reg  =  repo.findById(26334).get();
		//actualiza registro de la tabla
		reg.setFechaHoraInicio(new Date());
		reg.setFechaHoraFin(new Date());
		repo.save(reg);
		
	}

	@Override
	public void operacionBorrar() {
		// poner un id  para que busque un  registro para que lo pueda borrar
		Optional<DTOBitacoraAcceso> op = repo.findById(26335);
		
		if(!op.isEmpty()) {
			DTOBitacoraAcceso reg = (DTOBitacoraAcceso)op.get();
			//borra registro de la tabla
			repo.delete(reg);
		}
			
		
		
		
		
	}

	@Override
	@Transactional(value="supycapTransactionManager", propagation = Propagation.REQUIRED,readOnly = false, rollbackFor = { Exception.class })
	public void ejecutarBusquedaCompuesta() {
		List<DTOBitacoraAcceso>  lista= repo.findByidSistemaAndUsuarioAndRolUsuario(148, "williams.pantoja", "ELECINE.ADMIN.OC");
		lista.size();
	}

	@Override
	@Transactional(value="supycapTransactionManager", propagation = Propagation.REQUIRED,readOnly = false, rollbackFor = { Exception.class })
	public void ejecutarQueryDTOEntidad() {
		
		List<DTOBitacoraAcceso>  lista= repo.pruebaBusquedaQuery(148, "williams.pantoja", "ELECINE.ADMIN.OC");
		
		//recorre la lista
		for (DTOBitacoraAcceso dtoBitacoraAcceso : lista) {
			System.out.println("id: "+dtoBitacoraAcceso.getIdBitacoraAcceso());
			System.out.println("usuario:"+dtoBitacoraAcceso.getUsuario());
			System.out.println("fecha inicio:"+dtoBitacoraAcceso.getFechaHoraInicio().toString());
		}
		System.out.println("tamanio lista:"+lista.size());		
	}

	@Override
	public void ejecutarQueryDTOSinEntidad() {
		
		Query q  = manager.createNativeQuery("select b.ID_BITACORA_ACCESO, b.ID_SISTEMA from bitacora_acceso b where b.usuario = 'williams.pantoja'");
		
		List<Object[]> bitacora  = q.getResultList();
		
		if(bitacora!= null)
			System.out.println("count:"+bitacora.size());
		
		List<DTOAspiranteCustom> listaa = (List<DTOAspiranteCustom>) 
				manager.createNativeQuery("SELECT    ASP.ID_ASPIRANTE idAspirante,   ASP.FOLIO folio,   ASP.CLAVE_ELECTOR_FUAR claveElector,   ASP.ID_CONVOCATORIA idConvocatoria,   ASP.NOMBRE || ' ' || ASP.apellido_Paterno  nombreCompleto,   EC.MOTIVO_PARTICIPAR motivoParticipar,   EI.PONDERACION_EXAMEN ponderacionExamen,   EI.PROMEDIO_ENTREVISTA_CAE promedioEntrevistaCae  FROM ASPIRANTES ASP INNER JOIN EVALUACION_CURRICULAR EC ON ASP.ID_PROCESO_ELECTORAL = EC.ID_PROCESO_ELECTORAL AND ASP.ID_DETALLE_PROCESO  = EC.ID_DETALLE_PROCESO AND ASP.ID_PARTICIPACION    = EC.ID_PARTICIPACION AND ASP.ID_ASPIRANTE        = EC.ID_ASPIRANTE INNER JOIN EVALUACION_INTEGRAL EI ON ASP.ID_PROCESO_ELECTORAL    = EI.ID_PROCESO_ELECTORAL AND ASP.ID_DETALLE_PROCESO     = EI.ID_DETALLE_PROCESO AND ASP.ID_PARTICIPACION       = EI.ID_PARTICIPACION AND ASP.ID_ASPIRANTE           = EI.ID_ASPIRANTE WHERE ASP.ID_PROCESO_ELECTORAL = :idProceso AND ASP.ID_DETALLE_PROCESO     = 105 AND ASP.ID_PARTICIPACION       = 1 AND ASP.FOLIO BETWEEN 50 AND 100",
			"mappingResultDTOAspiranteCustom").setParameter("idProceso", 11).
				getResultList();
		 for (DTOAspiranteCustom dtoAspiranteCustom : listaa) {
		 System.out.println(">>>>>   "+dtoAspiranteCustom.getClaveElector()); ; }
		 
		manager.close();
	}

}
