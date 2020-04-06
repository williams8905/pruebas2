/**
 * 
 */
package mx.ine.reclutaseycae.central.config.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;

/**
 * @author José
 *
 */
@Configuration
@EnableLoadTimeWeaving
@EnableAspectJAutoProxy
@Import({ConfigBeans.class, 
		 ConfigPersistenceMain.class, 
		 ConfigPersistenceSUPYCAP.class, 
		 ConfigSecurity.class})
public class ConfigApplicationContext {

}
