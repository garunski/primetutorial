package org.primefaces.prime.domain;

import java.util.List;

public class CareerCluster {
    private String clusterID;
    private String clusterName;
    private List<CareerPathway> careerPathwayList;
    private Boolean hasPathwayFlag;

    // Default constructor
    public CareerCluster() {}

    // Getters and Setters
    public String getClusterID() { return clusterID; }
    public void setClusterID(String clusterID) { this.clusterID = clusterID; }

    public String getClusterName() { return clusterName; }
    public void setClusterName(String clusterName) { this.clusterName = clusterName; }

    public List<CareerPathway> getCareerPathwayList() { return careerPathwayList; }
    public void setCareerPathwayList(List<CareerPathway> careerPathwayList) { this.careerPathwayList = careerPathwayList; }

    public Boolean getHasPathwayFlag() { return hasPathwayFlag; }
    public void setHasPathwayFlag(Boolean hasPathwayFlag) { this.hasPathwayFlag = hasPathwayFlag; }
} 