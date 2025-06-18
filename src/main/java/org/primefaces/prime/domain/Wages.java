package org.primefaces.prime.domain;

public class Wages {
    private String onet;
    private String state;
    private Integer regionID;
    private String regionName;
    private Boolean onetLevelOverrideFlag;
    private Double resultScore;
    private Integer socToOnetCount;
    private Boolean socLevelOverrideFlag;
    private Integer commonEmplBaseYear;
    private Integer commonEmplProjYear;
    private Boolean commonWageAnnualFlag;
    private Boolean commonWageHourlyFlag;
    private Integer commonWageYear;
    private Boolean nationalHasDataFlag;
    private Boolean stateHasDataFlag;
    private Boolean regionHasDataFlag;
    
    // Employment projections
    private Integer nationalAnnualOpeningsGrowthAmount;
    private Integer regionAnnualOpeningsGrowthAmount;
    private Integer stateAnnualOpeningsGrowthAmount;
    private Integer nationalAnnualOpeningsReplaceAmount;
    private Integer regionAnnualOpeningsReplaceAmount;
    private Integer stateAnnualOpeningsReplaceAmount;
    private Double nationalAnnualOpeningsReplacePercent;
    private Double regionAnnualOpeningsReplacePercent;
    private Double stateAnnualOpeningsReplacePercent;
    private Integer nationalAnnualOpeningsTotalAmount;
    private Integer regionAnnualOpeningsTotalAmount;
    private Integer stateAnnualOpeningsTotalAmount;
    
    // Education percentages
    private Double nationalEduPctBachelors;
    private Double nationalEduPctDoctoralProf;
    private Double nationalEduPctHighSchool;
    private Double nationalEduPctLessThanHs;
    private Double nationalEduPctMasters;
    private Double nationalEduPctSomeCollege;
    
    // Employment data
    private Integer nationalEmplBaseAmount;
    private Integer regionEmplBaseAmount;
    private Integer stateEmplBaseAmount;
    private Integer nationalEmplChangeAmount;
    private Integer regionEmplChangeAmount;
    private Integer stateEmplChangeAmount;
    private Double nationalEmplChangePercent;
    private Double regionEmplChangePercent;
    private Double stateEmplChangePercent;
    private Integer nationalEmplProjAmount;
    private Integer regionEmplProjAmount;
    private Integer stateEmplProjAmount;
    
    // Experience and training requirements
    private String nationalEteRequiredEducation;
    private String nationalEteRequiredExperience;
    private String nationalEteRequiredTraining;
    private String stateEteUsualEduAttained;
    private Integer regionOnetEmpProspectCode;
    private Integer stateOnetEmpProspectCode;
    private String regionOnetEmpProspectDesc;
    private String stateOnetEmpProspectDesc;
    
    // Wage data
    private Integer nationalWageAnnualMeanAmount;
    private Integer regionWageAnnualMeanAmount;
    private Integer stateWageAnnualMeanAmount;
    private Integer nationalWageAnnualPct25EntryAmount;
    private Integer regionWageAnnualPct25EntryAmount;
    private Integer stateWageAnnualPct25EntryAmount;
    private Integer nationalWageAnnualPct50MedianAmount;
    private Integer regionWageAnnualPct50MedianAmount;
    private Integer stateWageAnnualPct50MedianAmount;
    private Integer nationalWageAnnualPct75ExperAmount;
    private Integer regionWageAnnualPct75ExperAmount;
    private Integer stateWageAnnualPct75ExperAmount;

    // Default constructor
    public Wages() {}

    // Getters and Setters
    public String getOnet() { return onet; }
    public void setOnet(String onet) { this.onet = onet; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public Integer getRegionID() { return regionID; }
    public void setRegionID(Integer regionID) { this.regionID = regionID; }

    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }

    public Boolean getOnetLevelOverrideFlag() { return onetLevelOverrideFlag; }
    public void setOnetLevelOverrideFlag(Boolean onetLevelOverrideFlag) { this.onetLevelOverrideFlag = onetLevelOverrideFlag; }

    public Double getResultScore() { return resultScore; }
    public void setResultScore(Double resultScore) { this.resultScore = resultScore; }

