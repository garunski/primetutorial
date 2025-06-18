package org.primefaces.prime.domain;

public class CareerPathway {
    private String description;
    private String separator;
    private String value;
    private Boolean hasDescription;

    // Default constructor
    public CareerPathway() {}

    // Getters and Setters
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeparator() { return separator; }
    public void setSeparator(String separator) { this.separator = separator; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public Boolean getHasDescription() { return hasDescription; }
    public void setHasDescription(Boolean hasDescription) { this.hasDescription = hasDescription; }
} 