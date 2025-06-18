package org.primefaces.prime.domain;

public class RelatedOccupation {
    private String onet;
    private String occTitle;
    private String occDescription;

    // Default constructor
    public RelatedOccupation() {}

    // Getters and Setters
    public String getOnet() { return onet; }
    public void setOnet(String onet) { this.onet = onet; }

    public String getOccTitle() { return occTitle; }
    public void setOccTitle(String occTitle) { this.occTitle = occTitle; }

    public String getOccDescription() { return occDescription; }
    public void setOccDescription(String occDescription) { this.occDescription = occDescription; }
} 