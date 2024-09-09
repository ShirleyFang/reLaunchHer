package com.relaunchher.spring_boot_with_react.dao.model;

import java.util.List;
import java.util.Objects;

public class JobListing {

    private String companyName;
    private String jobTitle;
    private String jobLevel;
    private String jobRequirements;
    private Boolean isRemote;
    private Boolean providesDayCare;
    private String link;

    public JobListing(String companyName, String jobTitle, String jobLevel, String jobRequirements, Boolean isRemote, Boolean providesDayCare, String link) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.jobLevel = jobLevel;
        this.jobRequirements = jobRequirements;
        this.isRemote = isRemote;
        this.providesDayCare = providesDayCare;
        this.link = link;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobLevel() {
        return jobLevel;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public Boolean getRemote() {
        return isRemote;
    }

    public Boolean getProvidesDayCare() {
        return providesDayCare;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobListing that = (JobListing) o;
        return Objects.equals(companyName, that.companyName) && Objects.equals(jobTitle, that.jobTitle) && jobLevel == that.jobLevel && Objects.equals(jobRequirements, that.jobRequirements) && Objects.equals(isRemote, that.isRemote) && Objects.equals(providesDayCare, that.providesDayCare) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, jobTitle, jobLevel, jobRequirements, isRemote, providesDayCare, link);
    }

    @Override
    public String toString() {

        String isRemoteString = isRemote ? "Yes" : "False";
        String providesDayCareString = providesDayCare ? "Yes" : "False";

        return "JobListing{" +
                "companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobLevel=" + jobLevel +
                ", jobRequirements=" + jobRequirements +
                ", isRemote=" + isRemoteString +
                ", providesDayCare=" + providesDayCareString +
                ", link='" + link + '\'' +
                '}';
    }
}