    public Integer getSocToOnetCount() { return socToOnetCount; }
    public void setSocToOnetCount(Integer socToOnetCount) { this.socToOnetCount = socToOnetCount; }

    public Boolean getSocLevelOverrideFlag() { return socLevelOverrideFlag; }
    public void setSocLevelOverrideFlag(Boolean socLevelOverrideFlag) { this.socLevelOverrideFlag = socLevelOverrideFlag; }

    public Integer getCommonEmplBaseYear() { return commonEmplBaseYear; }
    public void setCommonEmplBaseYear(Integer commonEmplBaseYear) { this.commonEmplBaseYear = commonEmplBaseYear; }

    public Integer getCommonEmplProjYear() { return commonEmplProjYear; }
    public void setCommonEmplProjYear(Integer commonEmplProjYear) { this.commonEmplProjYear = commonEmplProjYear; }

    public Boolean getCommonWageAnnualFlag() { return commonWageAnnualFlag; }
    public void setCommonWageAnnualFlag(Boolean commonWageAnnualFlag) { this.commonWageAnnualFlag = commonWageAnnualFlag; }

    public Boolean getCommonWageHourlyFlag() { return commonWageHourlyFlag; }
    public void setCommonWageHourlyFlag(Boolean commonWageHourlyFlag) { this.commonWageHourlyFlag = commonWageHourlyFlag; }

    public Integer getCommonWageYear() { return commonWageYear; }
    public void setCommonWageYear(Integer commonWageYear) { this.commonWageYear = commonWageYear; }

    public Boolean getNationalHasDataFlag() { return nationalHasDataFlag; }
    public void setNationalHasDataFlag(Boolean nationalHasDataFlag) { this.nationalHasDataFlag = nationalHasDataFlag; }

    public Boolean getStateHasDataFlag() { return stateHasDataFlag; }
    public void setStateHasDataFlag(Boolean stateHasDataFlag) { this.stateHasDataFlag = stateHasDataFlag; }

    public Boolean getRegionHasDataFlag() { return regionHasDataFlag; }
    public void setRegionHasDataFlag(Boolean regionHasDataFlag) { this.regionHasDataFlag = regionHasDataFlag; }

    public Integer getNationalAnnualOpeningsGrowthAmount() { return nationalAnnualOpeningsGrowthAmount; }
    public void setNationalAnnualOpeningsGrowthAmount(Integer nationalAnnualOpeningsGrowthAmount) { this.nationalAnnualOpeningsGrowthAmount = nationalAnnualOpeningsGrowthAmount; }

    public Integer getRegionAnnualOpeningsGrowthAmount() { return regionAnnualOpeningsGrowthAmount; }
    public void setRegionAnnualOpeningsGrowthAmount(Integer regionAnnualOpeningsGrowthAmount) { this.regionAnnualOpeningsGrowthAmount = regionAnnualOpeningsGrowthAmount; }

    public Integer getStateAnnualOpeningsGrowthAmount() { return stateAnnualOpeningsGrowthAmount; }
    public void setStateAnnualOpeningsGrowthAmount(Integer stateAnnualOpeningsGrowthAmount) { this.stateAnnualOpeningsGrowthAmount = stateAnnualOpeningsGrowthAmount; }

    public Integer getNationalAnnualOpeningsReplaceAmount() { return nationalAnnualOpeningsReplaceAmount; }
    public void setNationalAnnualOpeningsReplaceAmount(Integer nationalAnnualOpeningsReplaceAmount) { this.nationalAnnualOpeningsReplaceAmount = nationalAnnualOpeningsReplaceAmount; }

    public Integer getRegionAnnualOpeningsReplaceAmount() { return regionAnnualOpeningsReplaceAmount; }
    public void setRegionAnnualOpeningsReplaceAmount(Integer regionAnnualOpeningsReplaceAmount) { this.regionAnnualOpeningsReplaceAmount = regionAnnualOpeningsReplaceAmount; }

    public Integer getStateAnnualOpeningsReplaceAmount() { return stateAnnualOpeningsReplaceAmount; }
    public void setStateAnnualOpeningsReplaceAmount(Integer stateAnnualOpeningsReplaceAmount) { this.stateAnnualOpeningsReplaceAmount = stateAnnualOpeningsReplaceAmount; }

