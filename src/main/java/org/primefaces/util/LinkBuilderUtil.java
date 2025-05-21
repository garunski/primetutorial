package org.primefaces.util;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for building links with preserved URL parameters.
 */
public class LinkBuilderUtil implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Builds a URL with the specified parameters, preserving existing parameters from the current request.
     * 
     * @param outcome The JSF outcome (page name)
     * @param params The parameters to set or update
     * @return The URL with all parameters
     */
    public static String buildUrl(String outcome, Map<String, String> params) {
        // Get current request parameters
        Map<String, String> currentParams = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        
        // Create a new map with all current parameters
        Map<String, String> allParams = new HashMap<>();
        for (Map.Entry<String, String> entry : currentParams.entrySet()) {
            allParams.put(entry.getKey(), entry.getValue());
        }
        
        // Update with new parameters
        if (params != null) {
            allParams.putAll(params);
        }
        
        // Build the URL
        StringBuilder url = new StringBuilder(outcome);
        boolean first = true;
        
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                if (first) {
                    url.append("?");
                    first = false;
                } else {
                    url.append("&");
                }
                url.append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        
        return url.toString();
    }
    
    /**
     * Builds a URL for a career cluster, preserving other filter parameters.
     * 
     * @param outcome The JSF outcome (page name)
     * @param cluster The cluster value
     * @return The URL with the cluster parameter and preserved filter parameters
     */
    public static String buildClusterUrl(String outcome, String cluster) {
        Map<String, String> params = new HashMap<>();
        params.put("cluster", cluster);
        params.put("pathway", null); // Clear pathway when selecting a cluster
        
        return buildUrl(outcome, params);
    }
    
    /**
     * Builds a URL for a career pathway, preserving other filter parameters.
     * 
     * @param outcome The JSF outcome (page name)
     * @param cluster The cluster value
     * @param pathway The pathway value
     * @return The URL with the cluster and pathway parameters and preserved filter parameters
     */
    public static String buildPathwayUrl(String outcome, String cluster, String pathway) {
        Map<String, String> params = new HashMap<>();
        params.put("cluster", cluster);
        params.put("pathway", pathway);
        
        return buildUrl(outcome, params);
    }
}
