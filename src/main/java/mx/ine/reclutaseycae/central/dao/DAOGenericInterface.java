package mx.ine.reclutaseycae.central.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mx.org.ine.servicios.dto.DTOBase;
import mx.org.ine.servicios.query.QRYContainerInterface;

/**
 * Interface que define los m&eacute;todos b&aacute;sicos de un DAO (insertar,
 * actualizar, consultar o borrar informaci&oacute;n).
 *
 * @param <T>
 *            Clase utilizada como par&aacute;metro de persistencia a utilizar
 * @param <I>
 *            Clase utilizada como Id del par&aacute;metro de persistencia a
 *            utilizar
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 29/06/2017
 */
public interface DAOGenericInterface<T extends Serializable, I extends Serializable>  {
	
	
	 /* ----------------------------------------------------------------------------------------- */
    /* --------------------------------------- METODOS  ---------------------------------------- */
    /* ----------------------------------------------------------------------------------------- */

    /**
     * Obtiene el contenedor de querysException
     * @param
     * @return QRYContainerInterface contenedor con las querys.
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public QRYContainerInterface getContainer();
    
    
    /**
     * Persiste un objeto a la base de datos .
     * @param DTOBase
     *        : Objeto que se guardará en la base de datos
     * @return DTOBase ID: Objeto que representa el identificador del objeto guardado en la
     *         base de datos
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public I guardar(DTOBase object) throws Exception;
    
    /**
     * Modifica o actualiza un bojeto a la base de datos
     * @param DTOBase
     *        : Objeto que se modificará en la base de datos
     * @return
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public void modificar(DTOBase object);
    
    /**
     * Elimina un objeto de la base de datos
     * @param DTOBase
     *        : Objeto que se eliminará en la base de datos
     * @return
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public void eliminar(DTOBase object);
    
    /**
     * Método genérico para obtener una la lista de objetos ordenados por un atributo ordenado
     * ascendentemente
     * @param String
     *        : Atributo por el cúal se ordenara el resultado
     * @param Boolean
     *        : Orden ascendente (true) o descendente (false)
     * @return List<?>: Lista de objetos ordenados por el atributo definido
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public List<?> consultarTodosOrdenadosAscDescPor(String propiedadOrdenamiento, Boolean orden);

    /**
     * Obtiene la sesión actual de base de datos.
     * @param
     * @return Session : sesión actual de bd.
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public Session getSession();
    
    /**
     * Obtiene la instancia del objeto que se encarga de crear las sesiones de base de datos.
     * @param
     * @return SessionFactory : el valor del atributo <code>sessionFactory</code>
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public SessionFactory getSessionFactory();
    
    
    /**
     * Abre una sesión a base de datos.
     * @param
     * @return Session : Sesión de bd.
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public Session openSession();
    
    /**
     * Método que busca un objeto por su llave primaria
     * @param id
     *        : llave primaria del objeto que se busca
     * @return T : Objeto encontrado
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public T buscarPorId(I id);
    
    /**
     * Método que busca todos los registros en una tabla
     * @param
     * @return List<T> : lista con todos los objetos
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public List<T> buscarTodos();

    /**
     * Método para guardar (en caso de que sea un registro nuevo) o actualizar (en caso un
     * registro existente) un registro en la BD.
     * @param DTOBase
     *        : Objeto que se guardará o modificará en la base de datos
     * @return
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public void guardarOactualizar(DTOBase object);

    /**
     * Método para eliminar un objeto pero con la regla donde primero se modifica el registro y
     * despues se elimina en la BD.
     * @param DTOBase
     *        : Objeto que se modificará y eliminará en la base de datos
     * @return
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public void modificarYeliminar(DTOBase object);

    /**
     * Método que ejecuta una serie de codigos los cuales hacen que durante la consulta en las
     * comparaciones no se haga distinción entre Mayusculas, Minusculas y Acentos, por ejemplo
     * si se hace un like sobre un campo digamos "Nombre" y se esta pasando el valor "maria" y
     * existen valores como María, Maria, mAria, este los traera como resultado.
     * @param
     * @return
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public void activaMatchModeWords();

    /**
     * Método para sincronizar los datos en sesión con los que se encuentran en la base de
     * datos
     * @param
     * @return
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public void flush();

    /**
     * Obtiene la clase de persistencia de este dao
     * @param
     * @return Class<T>: Clase de persistencia del DAO
     * @author Israel Vázquez Jiménez
     * @since 06/06/2016
     */
    public Class<T> getPersistentClass();
    
    
    
    
	/**
	 * Funci&oacute;n que guarda una entidad determinada. Utilizar la instancia
	 * devuelta para operaciones adicionales, ya que la operaci&oacute;n de
	 * guardar podr&iacute;a haber cambiado completamente la instancia de
	 * entidad.
	 *
	 * @param <S>
	 *            clase del objeto a guardar.
	 * @param entity
	 *            la entidad a guardar.
	 *
	 * @return la entidad guardada.
	 *
	 * @author Jos&eacute; Carlos Ortega Romano
	 * @since 30/06/2017
	 */
	//<S extends T> S guardar(S entity);
	
//	void save(Object entidad);

	/**
	 * Funci&oacute;n que recupera una entidad por su id.
	 *
	 * @param id
	 *            el id de la entidad. el id no debe ser {@literal null}.
	 *
	 * @return la entidad con el id dado o {@literal null} si no se encuentra
	 *         ninguna.
	 *
	 * @throws IllegalArgumentException
	 *             si {@code id} es {@literal null}.
	 * @author Jos&eacute; Carlos Ortega Romano
	 * @since 05/07/2017
	 */
//	T buscarPorId(I id);

	/**
	 * Funci&oacute;n que determina si existe una entidad con el id dado.
	 *
	 * @param id
	 *            el id de la entidad. el id no debe ser {@literal null}.
	 *
	 * @return {@code true} si existe una entidad con el id dado,
	 *         {@literal false} en caso contrario.
	 *
	 * @throws IllegalArgumentException
	 *             si {@code id} es {@literal null}.
	 * @author Jos&eacute; Carlos Ortega Romano
	 * @since 05/07/2017
	 */
//	boolean existe(I id);

	/**
	 * Funci&oacute;n que elimina una entidad determinada.
	 *
	 * @param entity
	 *            la entidad a eliminar.
	 *
	 * @throws IllegalArgumentException
	 *             en caso de que la entidad dada sea {@literal null}.
	 * @author Jos&eacute; Carlos Ortega Romano
	 * @since 05/07/2017
	 */
//	void eliminar(T entity, I id);
//
//	void eliminar(T entity);

	/**
	 * Método para sincronizar los datos en sesión con los que se encuentran en
	 * la base de datos
	 * 
	 * @since 15/01/2018
	 */
	//public void flush();

	/**
	 * Funci&oacute;n encargada de sincronizar los cambios de la
	 * infromaci&oacute;n en la base de datos
	 *
	 * @author Jos&eacute; Antonio L&oacute;pez Torres
	 * @since 09/03/2018
	 */
	//void clear();


	
}
