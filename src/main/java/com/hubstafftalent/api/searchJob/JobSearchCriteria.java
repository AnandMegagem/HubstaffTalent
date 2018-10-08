package com.hubstafftalent.api.searchJob;

import java.util.Arrays;


public class JobSearchCriteria {

	private Long jobId;
	private String jobName;
	private String[] keywords;
	private Long minPay;
	private Long maxPay;
	private String location;
	private String[] languages;
	private Integer minExp;
	private Integer maxExp;
	private String[] availability;
	private String cmpnyname;
	public Long getJobId() {
		return jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public Long getMinPay() {
		return minPay;
	}
	public Long getMaxPay() {
		return maxPay;
	}
	public String getLocation() {
		return location;
	}
	public String[] getLanguages() {
		return languages;
	}
	public Integer getMinExp() {
		return minExp;
	}
	public Integer getMaxExp() {
		return maxExp;
	}
	public String[] getAvailability() {
		return availability;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public void setMinPay(Long minPay) {
		this.minPay = minPay;
	}
	public void setMaxPay(Long maxPay) {
		this.maxPay = maxPay;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public void setMinExp(Integer minExp) {
		this.minExp = minExp;
	}
	public void setMaxExp(Integer maxExp) {
		this.maxExp = maxExp;
	}
	public void setAvailability(String[] availability) {
		this.availability = availability;
	}
	public String getCmpnyname() {
		return cmpnyname;
	}
	public void setCmpnyname(String cmpnyname) {
		this.cmpnyname = cmpnyname;
	}
	@Override
	public String toString() {
		return "JobSearchCriteria [jobId=" + jobId + ", jobName=" + jobName
				+ ", keywords=" + Arrays.toString(keywords) + ", minPay="
				+ minPay + ", maxPay=" + maxPay + ", location="
				+ location + ", languages="
				+ Arrays.toString(languages) + ", minExp=" + minExp
				+ ", maxExp=" + maxExp + ", availability="
				+ Arrays.toString(availability) + "]";
	}
}
