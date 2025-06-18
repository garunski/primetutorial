package org.primefaces.prime.domain;

public class Knowledge {
    private String elementId;
    private String skill;
    private String description;
    private String impValue;
    private String levelValue;

    // Default constructor
    public Knowledge() {}

    // Constructor with parameters
    public Knowledge(String elementId, String skill, String description, String impValue, String levelValue) {
        this.elementId = elementId;
        this.skill = skill;
        this.description = description;
        this.impValue = impValue;
        this.levelValue = levelValue;
    }

    // Getters and Setters
    public String getElementId() { return elementId; }
    public void setElementId(String elementId) { this.elementId = elementId; }

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImpValue() { return impValue; }
    public void setImpValue(String impValue) { this.impValue = impValue; }

    public String getLevelValue() { return levelValue; }
    public void setLevelValue(String levelValue) { this.levelValue = levelValue; }
} 