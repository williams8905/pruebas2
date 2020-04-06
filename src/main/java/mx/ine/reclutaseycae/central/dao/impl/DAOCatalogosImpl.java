package mx.ine.reclutaseycae.central.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import mx.ine.reclutaseycae.central.dao.DAOCatalogos;
import mx.ine.reclutaseycae.central.dto.DTOCFechasCaptura;
import mx.ine.reclutaseycae.central.dto.DTOCTiposTaller;

@Scope("prototype")
@Repository("daoCatalogos")
public class DAOCatalogosImpl extends DAOGenericImpl<DTOCTiposTaller, Serializable> implements DAOCatalogos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2391276075597788400L;
	
	
	
	@Override
	public List<DTOCFechasCaptura> obtenFechasCaptura(Integer idParametroFecha) {
		List<DTOCFechasCaptura> lista;
		
		String query = getContainer().getQuery("query_fechaCaptura");
		SQLQuery sqlQuery = getSession().createSQLQuery(query)
				.addScalar("idEstado", IntegerType.INSTANCE)
		        .addScalar("idDistrito", IntegerType.INSTANCE)
		        .addScalar("fecha", StringType.INSTANCE);
		sqlQuery.setInteger("idProcesoElectoral", 11);
		sqlQuery.setInteger("idParametro", idParametroFecha);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(DTOCFechasCaptura.class));
		
		lista = sqlQuery.list();
		
		return lista;
	}



	@Override
	public List<DTOCTiposTaller> obtenTiposTaller() {
		List<DTOCTiposTaller> lista;
		
		String query = getContainer().getQuery("query_tiposTaller");
		SQLQuery sqlQuery = getSession().createSQLQuery(query)
				.addScalar("idProcesoElectoral", IntegerType.INSTANCE)
		        .addScalar("idDetalleProceso", IntegerType.INSTANCE);
		sqlQuery.setInteger("idProcesoElectoral", 11);
		sqlQuery.setInteger("idDetalleProceso", 105);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(DTOCTiposTaller.class));
		
		lista = sqlQuery.list();
		
		for(DTOCTiposTaller e: lista) {
			System.out.println(e.getIdProcesoElectoral()+" "+e.getIdDetalleProceso());
		}
		return lista;
	}
	
	
	@Override
	public List<DTOCTiposTaller> obtenTiposTallerReportes() {
		List<DTOCTiposTaller> lista;
		
		String query = getContainer().getQuery("query_tiposTaller");
		SQLQuery sqlQuery = getSession().createSQLQuery(query)
				.addScalar("idProcesoElectoral", IntegerType.INSTANCE)
		        .addScalar("idDetalleProceso", IntegerType.INSTANCE);
		sqlQuery.setInteger("idProcesoElectoral", 11);
		sqlQuery.setInteger("idDetalleProceso", 105);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(DTOCTiposTaller.class));
		
		lista = sqlQuery.list();
		for(DTOCTiposTaller e: lista) {
			System.out.println(e.getIdProcesoElectoral()+" "+e.getIdDetalleProceso());
		}
		
		return lista;
	}

	
	
	
	
}
