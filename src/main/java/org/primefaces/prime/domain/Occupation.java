package org.primefaces.prime.domain;

import java.util.List;
import org.primefaces.model.Job;

public class Occupation {
    private String onet;
    private Boolean detailOkFlag;
    private Boolean jobZoneFlag;
    private String formattedOnet;
    private String title;
    private String description;
    private String iconName;
    private Boolean hasDataFlag;
    private Boolean hasVideoFlag;
    private String jobZone;
    private String jobZoneName;
    private String jobZoneExperience;
    private String jobZoneEducation;
    private String jobZoneTraining;
    private String jobZoneExamples;
    private String sedClusterCode;
    private String sedClusterDesc;
    private String sedClusterLongDesc;
    private Boolean brightFlag;
    private String layTitle;
    private Boolean greenFlag;
    private Boolean moreJobsFlag;
    private List<Interest> interests;
    private Boolean hasInterestsFlag;
    private List<WorkValue> workValues;
    private Boolean hasWorkValuesFlag;
    private List<String> tasks;
    private Boolean hasTasksFlag;
    private List<Duty> duties;
    private Boolean hasDutiesFlag;
    private List<Tool> tools;
    private Boolean hasToolsFlag;
    private List<Technology> technologies;
    private Boolean hasTechnologiesFlag;
    private List<Skill> skills;
    private Boolean hasSkillsFlag;
    private List<Knowledge> knowledge;
    private Boolean hasKnowledgeFlag;
    private List<WorkContext> workContext;
    private Boolean hasWorkContextFlag;
    private List<WorkStyle> workStyles;
    private Boolean hasWorkStylesFlag;
    private List<Education> schools;
    private Boolean hasSchoolsFlag;
    private List<SchoolProgram> schoolPrograms;
    private Wages wages;
    private Boolean hasWageFlag;
    private Boolean hasLicenseFlag;
    private List<License> licenses;
    private List<Resource> resources;
    private Boolean hasResourcesFlag;
    private List<Apprenticeship> apprenticeships;
    private Boolean hasApprenticeshipFlag;
    private Boolean apprenticeableFlag;
    private List<RelatedOccupation> relatedOccs;
    private Boolean hasRelatedOccsFlag;
    private List<Job> jobs;
    private Boolean hasJobsFlag;
    private Integer jobCount;
    private Integer rowPage;
    private String relatedOccupationString;
    private String clusterLinkID;
    private List<CareerCluster> careerClusters;
    private Boolean hasClustersFlag;
    private String videoUrl;

    // Default constructor
    public Occupation() {}

    // Getters and Setters
    public String getOnet() { return onet; }
    public void setOnet(String onet) { this.onet = onet; }

    public Boolean getDetailOkFlag() { return detailOkFlag; }
    public void setDetailOkFlag(Boolean detailOkFlag) { this.detailOkFlag = detailOkFlag; }

    public Boolean getJobZoneFlag() { return jobZoneFlag; }
    public void setJobZoneFlag(Boolean jobZoneFlag) { this.jobZoneFlag = jobZoneFlag; }

