package org.primefaces.prime.domain;

public class WorkValue {
    private String name;
    private String description;
    private String separator;
    private Boolean hasDescription;

    // Default constructor
    public WorkValue() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeparator() { return separator; }
    public void setSeparator(String separator) { this.separator = separator; }

    public Boolean getHasDescription() { return hasDescription; }
    public void setHasDescription(Boolean hasDescription) { this.hasDescription = hasDescription; }
} 