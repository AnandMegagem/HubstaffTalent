package com.hubstafftalent.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class JobInsertController {

	@Autowired
	private JobInfoService jobInfoService;

	@GetMapping("/jobInfo")
	public List<JobInfo> getJobInfo()
	{
		return jobInfoService.getJobInfo();
	}

	@PostMapping("/addJobInfo")
	public void insertJobInfo(@RequestBody JobInfo jobinfo)
	{
		System.out.println(jobinfo.toString());
		 jobInfoService.insertJobInfo(jobinfo);
	}

	@PostMapping("/bulkAddJobInfo")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        jobInfoService.storeFile(file);
    }
}