    public Double getNationalAnnualOpeningsReplacePercent() { return nationalAnnualOpeningsReplacePercent; }
    public void setNationalAnnualOpeningsReplacePercent(Double nationalAnnualOpeningsReplacePercent) { this.nationalAnnualOpeningsReplacePercent = nationalAnnualOpeningsReplacePercent; }

    public Double getRegionAnnualOpeningsReplacePercent() { return regionAnnualOpeningsReplacePercent; }
    public void setRegionAnnualOpeningsReplacePercent(Double regionAnnualOpeningsReplacePercent) { this.regionAnnualOpeningsReplacePercent = regionAnnualOpeningsReplacePercent; }

    public Double getStateAnnualOpeningsReplacePercent() { return stateAnnualOpeningsReplacePercent; }
    public void setStateAnnualOpeningsReplacePercent(Double stateAnnualOpeningsReplacePercent) { this.stateAnnualOpeningsReplacePercent = stateAnnualOpeningsReplacePercent; }

    public Integer getNationalAnnualOpeningsTotalAmount() { return nationalAnnualOpeningsTotalAmount; }
    public void setNationalAnnualOpeningsTotalAmount(Integer nationalAnnualOpeningsTotalAmount) { this.nationalAnnualOpeningsTotalAmount = nationalAnnualOpeningsTotalAmount; }

    public Integer getRegionAnnualOpeningsTotalAmount() { return regionAnnualOpeningsTotalAmount; }
    public void setRegionAnnualOpeningsTotalAmount(Integer regionAnnualOpeningsTotalAmount) { this.regionAnnualOpeningsTotalAmount = regionAnnualOpeningsTotalAmount; }

    public Integer getStateAnnualOpeningsTotalAmount() { return stateAnnualOpeningsTotalAmount; }
    public void setStateAnnualOpeningsTotalAmount(Integer stateAnnualOpeningsTotalAmount) { this.stateAnnualOpeningsTotalAmount = stateAnnualOpeningsTotalAmount; }

    public Double getNationalEduPctBachelors() { return nationalEduPctBachelors; }
    public void setNationalEduPctBachelors(Double nationalEduPctBachelors) { this.nationalEduPctBachelors = nationalEduPctBachelors; }

    public Double getNationalEduPctDoctoralProf() { return nationalEduPctDoctoralProf; }
    public void setNationalEduPctDoctoralProf(Double nationalEduPctDoctoralProf) { this.nationalEduPctDoctoralProf = nationalEduPctDoctoralProf; }

    public Double getNationalEduPctHighSchool() { return nationalEduPctHighSchool; }
    public void setNationalEduPctHighSchool(Double nationalEduPctHighSchool) { this.nationalEduPctHighSchool = nationalEduPctHighSchool; }

    public Double getNationalEduPctLessThanHs() { return nationalEduPctLessThanHs; }
    public void setNationalEduPctLessThanHs(Double nationalEduPctLessThanHs) { this.nationalEduPctLessThanHs = nationalEduPctLessThanHs; }

    public Double getNationalEduPctMasters() { return nationalEduPctMasters; }
    public void setNationalEduPctMasters(Double nationalEduPctMasters) { this.nationalEduPctMasters = nationalEduPctMasters; }

    public Double getNationalEduPctSomeCollege() { return nationalEduPctSomeCollege; }
    public void setNationalEduPctSomeCollege(Double nationalEduPctSomeCollege) { this.nationalEduPctSomeCollege = nationalEduPctSomeCollege; }

    public Integer getNationalEmplBaseAmount() { return nationalEmplBaseAmount; }
    public void setNationalEmplBaseAmount(Integer nationalEmplBaseAmount) { this.nationalEmplBaseAmount = nationalEmplBaseAmount; }

    public Integer getRegionEmplBaseAmount() { return regionEmplBaseAmount; }
    public void setRegionEmplBaseAmount(Integer regionEmplBaseAmount) { this.regionEmplBaseAmount = regionEmplBaseAmount; }

    public Integer getStateEmplBaseAmount() { return stateEmplBaseAmount; }
    public void setStateEmplBaseAmount(Integer stateEmplBaseAmount) { this.stateEmplBaseAmount = stateEmplBaseAmount; }

