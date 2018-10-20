package com.pgrsoft.cursospringbatch.endpoints;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggerController {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@RequestMapping(value="triggerjob")
	public String trigger() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		JobParameter jobParameter = new JobParameter(sdf.format(new Date()) + ": " + (int)(Math.random() * 1000));
		Map<String, JobParameter> parametersMap = new HashMap<String, JobParameter>();
		parametersMap.put("parametro1", jobParameter);
		jobLauncher.run(job, new JobParameters(parametersMap));
			
		return "ok";
	}
	
}
