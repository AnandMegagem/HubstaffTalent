package com.hubstafftalent.api.insertjob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
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

	public File storeFileToTempDir(MultipartFile file) {
		System.out.println(file.getOriginalFilename());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
        	Path fileStoreLocation = Paths.get(new URI("file:///D:/uploads"));
            if(!fileName.endsWith(".csv")) {
            	throw new FileSystemException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = fileStoreLocation.resolve(fileName);
            if(!Files.exists(targetLocation))
            	Files.createDirectory(targetLocation);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return targetLocation.toFile();
        } catch (IOException ex) {
            System.out.println("Could not store file " + fileName + ". Please try again!"+ ex);
        } catch (URISyntaxException e) {
			System.out.println("URI Syntax Exception"+"file:///D:/uploads" );
		}
		return null;
	}

	public List<JobInfo> readFile(File inputFile) throws IOException {
		FileInputStream fis;
		if(!Files.exists(inputFile.toPath()))
		{
			throw new FileNotFoundException("File Delete or Not Created");
		}
		fis= new FileInputStream(inputFile);
		try(BufferedReader buffer=new BufferedReader(new InputStreamReader(fis)))
		{
			System.out.println(buffer.lines().map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList()));
		}
		return null;
	}



}