    public Integer getNationalEmplChangeAmount() { return nationalEmplChangeAmount; }
    public void setNationalEmplChangeAmount(Integer nationalEmplChangeAmount) { this.nationalEmplChangeAmount = nationalEmplChangeAmount; }

    public Integer getRegionEmplChangeAmount() { return regionEmplChangeAmount; }
    public void setRegionEmplChangeAmount(Integer regionEmplChangeAmount) { this.regionEmplChangeAmount = regionEmplChangeAmount; }

    public Integer getStateEmplChangeAmount() { return stateEmplChangeAmount; }
    public void setStateEmplChangeAmount(Integer stateEmplChangeAmount) { this.stateEmplChangeAmount = stateEmplChangeAmount; }

    public Double getNationalEmplChangePercent() { return nationalEmplChangePercent; }
    public void setNationalEmplChangePercent(Double nationalEmplChangePercent) { this.nationalEmplChangePercent = nationalEmplChangePercent; }

    public Double getRegionEmplChangePercent() { return regionEmplChangePercent; }
    public void setRegionEmplChangePercent(Double regionEmplChangePercent) { this.regionEmplChangePercent = regionEmplChangePercent; }

    public Double getStateEmplChangePercent() { return stateEmplChangePercent; }
    public void setStateEmplChangePercent(Double stateEmplChangePercent) { this.stateEmplChangePercent = stateEmplChangePercent; }

    public Integer getNationalEmplProjAmount() { return nationalEmplProjAmount; }
    public void setNationalEmplProjAmount(Integer nationalEmplProjAmount) { this.nationalEmplProjAmount = nationalEmplProjAmount; }

    public Integer getRegionEmplProjAmount() { return regionEmplProjAmount; }
    public void setRegionEmplProjAmount(Integer regionEmplProjAmount) { this.regionEmplProjAmount = regionEmplProjAmount; }

    public Integer getStateEmplProjAmount() { return stateEmplProjAmount; }
    public void setStateEmplProjAmount(Integer stateEmplProjAmount) { this.stateEmplProjAmount = stateEmplProjAmount; }

    public String getNationalEteRequiredEducation() { return nationalEteRequiredEducation; }
    public void setNationalEteRequiredEducation(String nationalEteRequiredEducation) { this.nationalEteRequiredEducation = nationalEteRequiredEducation; }

    public String getNationalEteRequiredExperience() { return nationalEteRequiredExperience; }
    public void setNationalEteRequiredExperience(String nationalEteRequiredExperience) { this.nationalEteRequiredExperience = nationalEteRequiredExperience; }

    public String getNationalEteRequiredTraining() { return nationalEteRequiredTraining; }
    public void setNationalEteRequiredTraining(String nationalEteRequiredTraining) { this.nationalEteRequiredTraining = nationalEteRequiredTraining; }

    public String getStateEteUsualEduAttained() { return stateEteUsualEduAttained; }
    public void setStateEteUsualEduAttained(String stateEteUsualEduAttained) { this.stateEteUsualEduAttained = stateEteUsualEduAttained; }

    public Integer getRegionOnetEmpProspectCode() { return regionOnetEmpProspectCode; }
    public void setRegionOnetEmpProspectCode(Integer regionOnetEmpProspectCode) { this.regionOnetEmpProspectCode = regionOnetEmpProspectCode; }

    public Integer getStateOnetEmpProspectCode() { return stateOnetEmpProspectCode; }
    public void setStateOnetEmpProspectCode(Integer stateOnetEmpProspectCode) { this.stateOnetEmpProspectCode = stateOnetEmpProspectCode; }

    public String getRegionOnetEmpProspectDesc() { return regionOnetEmpProspectDesc; }
    public void setRegionOnetEmpProspectDesc(String regionOnetEmpProspectDesc) { this.regionOnetEmpProspectDesc = regionOnetEmpProspectDesc; }

    public String getStateOnetEmpProspectDesc() { return stateOnetEmpProspectDesc; }
    public void setStateOnetEmpProspectDesc(String stateOnetEmpProspectDesc) { this.stateOnetEmpProspectDesc = stateOnetEmpProspectDesc; }

