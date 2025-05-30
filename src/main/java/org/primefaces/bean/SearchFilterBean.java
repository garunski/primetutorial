package org.primefaces.bean;

import org.primefaces.util.LinkBuilderUtil;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Backing bean for search filters that handles URL parameters.
 */
@Named
@RequestScoped
public class SearchFilterBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // Career path filters
    private String cluster;
    private String pathway;

    // Education filters
    private String educationLevel;
    private boolean artsHumanities;
    private boolean businessInfoSystems;
    private boolean engineeringTech;
    private boolean healthServices;

    // STEM discipline filters
    private boolean architectureEngineering;
    private boolean computerMathematical;
    private boolean healthcarePractitioners;
    private boolean lifeSocialScience;

    // Other filters
    private String salary;

    /**
     * Default constructor
     */
    public SearchFilterBean() {
        // Initialize with default values
    }

    /**
     * Initializes the bean with URL parameters
     */
    @javax.annotation.PostConstruct
    public void init() {
        // Initialize from URL parameters if present
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();

        // Career path filters
        this.cluster = params.get("cluster");
        this.pathway = params.get("pathway");

        // Education level
        String eduParam = params.get("education");
        if (eduParam != null && !eduParam.isEmpty()) {
            this.educationLevel = eduParam;
        }

        // Education clusters
        artsHumanities = "true".equals(params.get("artsHumanities"));
        businessInfoSystems = "true".equals(params.get("businessInfoSystems"));
        engineeringTech = "true".equals(params.get("engineeringTech"));
        healthServices = "true".equals(params.get("healthServices"));

        // STEM disciplines
        architectureEngineering = "true".equals(params.get("architectureEngineering"));
        computerMathematical = "true".equals(params.get("computerMathematical"));
        healthcarePractitioners = "true".equals(params.get("healthcarePractitioners"));
        lifeSocialScience = "true".equals(params.get("lifeSocialScience"));

        // Other filters
        this.salary = params.get("salary");
    }

    /**
     * Gets the base URL for the application
     * @return The base URL
     */
    public String getBaseUrl() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }

    /**
     * Splits a category string by the pipe character and returns the parts as a list
     * @param category The category string (e.g., "Agriculture | Food Science")
     * @return List of category parts
     */
    public java.util.List<String> getCategoryParts(String category) {
        if (category == null || category.trim().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        
        String[] parts = category.split("\\|");
        java.util.List<String> result = new java.util.ArrayList<>();
        
        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                result.add(trimmed);
            }
        }
        
        return result;
    }

    /**
     * Builds a URL for a category filter, preserving other filter parameters.
     * @param category The category value to filter by
     * @return The URL with the category parameter and preserved filter parameters
     */
    public String getCategoryUrl(String category) {
        return LinkBuilderUtil.buildCategoryUrl("occupationSearchRevised.jsf", category);
    }

    // Getters and setters for all properties

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public boolean isArtsHumanities() {
        return artsHumanities;
    }

    public void setArtsHumanities(boolean artsHumanities) {
        this.artsHumanities = artsHumanities;
    }

    public boolean isBusinessInfoSystems() {
        return businessInfoSystems;
    }

    public void setBusinessInfoSystems(boolean businessInfoSystems) {
        this.businessInfoSystems = businessInfoSystems;
    }

    public boolean isEngineeringTech() {
        return engineeringTech;
    }

    public void setEngineeringTech(boolean engineeringTech) {
        this.engineeringTech = engineeringTech;
    }

    public boolean isHealthServices() {
        return healthServices;
    }

    public void setHealthServices(boolean healthServices) {
        this.healthServices = healthServices;
    }

    public boolean isArchitectureEngineering() {
        return architectureEngineering;
    }

    public void setArchitectureEngineering(boolean architectureEngineering) {
        this.architectureEngineering = architectureEngineering;
    }

    public boolean isComputerMathematical() {
        return computerMathematical;
    }

    public void setComputerMathematical(boolean computerMathematical) {
        this.computerMathematical = computerMathematical;
    }

    public boolean isHealthcarePractitioners() {
        return healthcarePractitioners;
    }

    public void setHealthcarePractitioners(boolean healthcarePractitioners) {
        this.healthcarePractitioners = healthcarePractitioners;
    }

    public boolean isLifeSocialScience() {
        return lifeSocialScience;
    }

    public void setLifeSocialScience(boolean lifeSocialScience) {
        this.lifeSocialScience = lifeSocialScience;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getPathway() {
        return pathway;
    }

    public void setPathway(String pathway) {
        this.pathway = pathway;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Builds a URL for a career cluster, preserving other filter parameters.
     *
     * @param outcome The JSF outcome (page name)
     * @param clusterValue The cluster value
     * @return The URL with the cluster parameter and preserved filter parameters
     */
    public String getClusterUrl(String outcome, String clusterValue) {
        return LinkBuilderUtil.buildClusterUrl(outcome, clusterValue);
    }

    /**
     * Builds a URL for a career pathway, preserving other filter parameters.
     *
     * @param outcome The JSF outcome (page name)
     * @param clusterValue The cluster value
     * @param pathwayValue The pathway value
     * @return The URL with the cluster and pathway parameters and preserved filter parameters
     */
    public String getPathwayUrl(String outcome, String clusterValue, String pathwayValue) {
        return LinkBuilderUtil.buildPathwayUrl(outcome, clusterValue, pathwayValue);
    }

    /**
     * Builds a URL for pagination, preserving all current filter parameters.
     *
     * @param outcome The JSF outcome (page name)
     * @param page The page number
     * @return The URL with the page parameter and preserved filter parameters
     */
    public String getPaginationUrl(String outcome, int page) {
        return LinkBuilderUtil.buildPaginationUrl(outcome, page);
    }
}
