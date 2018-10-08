package com.hubstafftalent.api.searchJob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubstafftalent.api.insertjob.JobInfo;

@Service
public class JobSearchService {

	@Autowired
	private JobSearchRepository jobSearchRepository;

	public List<JobInfo> searchJobsByKeywords(
			JobSearchCriteria jobSearchCriteria) {
		List<JobInfo> resultList = jobSearchRepository
				.findByKeywords(jobSearchCriteria.getKeywords());
		return resultList;
	}

	public List<JobInfo> searchJobs(JobSearchCriteria jobSearchCriteria) {
		List<JobInfo> resultList = null;

		if (null != jobSearchCriteria) {
			if (null == jobSearchCriteria.getMinExp()) {jobSearchCriteria.setMinExp(0);}
			if (null == jobSearchCriteria.getMinPay()) {jobSearchCriteria.setMinPay(0L);}
			if (null == jobSearchCriteria.getMaxExp()) {jobSearchCriteria.setMaxExp(jobSearchRepository.getMaxExperience());}
			if (null == jobSearchCriteria.getMaxPay()) {jobSearchCriteria.setMaxPay(jobSearchRepository.getMaxPayScale());}
			if (null != jobSearchCriteria.getKeywords()) {
				if (null != jobSearchCriteria.getAvailability()
						&& null != jobSearchCriteria.getLanguages()) {
					resultList = jobSearchRepository.findJobsWithKeyWords(
							jobSearchCriteria.getKeywords(),
							jobSearchCriteria.getAvailability(),
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation(),
							jobSearchCriteria.getLanguages());
				} else if (null == jobSearchCriteria.getAvailability()
						&& null != jobSearchCriteria.getLanguages()) {
					resultList = jobSearchRepository.findJobsWithKeyWords(
							jobSearchCriteria.getKeywords(),
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation(),
							jobSearchCriteria.getLanguages());
				} else if (null != jobSearchCriteria.getAvailability()
						&& null == jobSearchCriteria.getLanguages()) {
					resultList = jobSearchRepository.findJobsWithKeyWords(
							jobSearchCriteria.getKeywords(),
							jobSearchCriteria.getAvailability(),
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation());
				} else {
					resultList = jobSearchRepository.findJobsWithKeyWords(
							jobSearchCriteria.getKeywords(),
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation());
				}

			}
			if (null == jobSearchCriteria.getKeywords()) {
				if (null != jobSearchCriteria.getAvailability()
						&& null != jobSearchCriteria.getLanguages()) {
					resultList = jobSearchRepository.findJobsWithOutKeyWords(
							jobSearchCriteria.getAvailability(),
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation(),
							jobSearchCriteria.getLanguages());
				} else if (null == jobSearchCriteria.getAvailability()
						&& null != jobSearchCriteria.getLanguages()) {
					resultList = jobSearchRepository.findJobsWithOutKeyWords(
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation(),
							jobSearchCriteria.getLanguages());
				} else if (null != jobSearchCriteria.getAvailability()
						&& null == jobSearchCriteria.getLanguages()) {
					resultList = jobSearchRepository.findJobsWithOutKeyWords(
							jobSearchCriteria.getAvailability(),
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation());
				} else {
					resultList = jobSearchRepository.findJobsWithOutKeyWords(
							jobSearchCriteria.getMinPay(),
							jobSearchCriteria.getMaxPay(),
							jobSearchCriteria.getMinExp(),
							jobSearchCriteria.getMaxExp(),
							jobSearchCriteria.getLocation());
				}
			}
		}
		return resultList;
	}

}
