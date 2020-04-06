/**
 * @(#)SecurityResponseHeadersFilter.java 25/01/2018
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase de filtro de seguridad gen&eacute;rico del sistema, encargado de agregar los encabezados requeridos para
 * proteger las peticiones HTTP.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 25/01/2018
 */
public class SecurityResponseHeadersFilter implements Filter {
    private static final Log LOGGER = LogFactory.getLog(SecurityResponseHeadersFilter.class);

    private String filterDenyMode = "DENY";

    private String filterSameOriginMode = "SAMEORIGIN";

    private String filterCacheMode = "no-cache, no-store, max-age=0, must-revalidate";

    private String filterPragmaMode = "no-cache";

    private String filterContentTypeMode = "nosniff";

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.trace("Inicializando el filtro de los encabezados de seguridad para la respuesta");

        assignClickjackingMode(filterConfig);
        assignGeneralMode(filterConfig);
    }

    /**
     * Funci&oacute;n que inicializa los valores que tendr&aacute;n los encabezados de prevenci&oacute;n de ataques de
     * clickjacking.
     *
     * @param filterConfig objeto con la informaci&oacute;n del filtro utilizado.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 25/01/2018
     */
    private void assignClickjackingMode(FilterConfig filterConfig) {
        String configFilterDenyMode = filterConfig.getInitParameter("filterDenyMode");
        if (StringUtils.isNotBlank(configFilterDenyMode)) {
            filterDenyMode = configFilterDenyMode;
        }

        String configFilterSameOriginMode = filterConfig.getInitParameter("filterSameOriginMode");
        if (StringUtils.isNotBlank(configFilterSameOriginMode)) {
            filterSameOriginMode = configFilterSameOriginMode;
        }
    }

    /**
     * Funci&oacute;n que inicializa los valores que tendr&aacute;n los encabezados de protecci&oacute;n de peticiones
     * HTTP.
     *
     * @param filterConfig objeto con la informaci&oacute;n del filtro utilizado.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 25/01/2018
     */
    private void assignGeneralMode(FilterConfig filterConfig) {
        String configCacheMode = filterConfig.getInitParameter("filterCacheMode");
        if (StringUtils.isNotBlank(configCacheMode)) {
            filterCacheMode = configCacheMode;
        }

        String configPragmaMode = filterConfig.getInitParameter("filterPragmaMode");
        if (StringUtils.isNotBlank(configPragmaMode)) {
            filterPragmaMode = configPragmaMode;
        }

        String configContentTypeMode = filterConfig.getInitParameter("filterContentTypeMode");
        if (StringUtils.isNotBlank(configContentTypeMode)) {
            filterContentTypeMode = configContentTypeMode;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.trace("Agregando los encabezados de seguridad a la respuesta");
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // ClickJack
        httpServletResponse.setHeader("X-Frame-Options", filterDenyMode);
        httpServletResponse.setHeader("X-Frame-Options", filterSameOriginMode);

        // Otros encabezados
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Access-Control-Request-Headers, Access-Control-Request-Method, Access-Control-Allow-Origin, Origin, X-Requested-With, Content-Type, Accept, Authorization");
        httpServletResponse.setHeader("Cache-Control", filterCacheMode);
        httpServletResponse.setHeader("Pragma", filterPragmaMode);
        httpServletResponse.setHeader("Expires", "0");
        httpServletResponse.setHeader("X-Content-Type-Options", filterContentTypeMode);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        LOGGER.trace("Destruyendo el filtro de los encabezados de seguridad para la respuesta");
    }
}
