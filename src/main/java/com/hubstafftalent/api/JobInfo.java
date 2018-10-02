package com.hubstafftalent.api;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class JobInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;

	private String jobName;

	private String jobDesc;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id")
	private Company company;

	private String jobTime; // Can be Enum

	private String[] keywords;

	private Long jobPayScale;

	private Integer jobExperience;

	private String[] jobLanguages;
	@Temporal(TemporalType.DATE)
	private Date jobCreateDate;

	private String jobCreatedBy;
	@Temporal(TemporalType.DATE)
	private Date jobUpdatedDate;

	private String jobUpdatedBy;

	public Long getJobId() {
		return jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public Company getCompany() {
		return company;
	}

	public String getJobTime() {
		return jobTime;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public Long getJobPayScale() {
		return jobPayScale;
	}

	public Integer getJobExperience() {
		return jobExperience;
	}

	public String[] getJobLanguages() {
		return jobLanguages;
	}

	public Date getJobCreateDate() {
		return jobCreateDate;
	}

	public String getJobCreatedBy() {
		return jobCreatedBy;
	}

	public Date getJobUpdatedDate() {
		return jobUpdatedDate;
	}

	public String getJobUpdatedBy() {
		return jobUpdatedBy;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public void setJobPayScale(Long jobPayScale) {
		this.jobPayScale = jobPayScale;
	}

	public void setJobExperience(Integer jobExperience) {
		this.jobExperience = jobExperience;
	}

	public void setJobLanguages(String[] jobLanguages) {
		this.jobLanguages = jobLanguages;
	}

	public void setJobCreateDate(Date jobCreateDate) {
		this.jobCreateDate = jobCreateDate;
	}

	public void setJobCreatedBy(String jobCreatedBy) {
		this.jobCreatedBy = jobCreatedBy;
	}

	public void setJobUpdatedDate(Date jobUpdatedDate) {
		this.jobUpdatedDate = jobUpdatedDate;
	}

	public void setJobUpdatedBy(String jobUpdatedBy) {
		this.jobUpdatedBy = jobUpdatedBy;
	}

	@Override
	public String toString() {
		return "JobInfo [jobId=" + jobId + ", jobName=" + jobName
				+ ", jobDesc=" + jobDesc + ", company=" + company
				+ ", jobTime=" + jobTime + ", keywords="
				+ Arrays.toString(keywords) + ", jobPayScale=" + jobPayScale
				+ ", jobExperience=" + jobExperience + ", jobLanguages="
				+ Arrays.toString(jobLanguages) + ", jobCreateDate="
				+ jobCreateDate + ", jobCreatedBy=" + jobCreatedBy
				+ ", jobUpdatedDate=" + jobUpdatedDate + ", jobUpdatedBy="
				+ jobUpdatedBy + "]";
	}

}
