/**
 * @(#)ConfigPersistenceRepresentantes.java 06/12/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.config.spring;

import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Clase de configuraci&oacute;n que define las propiedades de la persistencia de datos para la base de datos de
 * Representantes.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 06/12/2017
 */
@Configuration
@EnableTransactionManagement
//@EntityScan(basePackages = "com.springbootdev.examples.entity")
@EnableJpaRepositories(
		basePackages = "mx.ine.reclutaseycae.central.repository",
		entityManagerFactoryRef = "supycapReportesEntityManagerFactory",
		transactionManagerRef = "supycapReportesTransactionManager")
public class ConfigPersistenceSUPYCAPReportes {
	
	private final Environment environment;

    private final JpaVendorAdapter jpaVendorAdapter;

    private final Properties hibernateProperties;

    /**
     * Constructor con par&aacute;metros.
     *
     * @param environment         objeto que contiene las propiedades de la aplicaci&oacute;n.
     * @param jpaVendorAdapter    objeto que contiene la implementaci&oacute;n de JPA utilizado por Hibernate.
     * @param hibernateProperties conjunto de propiedades que se utilizar&aacute;n para la conexi&oacute;n de la base de
     *                            datos.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 06/12/2017
     */
    @Autowired
    public ConfigPersistenceSUPYCAPReportes(Environment environment,
            @Qualifier("jpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter,
            @Qualifier("hibernateProperties") Properties hibernateProperties) {
        this.environment = environment;
        this.jpaVendorAdapter = jpaVendorAdapter;
        this.hibernateProperties = hibernateProperties;
    }

    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code dataSource}.
     *
     * @return la instancia del bean {@code dataSource}.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
//    @Bean()    
    private DataSource supycapReportesDataSource() {
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource(environment.getProperty("dataSource.jndiNameSUPYCAPReportes"));
    }

    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code transactionManager}.
     *
     * @return la instancia del bean {@code transactionManager}.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public PlatformTransactionManager supycapReportesTransactionManager() {
        return new JtaTransactionManager();
    }
    
    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code entityManagerFactory}.
     *
     * @return la instancia del bean {@code entityManagerFactory}.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean supycapReportesEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);        
        emf.setPersistenceUnitName("supycapReportesPU");
        emf.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        emf.setJtaDataSource(supycapReportesDataSource());
//        emf.setPackagesToScan("mx.ine.representantes.dto.db.representantes");
//        emf.setPackagesToScan(environment.getProperty("datasource.jndi-name"));
        emf.setPackagesToScan(environment.getProperty("hibernate.pack.scan"));        
        //emf.setMappingResources("query/orm.xml");
        emf.setJpaProperties(hibernateProperties);
        return emf;        
    }
    
}