    public String getFormattedOnet() { return formattedOnet; }
    public void setFormattedOnet(String formattedOnet) { this.formattedOnet = formattedOnet; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIconName() { return iconName; }
    public void setIconName(String iconName) { this.iconName = iconName; }

    public Boolean getHasDataFlag() { return hasDataFlag; }
    public void setHasDataFlag(Boolean hasDataFlag) { this.hasDataFlag = hasDataFlag; }

    public Boolean getHasVideoFlag() { return hasVideoFlag; }
    public void setHasVideoFlag(Boolean hasVideoFlag) { this.hasVideoFlag = hasVideoFlag; }

    public String getJobZone() { return jobZone; }
    public void setJobZone(String jobZone) { this.jobZone = jobZone; }

    public String getJobZoneName() { return jobZoneName; }
    public void setJobZoneName(String jobZoneName) { this.jobZoneName = jobZoneName; }

    public String getJobZoneExperience() { return jobZoneExperience; }
    public void setJobZoneExperience(String jobZoneExperience) { this.jobZoneExperience = jobZoneExperience; }

    public String getJobZoneEducation() { return jobZoneEducation; }
    public void setJobZoneEducation(String jobZoneEducation) { this.jobZoneEducation = jobZoneEducation; }

    public String getJobZoneTraining() { return jobZoneTraining; }
    public void setJobZoneTraining(String jobZoneTraining) { this.jobZoneTraining = jobZoneTraining; }

    public String getJobZoneExamples() { return jobZoneExamples; }
    public void setJobZoneExamples(String jobZoneExamples) { this.jobZoneExamples = jobZoneExamples; }

    public String getSedClusterCode() { return sedClusterCode; }
    public void setSedClusterCode(String sedClusterCode) { this.sedClusterCode = sedClusterCode; }

    public String getSedClusterDesc() { return sedClusterDesc; }
    public void setSedClusterDesc(String sedClusterDesc) { this.sedClusterDesc = sedClusterDesc; }

    public String getSedClusterLongDesc() { return sedClusterLongDesc; }
    public void setSedClusterLongDesc(String sedClusterLongDesc) { this.sedClusterLongDesc = sedClusterLongDesc; }

    public Boolean getBrightFlag() { return brightFlag; }
    public void setBrightFlag(Boolean brightFlag) { this.brightFlag = brightFlag; }

    public String getLayTitle() { return layTitle; }
    public void setLayTitle(String layTitle) { this.layTitle = layTitle; }

    public Boolean getGreenFlag() { return greenFlag; }
    public void setGreenFlag(Boolean greenFlag) { this.greenFlag = greenFlag; }

    public Boolean getMoreJobsFlag() { return moreJobsFlag; }
    public void setMoreJobsFlag(Boolean moreJobsFlag) { this.moreJobsFlag = moreJobsFlag; }

    public List<Interest> getInterests() { return interests; }
    public void setInterests(List<Interest> interests) { this.interests = interests; }

    public Boolean getHasInterestsFlag() { return hasInterestsFlag; }
    public void setHasInterestsFlag(Boolean hasInterestsFlag) { this.hasInterestsFlag = hasInterestsFlag; }

    public List<WorkValue> getWorkValues() { return workValues; }
    public void setWorkValues(List<WorkValue> workValues) { this.workValues = workValues; }

    public Boolean getHasWorkValuesFlag() { return hasWorkValuesFlag; }
    public void setHasWorkValuesFlag(Boolean hasWorkValuesFlag) { this.hasWorkValuesFlag = hasWorkValuesFlag; }

    public List<String> getTasks() { return tasks; }
    public void setTasks(List<String> tasks) { this.tasks = tasks; }

    public Boolean getHasTasksFlag() { return hasTasksFlag; }
    public void setHasTasksFlag(Boolean hasTasksFlag) { this.hasTasksFlag = hasTasksFlag; }

    public List<Duty> getDuties() { return duties; }
    public void setDuties(List<Duty> duties) { this.duties = duties; }

    public Boolean getHasDutiesFlag() { return hasDutiesFlag; }
    public void setHasDutiesFlag(Boolean hasDutiesFlag) { this.hasDutiesFlag = hasDutiesFlag; }

    public List<Tool> getTools() { return tools; }
    public void setTools(List<Tool> tools) { this.tools = tools; }

    public Boolean getHasToolsFlag() { return hasToolsFlag; }
    public void setHasToolsFlag(Boolean hasToolsFlag) { this.hasToolsFlag = hasToolsFlag; }

    public List<Technology> getTechnologies() { return technologies; }
    public void setTechnologies(List<Technology> technologies) { this.technologies = technologies; }

    public Boolean getHasTechnologiesFlag() { return hasTechnologiesFlag; }
    public void setHasTechnologiesFlag(Boolean hasTechnologiesFlag) { this.hasTechnologiesFlag = hasTechnologiesFlag; }

    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }

    public Boolean getHasSkillsFlag() { return hasSkillsFlag; }
    public void setHasSkillsFlag(Boolean hasSkillsFlag) { this.hasSkillsFlag = hasSkillsFlag; }

    public List<Knowledge> getKnowledge() { return knowledge; }
    public void setKnowledge(List<Knowledge> knowledge) { this.knowledge = knowledge; }

    public Boolean getHasKnowledgeFlag() { return hasKnowledgeFlag; }
    public void setHasKnowledgeFlag(Boolean hasKnowledgeFlag) { this.hasKnowledgeFlag = hasKnowledgeFlag; }

    public List<WorkContext> getWorkContext() { return workContext; }
    public void setWorkContext(List<WorkContext> workContext) { this.workContext = workContext; }

    public Boolean getHasWorkContextFlag() { return hasWorkContextFlag; }
    public void setHasWorkContextFlag(Boolean hasWorkContextFlag) { this.hasWorkContextFlag = hasWorkContextFlag; }

