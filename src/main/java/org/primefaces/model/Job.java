package org.primefaces.model;

import java.io.Serializable;
import java.util.List;

/**
 * Model class representing a job/occupation.
 */
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String category;
    private String cluster;
    private String pathway;
    private String description;
    private String salaryRange;
    private String educationRequired;
    private List<String> skills;
    private String videoId;
    private boolean favorite;

    public Job() {
    }

    public Job(String id, String title, String category, String cluster, String pathway,
               String description, String salaryRange, String educationRequired, List<String> skills) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cluster = cluster;
        this.pathway = pathway;
        this.description = description;
        this.salaryRange = salaryRange;
        this.educationRequired = educationRequired;
        this.skills = skills;
        this.videoId = null; // Default to null
        this.favorite = false; // Default to false
    }

    public Job(String id, String title, String category, String cluster, String pathway,
               String description, String salaryRange, String educationRequired, List<String> skills,
               String videoId) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cluster = cluster;
        this.pathway = pathway;
        this.description = description;
        this.salaryRange = salaryRange;
        this.educationRequired = educationRequired;
        this.skills = skills;
        this.videoId = videoId;
        this.favorite = false; // Default to false
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getPathway() {
        return pathway;
    }

    public void setPathway(String pathway) {
        this.pathway = pathway;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getEducationRequired() {
        return educationRequired;
    }

    public void setEducationRequired(String educationRequired) {
        this.educationRequired = educationRequired;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