    public Integer getNationalWageAnnualMeanAmount() { return nationalWageAnnualMeanAmount; }
    public void setNationalWageAnnualMeanAmount(Integer nationalWageAnnualMeanAmount) { this.nationalWageAnnualMeanAmount = nationalWageAnnualMeanAmount; }

    public Integer getRegionWageAnnualMeanAmount() { return regionWageAnnualMeanAmount; }
    public void setRegionWageAnnualMeanAmount(Integer regionWageAnnualMeanAmount) { this.regionWageAnnualMeanAmount = regionWageAnnualMeanAmount; }

    public Integer getStateWageAnnualMeanAmount() { return stateWageAnnualMeanAmount; }
    public void setStateWageAnnualMeanAmount(Integer stateWageAnnualMeanAmount) { this.stateWageAnnualMeanAmount = stateWageAnnualMeanAmount; }

    public Integer getNationalWageAnnualPct25EntryAmount() { return nationalWageAnnualPct25EntryAmount; }
    public void setNationalWageAnnualPct25EntryAmount(Integer nationalWageAnnualPct25EntryAmount) { this.nationalWageAnnualPct25EntryAmount = nationalWageAnnualPct25EntryAmount; }

    public Integer getRegionWageAnnualPct25EntryAmount() { return regionWageAnnualPct25EntryAmount; }
    public void setRegionWageAnnualPct25EntryAmount(Integer regionWageAnnualPct25EntryAmount) { this.regionWageAnnualPct25EntryAmount = regionWageAnnualPct25EntryAmount; }

    public Integer getStateWageAnnualPct25EntryAmount() { return stateWageAnnualPct25EntryAmount; }
    public void setStateWageAnnualPct25EntryAmount(Integer stateWageAnnualPct25EntryAmount) { this.stateWageAnnualPct25EntryAmount = stateWageAnnualPct25EntryAmount; }

    public Integer getNationalWageAnnualPct50MedianAmount() { return nationalWageAnnualPct50MedianAmount; }
    public void setNationalWageAnnualPct50MedianAmount(Integer nationalWageAnnualPct50MedianAmount) { this.nationalWageAnnualPct50MedianAmount = nationalWageAnnualPct50MedianAmount; }

    public Integer getRegionWageAnnualPct50MedianAmount() { return regionWageAnnualPct50MedianAmount; }
    public void setRegionWageAnnualPct50MedianAmount(Integer regionWageAnnualPct50MedianAmount) { this.regionWageAnnualPct50MedianAmount = regionWageAnnualPct50MedianAmount; }

    public Integer getStateWageAnnualPct50MedianAmount() { return stateWageAnnualPct50MedianAmount; }
    public void setStateWageAnnualPct50MedianAmount(Integer stateWageAnnualPct50MedianAmount) { this.stateWageAnnualPct50MedianAmount = stateWageAnnualPct50MedianAmount; }

    public Integer getNationalWageAnnualPct75ExperAmount() { return nationalWageAnnualPct75ExperAmount; }
    public void setNationalWageAnnualPct75ExperAmount(Integer nationalWageAnnualPct75ExperAmount) { this.nationalWageAnnualPct75ExperAmount = nationalWageAnnualPct75ExperAmount; }

    public Integer getRegionWageAnnualPct75ExperAmount() { return regionWageAnnualPct75ExperAmount; }
    public void setRegionWageAnnualPct75ExperAmount(Integer regionWageAnnualPct75ExperAmount) { this.regionWageAnnualPct75ExperAmount = regionWageAnnualPct75ExperAmount; }

    public Integer getStateWageAnnualPct75ExperAmount() { return stateWageAnnualPct75ExperAmount; }
    public void setStateWageAnnualPct75ExperAmount(Integer stateWageAnnualPct75ExperAmount) { this.stateWageAnnualPct75ExperAmount = stateWageAnnualPct75ExperAmount; }

    // Convenience method for template access
    public String getMedian() {
        if (nationalWageAnnualPct50MedianAmount != null) {
            return String.format("$%,d", nationalWageAnnualPct50MedianAmount);
        }
        return "N/A";
    }
} 