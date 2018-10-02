package com.hubstafftalent.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class JobInfoService {

	@Autowired
	private JobInfoRepository jobInfoRepository;

	public List<JobInfo> getJobInfo() {
		List <JobInfo> jobInfoList = new ArrayList<JobInfo>();
		jobInfoRepository.findAll().forEach(jobInfoList::add);
		return jobInfoList;
	}

	public void insertJobInfo(JobInfo jobinfo) {
		jobInfoRepository.save(jobinfo);
	}

	public String storeFile(MultipartFile file) {
		System.out.println(file.getOriginalFilename());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
        	Path fileStoreLocation = Paths.get(new URI("file:///D:/uploads"));
            if(fileName.contains("..")) {
                throw new FileSystemException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = fileStoreLocation.resolve(fileName);
            if(!Files.exists(targetLocation))
            	Files.createDirectory(targetLocation);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            System.out.println("Could not store file " + fileName + ". Please try again!"+ ex);
        } catch (URISyntaxException e) {
			System.out.println("URI Syntax Exception"+"./uploads" );
		}
		return fileName;
	}



}
