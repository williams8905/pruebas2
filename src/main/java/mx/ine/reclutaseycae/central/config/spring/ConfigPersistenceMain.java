/**
 * @(#)ConfigPersistence.java 05/12/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.config.spring;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Clase de configuraci&oacute;n que define las propiedades generales de la persistencia de datos.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 05/12/2017
 */
@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:ApplicationConfig.properties")
@PropertySource("classpath:application.properties")
public class ConfigPersistenceMain {
	
	private final Environment environment;

    /**
     * Constructor con par&aacute;metros.
     *
     * @param environment objeto que contiene las propiedades de la aplicaci&oacute;n.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Autowired
    public ConfigPersistenceMain(Environment environment) {
        this.environment = environment;
    }
    
    /**
     * Funci&oacute;n que obtiene la implementaci&oacute;n de JPA utilizado por Hibernate.
     *
     * @return la implementaci&oacute;n de JPA utilizado por Hibernate.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform(environment.getProperty("jpa.database-platform"));        
        return jpaVendorAdapter;
    }

    /**
     * Funci&oacute;n que determina las propiedades que se utilizar&aacute;n para la conexi&oacute;n de la base de
     * datos.
     *
     * @return las propiedades que se utilizar&aacute;n para la conexi&oacute;n de la base de datos.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 04/12/2017
     */
    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        
        properties.setProperty("hibernate.dialect", environment.getProperty("jpa.database-platform"));
        properties.setProperty("hibernate.max_fetch_depth", "1");
        properties.setProperty("hibernate.default_batch_fetch_size", "16");
        properties.setProperty("hibernate.jdbc.fetch_size", environment.getProperty("hibernate.jdbc.fetch_size"));
        properties.setProperty("hibernate.jdbc.batch_size", environment.getProperty("hibernate.jdbc.batch_size"));
        properties.setProperty("hibernate.jdbc.wrap_result_sets", "true");
        properties.setProperty("hibernate.order_inserts", "true");
        properties.setProperty("hibernate.order_updates", "true");
        properties.setProperty("hibernate.cache.region.factory_class", "infinispan");
//        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
//        properties.setProperty("hibernate.cache.region.factory_class", "org.infinispan.hibernate.cache.v53.InfinispanRegionFactory");
        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.cache.use_minimal_puts", "true");
//        properties.setProperty("hibernate.transaction.manager_lookup_class","org.jboss.cache.transaction.JBossTransactionManagerLookup");
//        properties.setProperty("hibernate.transaction.jta.platform","org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform");
        properties.setProperty("hibernate.cache.auto_evict_collection_cache", "true");        
        properties.setProperty("hibernate.cache.use_reference_entries", "true");        
		/* properties.setProperty("hibernate.transaction.jta.platform", "JBossAS"); */       
		/* properties.setProperty("hibernate.transaction.coordinator_class", "jta"); */
        properties.setProperty("hibernate.implicit_naming_strategy", "default");                  
//        properties.setProperty("hibernate.enhancer.enableDirtyTracking", "true");
//        properties.setProperty("hibernate.enhancer.enableLazyInitialization", "true");
//        properties.setProperty("hibernate.enhancer.enableAssociationManagement", "true");        
        properties.setProperty("org.hibernate.flushMode", "AUTO");
		/*
		 * properties.setProperty("javax.persistence.schema-generation.database.action",
		 * "create");
		 * properties.setProperty("javax.persistence.create-database-schemas", "true");
		 */
        return properties;
    }

    
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


}
