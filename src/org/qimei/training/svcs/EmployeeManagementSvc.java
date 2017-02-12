package org.qimei.training.svcs;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.qimei.training.db.EmployeeManagementDBHelper;
import org.qimei.training.pojo.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeManagementSvc {
	
	private static final Logger logger = Logger.getLogger(EmployeeManagementSvc.class);
	
	@RequestMapping (value = "allemp", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmp() throws SQLException {
		logger.info("All emp request");
		return EmployeeManagementDBHelper.getInstance().getAllEmpsFromDB();
	}

}
