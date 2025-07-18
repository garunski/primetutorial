package org.primefaces.prime.domain;

public class Skill {
    private String elementId;
    private String skill;
    private String description;
    private String impValue;
    private String levelValue;

    // Default constructor
    public Skill() {}

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