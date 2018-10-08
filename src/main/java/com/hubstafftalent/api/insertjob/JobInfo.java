package com.hubstafftalent.api.insertjob;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "jobId")
	private List<JobKeywords> keywords;

	private Long jobPayScale;

	private Integer jobExperience;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="jobId")
	private List<JobLanguages> jobLanguages;

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

	public List<JobKeywords> getKeywords() {
		return keywords;
	}

	public List<JobLanguages> getJobLanguages() {
		return jobLanguages;
	}

	public Long getJobPayScale() {
		return jobPayScale;
	}

	public Integer getJobExperience() {
		return jobExperience;
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



	public void setJobPayScale(Long jobPayScale) {
		this.jobPayScale = jobPayScale;
	}

	public void setJobExperience(Integer jobExperience) {
		this.jobExperience = jobExperience;
	}

	public void setKeywords(List<JobKeywords> keywords) {
		this.keywords = keywords;
	}

	public void setJobLanguages(List<JobLanguages> jobLanguages) {
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
				+ keywords + ", jobPayScale=" + jobPayScale
				+ ", jobExperience=" + jobExperience + ", jobLanguages="
				+ jobLanguages + ", jobCreateDate="
				+ jobCreateDate + ", jobCreatedBy=" + jobCreatedBy
				+ ", jobUpdatedDate=" + jobUpdatedDate + ", jobUpdatedBy="
				+ jobUpdatedBy + "]";
	}

}
