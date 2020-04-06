/**
 * @(#)XSSPreventionFilter.java 27/06/2017
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase de filtro de seguridad que escapa todos los par&aacute;metros de una petici&oacute;n {@link HttpServletRequest}
 * para evitar ataques XSS.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 25/01/2018
 */
public class XSSPreventionFilter implements Filter {
    private static final Log LOGGER = LogFactory.getLog(XSSPreventionFilter.class);

    /**
     * Variable del modo de operaci&oacute;n del filtro
     * <p>
     * <ul> <li>0 - Filtro deshabilitado.</li> <li>1 - Filtro habilitado. Si se detecta un ataque cross-site scripting,
     * para detener el ataque, el navegador desinfectar&aacute; la p&aacute;gina.</li> <li>1; mode=block - Filtro
     * habilitado. En lugar de desinfectar la p&aacute;gina, cuando se detecta un ataque XSS, el navegador
     * evitar&aacute; la representaci&oacute;n de la p&aacute;gina.</li> <li>1; report=http://[DOMINIO]/report_URI -
     * Filtro habilitado. El navegador desinfectar&aacute; la p&aacute;gina e informar&aacute; de la infracci&oacute;n.
     * Esta es una funci&oacute;n de Chromium que utiliza informes de violaci&oacute;n de CSP para enviar detalles a un
     * URI de su elecci&oacute;n.</li> </ul>
     */
    private String mode = "1";

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.trace("Inicializando el filtro XSSFilter");

        String configMode = filterConfig.getInitParameter("mode");
        if (StringUtils.isNotBlank(configMode)) {
            mode = configMode;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.trace("Procesando el filtro XSSFilter");
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        XSSRequestWrapper wrapper = new XSSRequestWrapper(httpServletRequest);
        httpServletResponse.setHeader("X-XSS-Protection", mode);

        String uriAux = wrapper.getRequestURI();
        String uri = wrapper.stripXSS(uriAux);

        if (uriAux != null && uri != null && !uriAux.equalsIgnoreCase(uri) && !httpServletResponse.isCommitted()) {
            throw new ServletException("Se encontraron simbolos no permitidos.");
        }

        filterChain.doFilter(wrapper, httpServletResponse);
        
        try {
            if(!httpServletResponse.isCommitted()){
        	httpServletResponse.resetBuffer();
		httpServletResponse.setStatus(400);
		PrintWriter out = httpServletResponse.getWriter();
		httpServletResponse.setContentType("application/json");
		
		out.println("{\"Error\": \"Ocurri\u00F3 un error inesperado\",");
		out.println("\"Mensaje\": \"Se encontraron simbolos no permitidos.\"}");
		out.flush();
		out.close();
		httpServletResponse.setContentType(out.toString());  
            }
	} catch (Exception e) {
		e.printStackTrace();
	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        LOGGER.trace("Destruyendo el filtro XSSFilter");
    }
}
