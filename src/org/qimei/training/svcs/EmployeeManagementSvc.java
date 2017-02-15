package org.qimei.training.svcs;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.qimei.training.db.EmployeeManagementDBHelper;
import org.qimei.training.helpers.EmployeeSummaryHelper;
import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.EmployeeDataSummary;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.WorkStation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeManagementSvc {
	
	private static final Logger logger = Logger.getLogger(EmployeeManagementSvc.class);
	
	//service for getting emp/idcard/workstation
	@RequestMapping (value = "allemp", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmp() throws SQLException {
		logger.info("All emp request");
		return EmployeeManagementDBHelper.getInstance().getAllEmpsFromDB();
	}
	
	@RequestMapping (value = "allidcard", method = RequestMethod.GET, produces = "application/json")
	public List<IdCard> getAllIdCard() throws SQLException{
		logger.info("All id card request");
		return EmployeeManagementDBHelper.getInstance().getAllIdCardFromDB();
	}
	
	@RequestMapping (value = "allworkstation", method = RequestMethod.GET, produces = "application/json")
	public List<WorkStation> getAllWorkStation() throws SQLException{
		logger.info("All work station request");
		return EmployeeManagementDBHelper.getInstance().getAllWorkStationFromDB();
	}
	
	//service for emp summary
	@RequestMapping (value = "allempsummary", method = RequestMethod.GET, produces = "application/json")
	public List<EmployeeDataSummary> allEmpSummary() throws SQLException{
		logger.info("All employee summary request");
		return EmployeeSummaryHelper.getInstance().getAllEmpSummary();
	}
	
	//service for getting emp/idcard/workstation by id
	@RequestMapping (value = "empbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<Employee> getEmpById(@RequestBody Employee empIdObj) throws JSONException, SQLException {
		logger.info("All emp request by ID - " + empIdObj);
		return EmployeeManagementDBHelper.getInstance().getEmpById((int) empIdObj.getEmpId());
	}
	
	@RequestMapping (value = "idcardbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<IdCard> getIdCardById(@RequestBody Employee empIdObj) throws JSONException, SQLException {
		logger.info("All id card request by ID - " + empIdObj);
		return EmployeeManagementDBHelper.getInstance().getIdCardById((int) empIdObj.getEmpId());
	}
	
	@RequestMapping (value = "workstationbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<WorkStation> getWorkStationById(@RequestBody Employee empIdObj) throws JSONException, SQLException {
		logger.info("All work station request by ID - " + empIdObj);
		return EmployeeManagementDBHelper.getInstance().getWorkStationById((int) empIdObj.getEmpId());
	}
	
	//service for deleting emp/idcard/workstation
	@RequestMapping (value = "deleteemp", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteEmp() throws SQLException {
		logger.info("Delete emp request");
		Employee emp = new Employee();
		return EmployeeManagementDBHelper.getInstance().deleteExistingEmp(emp);
	}
	
	@RequestMapping (value = "deleteidcard", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteIdCard() throws SQLException {
		logger.info("Delete idcard request");
		IdCard empIdCard = new IdCard();
		return EmployeeManagementDBHelper.getInstance().deleteExistingIdCard(empIdCard);
	}

	@RequestMapping (value = "deleteworkstation", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteWorkStation() throws SQLException {
		logger.info("Delete work station request");
		WorkStation empWorkStation = new WorkStation();
		return EmployeeManagementDBHelper.getInstance().deleteExistingWorkStation(empWorkStation);
	}
	
	//service for updating emp/idcard/workstation by id
	public int updateEmpById() throws SQLException{
		logger.info("Update emp request");
		Employee emp = new Employee();
		int empId = (Integer) null;
		String columnName = null;
		Object columnValue = null;
		return EmployeeManagementDBHelper.getInstance().updateEmpById(empId, columnName, columnValue);
	}
	
}
