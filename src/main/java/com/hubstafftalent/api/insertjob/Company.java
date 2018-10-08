package com.hubstafftalent.api.insertjob;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String cmpyName;
	private String cmpyLocation;
	private String cmpyURL;
	private Date cmpyCreatedDate;
	private String cmpyCreatedBy;
	private Date cmpyUpdatedDate;
	private String cmpyUpdatedBy;

	public Long getId() {
		return Id;
	}

	public String getCmpyName() {
		return cmpyName;
	}

	public String getCmpyLocation() {
		return cmpyLocation;
	}

	public String getCmpyURL() {
		return cmpyURL;
	}

	public Date getCmpyCreatedDate() {
		return cmpyCreatedDate;
	}

	public String getCmpyCreatedBy() {
		return cmpyCreatedBy;
	}

	public Date getCmpyUpdatedDate() {
		return cmpyUpdatedDate;
	}

	public String getCmpyUpdatedBy() {
		return cmpyUpdatedBy;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setCmpyName(String cmpyName) {
		this.cmpyName = cmpyName;
	}

	public void setCmpyLocation(String cmpyLocation) {
		this.cmpyLocation = cmpyLocation;
	}

	public void setCmpyURL(String cmpyURL) {
		this.cmpyURL = cmpyURL;
	}

	public void setCmpyCreatedDate(Date cmpyCreatedDate) {
		this.cmpyCreatedDate = cmpyCreatedDate;
	}

	public void setCmpyCreatedBy(String cmpyCreatedBy) {
		this.cmpyCreatedBy = cmpyCreatedBy;
	}

	public void setCmpyUpdatedDate(Date cmpyUpdatedDate) {
		this.cmpyUpdatedDate = cmpyUpdatedDate;
	}

	public void setCmpyUpdatedBy(String cmpyUpdatedBy) {
		this.cmpyUpdatedBy = cmpyUpdatedBy;
	}

	@Override
	public String toString() {
		return "Company [Id=" + Id + ", cmpyName=" + cmpyName
				+ ", cmpyLocation=" + cmpyLocation + ", cmpyURL=" + cmpyURL
				+ ", cmpyCreatedDate=" + cmpyCreatedDate + ", cmpyCreatedBy="
				+ cmpyCreatedBy + ", cmpyUpdatedDate=" + cmpyUpdatedDate
				+ ", cmpyUpdatedBy=" + cmpyUpdatedBy + "]";
	}
}

