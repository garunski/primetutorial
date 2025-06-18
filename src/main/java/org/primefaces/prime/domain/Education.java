package org.primefaces.prime.domain;

public class Education {
    private String cip;
    private String name;
    private String description;

    // Default constructor
    public Education() {}

    // Getters and Setters
    public String getCip() { return cip; }
    public void setCip(String cip) { this.cip = cip; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
} 