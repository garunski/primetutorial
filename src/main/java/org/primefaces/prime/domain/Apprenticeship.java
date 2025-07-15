package org.primefaces.prime.domain;

import java.util.List;

public class Apprenticeship {
    private Integer apprenticeshipId;
    private String primaryKey;
    private String name;
    private String location;
    private List<String> onetList;
    private String addr1;
    private String city;
    private String state;
    private String zip;
    private String openDate;
    private String openDateStr;
    private String closingDate;
    private String closingDateStr;
    private String dayTime;
    private String startTimeText;
    private String endTimeText;
    private Boolean flagBrochurePdf;
    private String apprenticeshipCompleteAddress;
    private String distanceText;
    private String howToApplyText;
    private String applicantReqtText;
    private String apprenticeshipCode;
    private String companyName;
    private String contactName;
    private String phone;
    private String announcementText;
    private String furtherInfo;
    private Boolean favoriteFlag;
    private Boolean journalFlag;
    private Boolean guestFlag;
    private Boolean recentViewFlag;

    // Default constructor
    public Apprenticeship() {}

    // Getters and Setters
    public Integer getApprenticeshipId() { return apprenticeshipId; }
    public void setApprenticeshipId(Integer apprenticeshipId) { this.apprenticeshipId = apprenticeshipId; }

    public String getPrimaryKey() { return primaryKey; }
    public void setPrimaryKey(String primaryKey) { this.primaryKey = primaryKey; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<String> getOnetList() { return onetList; }
    public void setOnetList(List<String> onetList) { this.onetList = onetList; }

    public String getAddr1() { return addr1; }
    public void setAddr1(String addr1) { this.addr1 = addr1; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getOpenDate() { return openDate; }
    public void setOpenDate(String openDate) { this.openDate = openDate; }

    public String getOpenDateStr() { return openDateStr; }
    public void setOpenDateStr(String openDateStr) { this.openDateStr = openDateStr; }

    public String getClosingDate() { return closingDate; }
    public void setClosingDate(String closingDate) { this.closingDate = closingDate; }

    public String getClosingDateStr() { return closingDateStr; }
    public void setClosingDateStr(String closingDateStr) { this.closingDateStr = closingDateStr; }

    public String getDayTime() { return dayTime; }
    public void setDayTime(String dayTime) { this.dayTime = dayTime; }

    public String getStartTimeText() { return startTimeText; }
    public void setStartTimeText(String startTimeText) { this.startTimeText = startTimeText; }

    public String getEndTimeText() { return endTimeText; }
    public void setEndTimeText(String endTimeText) { this.endTimeText = endTimeText; }

    public Boolean getFlagBrochurePdf() { return flagBrochurePdf; }
    public void setFlagBrochurePdf(Boolean flagBrochurePdf) { this.flagBrochurePdf = flagBrochurePdf; }

    public String getApprenticeshipCompleteAddress() { return apprenticeshipCompleteAddress; }
    public void setApprenticeshipCompleteAddress(String apprenticeshipCompleteAddress) { this.apprenticeshipCompleteAddress = apprenticeshipCompleteAddress; }

    public String getDistanceText() { return distanceText; }
    public void setDistanceText(String distanceText) { this.distanceText = distanceText; }

    public String getHowToApplyText() { return howToApplyText; }
    public void setHowToApplyText(String howToApplyText) { this.howToApplyText = howToApplyText; }

    public String getApplicantReqtText() { return applicantReqtText; }
    public void setApplicantReqtText(String applicantReqtText) { this.applicantReqtText = applicantReqtText; }

    public String getApprenticeshipCode() { return apprenticeshipCode; }
    public void setApprenticeshipCode(String apprenticeshipCode) { this.apprenticeshipCode = apprenticeshipCode; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAnnouncementText() { return announcementText; }
    public void setAnnouncementText(String announcementText) { this.announcementText = announcementText; }

    public String getFurtherInfo() { return furtherInfo; }
    public void setFurtherInfo(String furtherInfo) { this.furtherInfo = furtherInfo; }

    public Boolean getFavoriteFlag() { return favoriteFlag; }
    public void setFavoriteFlag(Boolean favoriteFlag) { this.favoriteFlag = favoriteFlag; }

    public Boolean getJournalFlag() { return journalFlag; }
    public void setJournalFlag(Boolean journalFlag) { this.journalFlag = journalFlag; }

    public Boolean getGuestFlag() { return guestFlag; }
    public void setGuestFlag(Boolean guestFlag) { this.guestFlag = guestFlag; }

    public Boolean getRecentViewFlag() { return recentViewFlag; }
    public void setRecentViewFlag(Boolean recentViewFlag) { this.recentViewFlag = recentViewFlag; }
} 