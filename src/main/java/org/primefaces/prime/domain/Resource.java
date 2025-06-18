package org.primefaces.prime.domain;

public class Resource {
    private String name;
    private String description;
    private String separator;
    private String url;
    private Boolean hasDescription;

    // Default constructor
    public Resource() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeparator() { return separator; }
    public void setSeparator(String separator) { this.separator = separator; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Boolean getHasDescription() { return hasDescription; }
    public void setHasDescription(Boolean hasDescription) { this.hasDescription = hasDescription; }
} 