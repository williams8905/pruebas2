package mx.ine.reclutaseycae.central.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ine.reclutaseycae.central.dao.DAOBitacoraAccesoInterface;
import mx.ine.reclutaseycae.central.dto.DTOCFechasCaptura;
import mx.ine.reclutaseycae.central.dto.DTOCTiposTaller;
import mx.ine.reclutaseycae.central.dto.db.DTOBitacoraAcceso;
import mx.ine.reclutaseycae.central.util.Constantes;


@Scope("prototype")
@Service("daoBitacoraAcceso")
public class DAOBitacoraAccesoImpl extends DAOGenericImpl<DTOBitacoraAcceso, Serializable> implements DAOBitacoraAccesoInterface{

	
	private static final long serialVersionUID = -5228570974923015311L;
	
	
	/**Metodo que obtiene el numero consecutivo de la bitacora
	 * 
		String query = getContainer().getQuery("query_fechaCaptura");
		SQLQuery sqlQuery = getSession().createSQLQuery(query)
				.addScalar("idEstado", IntegerType.INSTANCE)
		        .addScalar("idDistrito", IntegerType.INSTANCE)
		        .addScalar("fecha", StringType.INSTANCE);
		sqlQuery.setInteger("idProcesoElectoral", 11);
		sqlQuery.setInteger("idParametro", idParametroFecha);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(DTOCFechasCaptura.class));
		
		lista = sqlQuery.list();
	 * 
	 * 
	*/
	public Integer obtenNumSecBitacora() throws Exception{
		String query = getContainer().getQuery("query.bitacora.secuencia.bitacora");
		SQLQuery sqlquery = getSession().createSQLQuery(query);
		BigDecimal num = (BigDecimal) sqlquery.uniqueResult();
	return num.intValue();
	}
	
	
	/*Metodo que inserta un registro en la bitacora	*/
	
	public void agregarRegistroBitacora(DTOBitacoraAcceso bitacora)
			throws Exception{
		
		
	}


	@Override
	public void cerrarSesionRegistroBitacora(DTOBitacoraAcceso bitacora) throws Exception {
		//bitacora.setIdBitacoraAcceso(this.obtenNumSecBitacora());
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public Integer obtenSesionActiva(DTOBitacoraAcceso bitacora) {
		String query = getContainer().getQuery("query.bitacora.sesion.activa");
		SQLQuery sqlquery = getSession().createSQLQuery(query);
		sqlquery.setString("usuario", bitacora.getUsuario());
		sqlquery.setInteger("idSistema", bitacora.getIdSistema());
		sqlquery.setInteger("duracionSesion", Constantes.DURACION_SESION);
		
		BigDecimal num = (BigDecimal) sqlquery.uniqueResult();
		return num != null?num.intValue():null;
	}


	@Override
	public DTOBitacoraAcceso obtenRegistroSesionActiva(DTOBitacoraAcceso bitacora) {
		List<DTOBitacoraAcceso> lista;
		String query = getContainer().getQuery("query.bitacora.registro.sesion.activa");
		SQLQuery sqlquery = getSession().createSQLQuery(query)
				.addScalar("idBitacoraAcceso", IntegerType.INSTANCE)
				.addScalar("idSistema", IntegerType.INSTANCE)
				.addScalar("usuario", StringType.INSTANCE)
				.addScalar("rolUsuario", StringType.INSTANCE)
				.addScalar("fechaHoraInicio", DateType.INSTANCE)
				.addScalar("fechaHoraFin", DateType.INSTANCE)
				.addScalar("ipUsuario", StringType.INSTANCE)
				.addScalar("ipNodo", StringType.INSTANCE)
				;
		sqlquery.setString("usuario", bitacora.getUsuario());
		sqlquery.setInteger("idSistema", bitacora.getIdSistema());
		//sqlquery.setInteger("duracionSesion", Constantes.DURACION_SESION);
		sqlquery.setResultTransformer(Transformers.aliasToBean(DTOBitacoraAcceso.class));
		//sqlquery.addEntity(DTOBitacoraAcceso.class);
		
		lista =  sqlquery.list();
		
		return lista.get(0);
	}




	
	
}
