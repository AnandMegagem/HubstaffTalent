package com.hubstafftalent.api.insertjob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class JobLanguages {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@JoinColumn(name = "jobId")
	private Long jobId;

	private String language;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "JobLanguages [id=" + id + ", jobinfo=" + jobId
				+ ", language=" + language + "]";
	}



}
