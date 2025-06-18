package org.primefaces.prime.domain;

public class WorkContext {
    private String name;
    private String description;
    private String separator;
    private String value;
    private Boolean hasDescription;

    // Default constructor
    public WorkContext() {}

    // Constructor with parameters
    public WorkContext(String name, String description, String separator, String value, Boolean hasDescription) {
        this.name = name;
        this.description = description;
        this.separator = separator;
        this.value = value;
        this.hasDescription = hasDescription;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeparator() { return separator; }
    public void setSeparator(String separator) { this.separator = separator; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public Boolean getHasDescription() { return hasDescription; }
    public void setHasDescription(Boolean hasDescription) { this.hasDescription = hasDescription; }
} 