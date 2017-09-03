package org.qimei.training.jobs;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EmpMgmtReaderJob implements Job {
	private static final Logger logger = Logger.getLogger(EmpMgmtReaderJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			generateReports();
		} catch (Exception e) {
			logger.info(e);
		}

	}

	public void generateReports() {
		logger.info("generating reports...");
	}

}