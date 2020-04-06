/**
 * @(#)ConfigSecurity.java 05/12/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.SessionManagementFilter;

import mx.ine.reclutaseycae.central.security.CustomAuthenticationProvider;
import mx.ine.reclutaseycae.central.security.JwtAuthenticationEntryPoint;
import mx.ine.reclutaseycae.central.security.JwtAuthenticationFilter;

import org.springframework.security.config.BeanIds;


/**
 * Clase de configuraci&oacute;n que define las propiedades de la seguridad de la aplicaci&oacute;n.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 05/12/2017
 */
@Configuration
@EnableWebSecurity
class ConfigSecurity extends WebSecurityConfigurerAdapter {

	//private final AuthenticationProvider authenticationProvider;

	
	 @Autowired
	 
	 @Qualifier("authenticationProvider") 
	 private CustomAuthenticationProvider	 authenticationProvider;
	 
	
	
	
	
    private final Environment environment;

    /**
     * Constructor con par&aacute;metros.
     *
     * @param authenticationProvider proveedor de autenticaci&oacute;n.
     * @param environment            objeto que contiene las propiedades de la aplicaci&oacute;n.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 05/12/2017
     */
    @Autowired
    public ConfigSecurity(
            Environment environment) {
    	
        this.environment = environment;
    }
    
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//    	
//    	httpSecurity.csrf().disable()
//    		.headers().frameOptions().deny()
//    		.and().headers().frameOptions().sameOrigin()
//	    	.and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//	    	//.authorizeRequests().antMatchers("/"
//	    	//		, "favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg","/**/*.html", "/**/*.css", "/**/*.js").permitAll()
//			.and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()
//				.antMatchers(HttpMethod.POST, "/ws/validateUser/**").permitAll()
//				.antMatchers(HttpMethod.OPTIONS, "/ws/auth/**").permitAll()
//				//.anyRequest().authenticated()
//			;
//    	
//    	httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);    	    	       
//        
//    }
    
    
    
    
	/*
	 * @SuppressWarnings({ "unchecked", "rawtypes" })
	 * 
	 * @Bean public FilterRegistrationBean xssPreventFilter() {
	 * FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	 * 
	 * registrationBean.setFilter(new XSSPreventionFilter());
	 * registrationBean.addUrlPatterns("/*");
	 * 
	 * return registrationBean; }
	 * 
	 * @SuppressWarnings({ "rawtypes", "unchecked" })
	 * 
	 * @Bean public FilterRegistrationBean securityResponseHeadersFilter() {
	 * FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	 * 
	 * registrationBean.setFilter(new SecurityResponseHeadersFilter());
	 * registrationBean.addUrlPatterns("/*");
	 * 
	 * return registrationBean; }
	 */
       
       @Override
       protected void configure(HttpSecurity http) throws Exception {      
           //http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
   	http.csrf().disable()
   			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
   			.and()
   			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
   			.and().authorizeRequests().antMatchers("/", "favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg",
   					"/**/*.html", "/**/*.css", "/**/*.js").permitAll()
   			.antMatchers(HttpMethod.POST, "/ws/validateUser/**").permitAll()
   			.antMatchers(HttpMethod.OPTIONS, "/ws/validateUser/**").permitAll()
   			.anyRequest().authenticated();
   		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
       }
       
       
       
       /*******************/
       /**
   	 * Proveedor de autenticaci&oacute;n.
   	 */
	/*
	 * @Autowired
	 * 
	 * @Qualifier("authenticationProvider") private CustomAuthenticationProvider
	 * authenticationProvider;
	 */
   	
   	/**
   	 * Manejador de petici&oacute;n sin autorizaci&oacute;.
   	 */
   	@Autowired
   	private JwtAuthenticationEntryPoint unauthorizedHandler;
   	
   	/**
   	 * Obtiene la instancia del bean encargado de autenticar el JWT.
   	 *
   	 * @return instancia del bean {@code JwtAuthenticationFilter}.
   	 *
   	 * @author INE
   	 * @since 22/08/2018
   	 */
   	@Bean
   	public JwtAuthenticationFilter jwtAuthenticationFilter() {
   		return new JwtAuthenticationFilter();
   	}
   	
   	/**
        * {@inheritDoc}
        */
   	@Override
   	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
   		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
   	}
   	
   	/**
        * {@inheritDoc}
        */
   	@Bean(BeanIds.AUTHENTICATION_MANAGER)
   	@Override
   	public AuthenticationManager authenticationManagerBean() throws Exception {
   		return super.authenticationManagerBean();
   	}
       
       
	
}
