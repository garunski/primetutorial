package org.primefaces.prime.domain;

public class License {
    private String name;
    private String url;
    private String description;

    // Default constructor
    public License() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
} 