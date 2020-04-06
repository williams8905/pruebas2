/**
 * @(#)XSSRequestWrapper.java 25/01/2018
 * <p>
 * Copyright (C) 2017 Instituto Nacional Electoral (INE).
 * <p>
 * Todos los derechos reservados.
 */
package mx.ine.reclutaseycae.central.security;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase que que adapta las peticiones <code>request</code> para ejecutar el filtrado y eliminar caracteres mailciosos.
 *
 * @author Jos&eacute; Carlos Ortega Romano
 * @copyright Direcci&oacute;n de sistemas - INE
 * @since 25/01/2018
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {
    private static final Log LOGGER = LogFactory.getLog(XSSRequestWrapper.class);

    private Map<String, String[]> sanitizedQueryString;

    /**
     * Constructor con par&aacute;metros.
     *
     * @param httpServletRequest peticiones <code>request</code> a adaptar.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 25/01/2018
     */
    public XSSRequestWrapper(HttpServletRequest httpServletRequest) {
        super(httpServletRequest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return stripXSS(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        String[] encodedValues;

        if (values == null) {
            encodedValues = null;
        } else {
            int count = values.length;
            encodedValues = new String[count];

            for (int i = 0; i < count; i++) {
                encodedValues[i] = stripXSS(values[i]);
            }
        }

        return encodedValues;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(getParameterMap().keySet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String[]> getParameterMap() {
        if (sanitizedQueryString == null) {
            sanitizedQueryString = getSanitizedString();
        }

        return sanitizedQueryString;
    }

    /**
     * Funci&oacute;n que elimina todos los caracteres potencialmente mailiciosos de los parametros de entrada.
     *
     * @return los par&aacute;metros de entrada filtrados.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 25/01/2018
     */
    private Map<String, String[]> getSanitizedString() {
        Map<String, String[]> res = new HashMap<>();
        Map<String, String[]> originalQueryString = super.getParameterMap();

        if (originalQueryString != null) {
            for (Map.Entry<String, String[]> entry : originalQueryString.entrySet()) {
                String[] rawVals = entry.getValue();
                String[] snzVals = new String[rawVals.length];

                for (int i = 0; i < rawVals.length; i++) {
                    snzVals[i] = stripXSS(rawVals[i]);
                    LOGGER.trace("Sanitized: " + rawVals[i] + " to " + snzVals[i] + " key: " + entry.getKey());
                }

                res.put(stripXSS(entry.getKey()), snzVals);
            }
        }

        return res;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return stripXSS(value);
    }

    /**
     * Funci&oacute;n que elimina todos los caracteres potencialmente mailiciosos de una cadena.
     *
     * @param value la cadena sin filtrar.
     *
     * @return la cadena filtrada.
     *
     * @author Jos&eacute; Carlos Ortega Romano
     * @since 25/01/2018
     */
    public String stripXSS(String value) {
        String cleanValue = null;
        if (value != null) {
            cleanValue = value;
            // Evita caracteres nulos
            cleanValue = cleanValue.replaceAll("\0", "");

            // Evita cualquier cosa entre las etiquetas de <script>
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita cualquier cosa en un src = '...' tipo de expresion
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Elimina cualquier etiqueta solitaria </ script>
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Elimina cualquier etiqueta solitaria <script ...>
            scriptPattern = Pattern.compile("<script(.*?)>",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones eval(...)
            scriptPattern = Pattern.compile("eval\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones expression(...)
            scriptPattern = Pattern.compile("expression\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones javascript:...
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones vbscript:...
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones onload=
            scriptPattern = Pattern.compile("onload(.*?)=",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones scriptalert
            scriptPattern = Pattern.compile("<scriptalert(.*?)>",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones script
            scriptPattern = Pattern.compile("script", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita expresiones alert
            scriptPattern = Pattern.compile("alert", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            scriptPattern = Pattern.compile("[.*]/", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Evita el caracter ';'
            scriptPattern = Pattern.compile(";", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
        }

        return cleanValue;
    }
}
