package com.hubstafftalent.api.searchJob;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hubstafftalent.api.insertjob.JobInfo;

public interface JobSearchRepository extends JpaRepository<JobInfo, Long> {

	String searchJobBaseQuery = "Select distinct j from JobInfo j join JobKeywords k on j.jobId=k.jobId join JobLanguages l on j.jobId=l.jobId join Company c on j.company.Id=c.Id ";

	@Query("Select j from JobInfo j join JobKeywords k on j.jobId=k.jobId where k.keyword in (?1)")
	List<JobInfo> findByKeywords(String[] string);

	@Query(searchJobBaseQuery
			+ "where k.keyword in (?1) and (j.jobTime in (?2))  and j.jobPayScale between (?3) and (?4) "
			+ "and j.jobExperience between (?5) and (?6) and (?7 is null or c.cmpyLocation = ?7) and (l.language in (?8))")
	List<JobInfo> findJobsWithKeyWords(String[] keywords, String[] availability,
			Long minPay, Long maxPay, Integer minExp, Integer maxExp,
			String location, String[] languages);

	@Query(searchJobBaseQuery
			+ "where k.keyword in (?1) and j.jobPayScale between (?2) and (?3) "
			+ "and j.jobExperience between (?4) and (?5) and (?6 is null or c.cmpyLocation = ?6) and (l.language in (?7))")
	List<JobInfo> findJobsWithKeyWords(String[] keywords, Long minPay, Long maxPay,
			Integer minExp, Integer maxExp, String location, String[] languages);

	@Query(searchJobBaseQuery
			+ "where k.keyword in (?1) and (j.jobTime in (?2))  and j.jobPayScale between (?3) and (?4) "
			+ "and j.jobExperience between (?5) and (?6) and (?7 is null or c.cmpyLocation = ?7)")
	List<JobInfo> findJobsWithKeyWords(String[] keywords, String[] availability,
			Long minPay, Long maxPay, Integer minExp, Integer maxExp,
			String location);

	@Query(searchJobBaseQuery
			+ "where k.keyword in (?1) and j.jobPayScale between (?2) and (?3) "
			+ "and j.jobExperience between (?4) and (?5) and (?6 is null or c.cmpyLocation = ?6)")
	List<JobInfo> findJobsWithKeyWords(String[] keywords, Long minPay, Long maxPay,
			Integer minExp, Integer maxExp, String location);

	@Query(searchJobBaseQuery
			+ "where j.jobTime in (?1)  and j.jobPayScale between (?2) and (?3) "
			+ "and j.jobExperience between (?4) and (?5) and (?6 is null or c.cmpyLocation = ?6) and (l.language in (?7))")
	List<JobInfo> findJobsWithOutKeyWords(String[] availability, Long minPay,
			Long maxPay, Integer minExp, Integer maxExp, String location,
			String[] languages);

	@Query(searchJobBaseQuery
			+ "where j.jobPayScale between (?1) and (?2) "
			+ "and j.jobExperience between (?3) and (?4) and (?5 is null or c.cmpyLocation = ?5) and (l.language in (?6))")
	List<JobInfo> findJobsWithOutKeyWords(Long minPay, Long maxPay,
			Integer minExp, Integer maxExp, String location, String[] languages);

	@Query(searchJobBaseQuery
			+ "where j.jobTime in (?1)  and j.jobPayScale between (?2) and (?3) "
			+ "and j.jobExperience between (?4) and (?5) and (?6 is null or c.cmpyLocation = ?6)")
	List<JobInfo> findJobsWithOutKeyWords(String[] availability, Long minPay,
			Long maxPay, Integer minExp, Integer maxExp, String location);

	@Query(searchJobBaseQuery
			+ "where j.jobPayScale between (?1) and (?2) "
			+ "and j.jobExperience between (?3) and (?4) and (?5 is null or c.cmpyLocation = ?5)")
	List<JobInfo> findJobsWithOutKeyWords(Long minPay, Long maxPay,
			Integer minExp, Integer maxExp, String location);

	@Query("Select max(j.jobPayScale) from JobInfo j")
	Long getMaxPayScale();

	@Query("Select max(j.jobExperience) from JobInfo j")
	Integer getMaxExperience();
}
