package com.hubstafftalent.searchApi;

import java.util.Arrays;

import javax.persistence.Entity;

@Entity
public class JobSearchCriteria {

	private Long jobId;
	private String jobName;
	private String[] keywords;
	private Integer minPay;
	private Integer maxPay;
	private String[] countries;
	private String[] languages;
	private Integer minExp;
	private Integer maxExp;
	private String[] availability;
	public Long getJobId() {
		return jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public Integer getMinPay() {
		return minPay;
	}
	public Integer getMaxPay() {
		return maxPay;
	}
	public String[] getCountries() {
		return countries;
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
	public void setMinPay(Integer minPay) {
		this.minPay = minPay;
	}
	public void setMaxPay(Integer maxPay) {
		this.maxPay = maxPay;
	}
	public void setCountries(String[] countries) {
		this.countries = countries;
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
	@Override
	public String toString() {
		return "JobSearchCriteria [jobId=" + jobId + ", jobName=" + jobName
				+ ", keywords=" + Arrays.toString(keywords) + ", minPay="
				+ minPay + ", maxPay=" + maxPay + ", countries="
				+ Arrays.toString(countries) + ", languages="
				+ Arrays.toString(languages) + ", minExp=" + minExp
				+ ", maxExp=" + maxExp + ", availability="
				+ Arrays.toString(availability) + "]";
	}
}