    public List<WorkStyle> getWorkStyles() { return workStyles; }
    public void setWorkStyles(List<WorkStyle> workStyles) { this.workStyles = workStyles; }

    public Boolean getHasWorkStylesFlag() { return hasWorkStylesFlag; }
    public void setHasWorkStylesFlag(Boolean hasWorkStylesFlag) { this.hasWorkStylesFlag = hasWorkStylesFlag; }

    public List<Education> getSchools() { return schools; }
    public void setSchools(List<Education> schools) { this.schools = schools; }

    public Boolean getHasSchoolsFlag() { return hasSchoolsFlag; }
    public void setHasSchoolsFlag(Boolean hasSchoolsFlag) { this.hasSchoolsFlag = hasSchoolsFlag; }

    public List<SchoolProgram> getSchoolPrograms() { return schoolPrograms; }
    public void setSchoolPrograms(List<SchoolProgram> schoolPrograms) { this.schoolPrograms = schoolPrograms; }

    public Wages getWages() { return wages; }
    public void setWages(Wages wages) { this.wages = wages; }

    public Boolean getHasWageFlag() { return hasWageFlag; }
    public void setHasWageFlag(Boolean hasWageFlag) { this.hasWageFlag = hasWageFlag; }

    public Boolean getHasLicenseFlag() { return hasLicenseFlag; }
    public void setHasLicenseFlag(Boolean hasLicenseFlag) { this.hasLicenseFlag = hasLicenseFlag; }

    public List<License> getLicenses() { return licenses; }
    public void setLicenses(List<License> licenses) { this.licenses = licenses; }

    public List<Resource> getResources() { return resources; }
    public void setResources(List<Resource> resources) { this.resources = resources; }

    public Boolean getHasResourcesFlag() { return hasResourcesFlag; }
    public void setHasResourcesFlag(Boolean hasResourcesFlag) { this.hasResourcesFlag = hasResourcesFlag; }

    public List<Apprenticeship> getApprenticeships() { return apprenticeships; }
    public void setApprenticeships(List<Apprenticeship> apprenticeships) { this.apprenticeships = apprenticeships; }

    public Boolean getHasApprenticeshipFlag() { return hasApprenticeshipFlag; }
    public void setHasApprenticeshipFlag(Boolean hasApprenticeshipFlag) { this.hasApprenticeshipFlag = hasApprenticeshipFlag; }

    public Boolean getApprenticeableFlag() { return apprenticeableFlag; }
    public void setApprenticeableFlag(Boolean apprenticeableFlag) { this.apprenticeableFlag = apprenticeableFlag; }

    public List<RelatedOccupation> getRelatedOccs() { return relatedOccs; }
    public void setRelatedOccs(List<RelatedOccupation> relatedOccs) { this.relatedOccs = relatedOccs; }

    public Boolean getHasRelatedOccsFlag() { return hasRelatedOccsFlag; }
    public void setHasRelatedOccsFlag(Boolean hasRelatedOccsFlag) { this.hasRelatedOccsFlag = hasRelatedOccsFlag; }

    public List<Job> getJobs() { return jobs; }
    public void setJobs(List<Job> jobs) { this.jobs = jobs; }

    public Boolean getHasJobsFlag() { return hasJobsFlag; }
    public void setHasJobsFlag(Boolean hasJobsFlag) { this.hasJobsFlag = hasJobsFlag; }

    public Integer getJobCount() { return jobCount; }
    public void setJobCount(Integer jobCount) { this.jobCount = jobCount; }

    public Integer getRowPage() { return rowPage; }
    public void setRowPage(Integer rowPage) { this.rowPage = rowPage; }

    public String getRelatedOccupationString() { return relatedOccupationString; }
    public void setRelatedOccupationString(String relatedOccupationString) { this.relatedOccupationString = relatedOccupationString; }

    public String getClusterLinkID() { return clusterLinkID; }
    public void setClusterLinkID(String clusterLinkID) { this.clusterLinkID = clusterLinkID; }

    public List<CareerCluster> getCareerClusters() { return careerClusters; }
    public void setCareerClusters(List<CareerCluster> careerClusters) { this.careerClusters = careerClusters; }

    public Boolean getHasClustersFlag() { return hasClustersFlag; }
    public void setHasClustersFlag(Boolean hasClustersFlag) { this.hasClustersFlag = hasClustersFlag; }

    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
} 