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
import org.qimei.training.pojo.PerformanceReview;
import org.qimei.training.pojo.UserInputs;
import org.qimei.training.pojo.WorkStation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeManagementSvc {

	private static final Logger logger = Logger.getLogger(EmployeeManagementSvc.class);

	// service to collect data into emp/idcard/workstation
	@RequestMapping(value = "insertempdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoEmp(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into emp request");
		return EmployeeManagementDBHelper.getInstance().insertIntoEmps(userInputs.getEmp());
	}

	@RequestMapping(value = "insertidcarddata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoIdCard(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into id card request");
		return EmployeeManagementDBHelper.getInstance().inserIntoIdCard(userInputs.getIdCard());
	}

	@RequestMapping(value = "insertworkstationdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoWorkStation(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into work station request");
		return EmployeeManagementDBHelper.getInstance().insertIntoWorkStation(userInputs.getWorkStation());
	}

	@RequestMapping(value = "insertperformancereviewdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoPerformanceReview(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into performance review request");
		return EmployeeManagementDBHelper.getInstance().insertIntoPerformanceReview(userInputs.getPerformanceReview());
	}

	// service for getting emp/idcard/workstation
	@RequestMapping(value = "allemp", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmp() throws SQLException {
		logger.info("All emp request");
		return EmployeeManagementDBHelper.getInstance().getAllEmpsFromDB();
	}

	@RequestMapping(value = "allidcard", method = RequestMethod.GET, produces = "application/json")
	public List<IdCard> getAllIdCard() throws SQLException {
		logger.info("All id card request");
		return EmployeeManagementDBHelper.getInstance().getAllIdCardFromDB();
	}

	@RequestMapping(value = "allworkstation", method = RequestMethod.GET, produces = "application/json")
	public List<WorkStation> getAllWorkStation() throws SQLException {
		logger.info("All work station request");
		return EmployeeManagementDBHelper.getInstance().getAllWorkStationFromDB();
	}

	@RequestMapping(value = "allperformancereview", method = RequestMethod.GET, produces = "application/json")
	public List<PerformanceReview> getAllPerformanceReview() throws SQLException {
		logger.info("All performance review request");
		return EmployeeManagementDBHelper.getInstance().getAllPerformanceReviewFromDB();
	}

	// service for emp summary
	@RequestMapping(value = "allempsummary", method = RequestMethod.GET, produces = "application/json")
	public List<EmployeeDataSummary> allEmpSummary() throws SQLException {
		logger.info("All employee summary request");
		return EmployeeSummaryHelper.getInstance().getAllEmpSummary();
	}

	// service for emp summary by id
	@RequestMapping(value = "empsummarybyid", method = RequestMethod.POST, produces = "application/json")
	public List<EmployeeDataSummary> empSummaryById(@RequestBody Employee empIdObj) throws SQLException {
		logger.info("All employee summary request by ID - " + empIdObj);
		return EmployeeSummaryHelper.getInstance().getEmpSummaryById(empIdObj.getEmpId());
	}

	// service for getting emp/idcard/workstation by id
	@RequestMapping(value = "empbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<Employee> getEmpById(@RequestBody Employee empIdObj) throws JSONException, SQLException {
		logger.info("All emp request by ID - " + empIdObj);
		return EmployeeManagementDBHelper.getInstance().getEmpById((int) empIdObj.getEmpId());
	}

	@RequestMapping(value = "idcardbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<IdCard> getIdCardById(@RequestBody Employee empIdObj) throws JSONException, SQLException {
		logger.info("All id card request by ID - " + empIdObj);
		return EmployeeManagementDBHelper.getInstance().getIdCardById((int) empIdObj.getEmpId());
	}

	@RequestMapping(value = "workstationbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<WorkStation> getWorkStationById(@RequestBody Employee empIdObj) throws JSONException, SQLException {
		logger.info("All work station request by ID - " + empIdObj);
		return EmployeeManagementDBHelper.getInstance().getWorkStationById((int) empIdObj.getEmpId());
	}

	public List<PerformanceReview> getPerformanceReviewById(@RequestBody Employee empIdObj) throws SQLException {
		logger.info("All performance review request by ID - " + empIdObj);
		return EmployeeManagementDBHelper.getInstance().getPerformanceReviewById((int) empIdObj.getEmpId());
	}

	// service for deleting emp/idcard/workstation
	@RequestMapping(value = "deleteemp", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteEmp(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Delete emp request");
		return EmployeeManagementDBHelper.getInstance().deleteExistingEmp(userInputs.getEmp());
	}

	@RequestMapping(value = "deleteidcard", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteIdCard(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Delete idcard request");
		// collect empid from emp inside userInputs, body request:
		// {"emp":{"empId": 2}}
		return EmployeeManagementDBHelper.getInstance().deleteExistingIdCard(userInputs.getEmp().getEmpId());
	}

	@RequestMapping(value = "deleteworkstation", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteWorkStation(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Delete work station request");
		return EmployeeManagementDBHelper.getInstance().deleteExistingWorkStation(userInputs.getEmp().getEmpId());
	}

	@RequestMapping(value = "deleteperformancereview", method = RequestMethod.DELETE, produces = "application/json")
	public int deletePerformanceReview(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Delete performance review request");
		return EmployeeManagementDBHelper.getInstance().deleteExistingPerformanceReview(userInputs.getEmp().getEmpId());
	}

	// service for updating emp/idcard/workstation by id
	@RequestMapping(value = "updateemp", method = RequestMethod.POST, produces = "application/json")
	public int updateEmpById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update emp request");
		return EmployeeManagementDBHelper.getInstance().updateEmpById(userInputs.getEmp().getEmpId(),
				userInputs.getColumnName(), userInputs.getColumnValue());
	}

	@RequestMapping(value = "updateidcard", method = RequestMethod.POST, produces = "application/json")
	public int updateIdCardById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update id card request");
		return EmployeeManagementDBHelper.getInstance().updateEmpIdCardById(
				userInputs.getIdCard().getEmployee().getEmpId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}

	@RequestMapping(value = "updateworkstation", method = RequestMethod.POST, produces = "application/json")
	public int updateWorkStationById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update work station request");
		return EmployeeManagementDBHelper.getInstance().updateWorkStationById(
				userInputs.getWorkStation().getEmployee().getEmpId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}

	@RequestMapping(value = "updateperformancereview", method = RequestMethod.POST, produces = "application/json")
	public int updatePerformanceReviewById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update performance review request");
		return EmployeeManagementDBHelper.getInstance().updatePerformanceReviewById(
				userInputs.getPerformanceReview().getEmployee().getEmpId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}
}
