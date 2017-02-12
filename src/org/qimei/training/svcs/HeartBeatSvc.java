package org.qimei.training.svcs;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatSvc {
	
	private static final Logger logger = Logger.getLogger(HeartBeatSvc.class);

	@RequestMapping (value = "hb", method = RequestMethod.GET, produces = "application/json")
	public String heartBeat(){
		logger.info("heartbeat request");
		String heartBeatTime = Calendar.getInstance().getTime().toString();
		return heartBeatTime;
	}
}
