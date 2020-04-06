/**
 * @(#)ConfigBeans.java 05/12/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.config.spring;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Clase de configuraci&oacute;n que define las propiedades generales de la aplicaci&oacute;n web.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 05/12/2017
 */
@Configuration
//@PropertySource("classpath:ApplicationConfig.properties")
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"mx.ine.reclutaseycae.central, mx.ine.servicio.admin"})
@EnableAsync
public class ConfigBeans {

	private final Environment environment;

    private final JndiTemplate jndiTemplate;

    /**
     * Constructor con par&aacute;metros.
     *
     * @param environment objeto que contiene las propiedades de la aplicaci&oacute;n.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Autowired
    public ConfigBeans(Environment environment) {
        this.environment = environment;
        this.jndiTemplate = new JndiTemplate();
    }
    
    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code propertySourcesPlaceholderConfigurer}.
     *
     * @return la instancia del bean {@code propertySourcesPlaceholderConfigurer}.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code localeResolver}.
     *
     * @return la instancia del bean {@code localeResolver}.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }
    
    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code messageSource}.
     *
     * @return la instancia del bean {@code messageSource}.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames(new String[] {"messages"});
//        messageSource.setBasenames(new String[] {"ApplicationResources", "GenericConstants", "MessageResources"});

        return messageSource;
    }

    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code rutaGluster}.
     *
     * @return la instancia del bean {@code rutaGluster}.
     *
     * @throws NamingException en caso de ocurrir un error al obtener el valor del JNDI.
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public String rutaGluster() throws NamingException {
        String jndiRutaGluster = environment.getProperty("jndi.gluster.path");
        return jndiTemplate.lookup(jndiRutaGluster, String.class);
    }
    
    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code mailSender}.
     *
     * @return la instancia del bean {@code mailSender}.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setDefaultEncoding("UTF-8");
        mailSender.setHost(environment.getProperty("correo.host"));
        mailSender.setUsername(environment.getProperty("correo.usuario"));
        mailSender.setPassword(environment.getProperty("correo.password"));

        return mailSender;
    }

    /**
     * Funci&oacute;n que obtiene la instancia del bean {@code taskExecutor}.
     *
     * @return la instancia del bean {@code taskExecutor}.
     *
     * @author José Guadalupe Burgos Colomoxcatl
     * @since 25/09/2018
     */
    @Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(Integer.parseInt(environment.getProperty("spring.taskExecutor.corePoolSize")));
		pool.setMaxPoolSize(Integer.parseInt(environment.getProperty("spring.taskExecutor.maxPoolSize")));
		pool.setAwaitTerminationSeconds(Integer.parseInt(environment.getProperty("spring.taskExecutor.awaitTerminationSeconds")));
		pool.setWaitForTasksToCompleteOnShutdown(Boolean.parseBoolean(environment.getProperty("spring.taskExecutor.waitForTasksToCompleteOnShutdown")));
		return pool;
	}
    
}
