package mx.ine.reclutaseycae.central.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;

import mx.ine.reclutaseycae.central.dao.DAOGenericInterface;
import mx.org.ine.servicios.dto.DTOBase;
import mx.org.ine.servicios.query.QRYContainerInterface;

/**
 * Clase que define la implementaci&oacute;n de los Metodos b&aacute;sicos de un DAO (insertar, actualizar, consultar o
 * borrar informaci&oacute;n).
 *
 * @param <T> Clase utilizada como par&aacute;metro de persistencia a utilizar
 * @param <I> Clase utilizada como Id del par&aacute;metro de persistencia a utilizar
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 29/06/2017
 */

public class DAOGenericImpl<T extends Serializable, I extends Serializable> implements DAOGenericInterface<T, I>  {
	
    @SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(DAOGenericImpl.class);
	
    
    /**
	 * Creador de sesiones de base de datos.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	/*@Autowired
	private SessionFactory sessionFactorySUPyCAP;*/
    
	
	/*@Autowired
	private SessionFactory sessionFactorySUPyCAPReportes;*/
    /**
	 * Atributo de persistencia
	 */
	private Class<T> persistentClass;
    
    /**
	 **
	 * Contenedor de queries.
	 */
	@Autowired
	@Qualifier("qryContainer")
	@SessionScoped
	private QRYContainerInterface qryContainer;
	

    
    /**
     * Constructor por defecto que inicializa la clase de persistencia.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/07/2017
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public DAOGenericImpl() {
        this.persistentClass = (Class) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    /*
	 * --------------------------------- METODOS
	 * --------------------------------------
	 */
    
    /*
	 * (non-Javadoc)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#getContainer()
	 */
	@Override
	public QRYContainerInterface getContainer() {
		return qryContainer;
	}
	
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see
	 * mx.ine.pautas.dao.DAOGenericPautasInterface#guardar(mx.org.ine.servicios.
	 * dto.DTOBase)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public I guardar(DTOBase object) {
		object.setUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
		object.setFechaHora(new Date());
		return (I) getSession().save(object);

	}
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#modificar(mx.org.ine.
	 * servicios.dto.DTOBase)
	 */
	@Override
	public void modificar(DTOBase object) {

		object.setUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
		object.setFechaHora(new Date());
		getSession().update(object);
	}
    
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see
	 * mx.ine.pautas.dao.DAOGenericPautasInterface#eliminar(mx.org.ine.servicios
	 * .dto.DTOBase)
	 */
	@Override
	public void eliminar(DTOBase object) {
		modificar(object);
		getSession().delete(object);
	}
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#
	 * consultarTodosOrdenadosAscDescPor(java.lang.String, java.lang.Boolean)
	 */
	public List<?> consultarTodosOrdenadosAscDescPor(String propiedadOrdenamiento, Boolean orden) {
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());

		if (orden != null && orden) {
			criteria.addOrder(Order.asc(propiedadOrdenamiento));
		}

		if (orden != null && orden) {
			criteria.addOrder(Order.desc(propiedadOrdenamiento));
		}

		return criteria.list();
	}
	
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#getPersistentClass()
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#getSession()
	 */
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	// BASE DE DATOS PRINCIPAL
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
    
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#openSession()
	 */
	@Override
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	
	/*******************************************************************/
	/******************   Session de SUPYCAP         *******************/
	/*******************************************************************/
	
//	/**
//	 * Metodo que regresa la session activa de reportes
//	 */
//	public Session getSessionSUPyCAP() {
//		return sessionFactorySUPyCAP.getCurrentSession();
//	}
//
//	/**
//	 * Metodo que regresa el objeto sessionFactoryReportes
//	 */
//	public SessionFactory getSessionFactorySUPyCAP() {
//		return sessionFactorySUPyCAP;
//	}
//
//	/**
//	 * Metodo que abre la sesión hacia el JNDI de REPORTES
//	 */
//	public Session openSessionSUPyCAP() {
//		return sessionFactorySUPyCAP.openSession();
//	}
//	
//	/**
//	 * Método que cierra la sesión hacia el JNDI de Reportes
//	 */
//	public void closeSessionSUPyCAP() {
//		sessionFactorySUPyCAP.close();
//	}
//	
//	/*******************************************************************/
//	/****************** Session de SUPYCAP Reportes  *******************/
//	/*******************************************************************/
//	
//	/**
//	 * Metodo que regresa la session activa de reportes
//	 */
//	public Session getSessionSUPyCAPReportes() {
//		return sessionFactorySUPyCAPReportes.getCurrentSession();
//	}
//
//	/**
//	 * Metodo que regresa el objeto sessionFactoryReportes
//	 */
//	public SessionFactory getSessionFactorySUPyCAPReportes() {
//		return sessionFactorySUPyCAPReportes;
//	}
//
//	/**
//	 * Metodo que abre la sesión hacia el JNDI de REPORTES
//	 */
//	public Session openSessionSUPyCAPReportes() {
//		return sessionFactorySUPyCAPReportes.openSession();
//	}
//	
//	/**
//	 * Método que cierra la sesión hacia el JNDI de Reportes
//	 */
//	public void closeSessionSUPyCAPReportes() {
//		sessionFactorySUPyCAPReportes.close();
//	}
//	
	
	
		
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#buscarPorId(ID)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T buscarPorId(I id) {
		return (T) getSession().get(getPersistentClass(), id);
	}
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#buscarTodos()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		return criteria.list();
	}
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see
	 * mx.ine.pautas.dao.DAOGenericPautasInterface#guardarOactualizar(mx.org.ine
	 * .servicios.dto.DTOBase)
	 */
	@Override
	public void guardarOactualizar(DTOBase object) {
		
		object.setFechaHora(new Date());
		getSession().saveOrUpdate(object);
	}

	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see
	 * mx.ine.pautas.dao.DAOGenericPautasInterface#modificarYeliminar(mx.org.ine
	 * .servicios.dto.DTOBase)
	 */
	@Override
	public void modificarYeliminar(DTOBase object) {
		object.setUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
		object.setFechaHora(new Date());
		getSession().update(object);
		getSession().delete(object);
	}
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#activaMatchModeWords()
	 */
	@Override
	public void activaMatchModeWords() {
		getSession().createSQLQuery("ALTER SESSION SET NLS_SORT=BINARY_AI").executeUpdate();
		getSession().createSQLQuery("ALTER SESSION SET NLS_COMP=LINGUISTIC").executeUpdate();
		getSession().createSQLQuery("COMMIT").executeUpdate();
	}
	
	/*
	 * (non-Javadoc) (El comentario se encuentra en la interfase donde esta
	 * declarado el método)
	 * 
	 * @see mx.ine.pautas.dao.DAOGenericPautasInterface#flush()
	 */
	@Override
	public void flush() {
		getSession().flush();
	}
	
	
	
}
