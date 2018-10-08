package com.hubstafftalent.api.searchJob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hubstafftalent.api.exception.JobNotFoundException;
import com.hubstafftalent.api.insertjob.JobInfo;

@RestController
public class JobSearchController {

	@Autowired
	private JobSearchService jobSearchService;

	@PostMapping("/searchJobs")
	public List<JobInfo> searchJobs(@RequestBody JobSearchCriteria jobSearchCriteria)
	{
		List<JobInfo> resultList=jobSearchService.searchJobs(jobSearchCriteria);
		if(null==resultList || resultList.isEmpty())
			throw new JobNotFoundException("No Job Found for your search Filter");
		return resultList;
	}

}
