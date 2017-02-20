package org.qimei.training.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.qimei.training.db.EmployeeManagementDBHelper;
import org.qimei.training.db.EmployeeManagementDBManager;
import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.EmployeeDataSummary;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.PerformanceReview;
import org.qimei.training.pojo.WorkStation;

//create helper to assemble all collected data for employee/idcard/workstation
public class EmployeeSummaryHelper {

	// to create singleton method
	private static EmployeeSummaryHelper empSumHelper = null;

	private EmployeeSummaryHelper() {
		super();
	}

	public static EmployeeSummaryHelper getInstance() {
		if (empSumHelper == null) {
			empSumHelper = new EmployeeSummaryHelper();
		}
		return empSumHelper;
	}

	public List<EmployeeDataSummary> getAllEmpSummary() throws SQLException {

		List<EmployeeDataSummary> allEmpSummaryList = new ArrayList<EmployeeDataSummary>();
		EmployeeDataSummary tmpEmpDataSum = null;

		// get data from DB
		List<Employee> allEmpList = EmployeeManagementDBHelper.getInstance().getAllEmpsFromDB();
		List<IdCard> allIdList = EmployeeManagementDBHelper.getInstance().getAllIdCardFromDB();
		List<WorkStation> allWorkStationList = EmployeeManagementDBHelper.getInstance().getAllWorkStationFromDB();
		List<PerformanceReview> allPerformanceReviewList = EmployeeManagementDBHelper.getInstance().getAllPerformanceReviewFromDB();

		// for loop for all data falls into loop, emp/idcard/workstation
		for (int i = 0; i < allEmpList.size(); i++) {

			tmpEmpDataSum = new EmployeeDataSummary();
			tmpEmpDataSum.setEmp(allEmpList.get(i));
			tmpEmpDataSum.setEmpIdCard(allIdList.get(i));
			tmpEmpDataSum.setEmpWorkStation(allWorkStationList.get(i));
			tmpEmpDataSum.setEmpPerformanceReview(allPerformanceReviewList.get(i));

			allEmpSummaryList.add(tmpEmpDataSum);
		}

		return allEmpSummaryList;
	}

	public List<EmployeeDataSummary> getEmpSummaryById(long empId) throws SQLException {

		List<EmployeeDataSummary> empSummaryListById = new ArrayList<EmployeeDataSummary>();
		EmployeeDataSummary tmpEmpDataSum = null;

		List<Employee> empListById = EmployeeManagementDBHelper.getInstance().getEmpById(empId);
		List<IdCard> idListById = EmployeeManagementDBHelper.getInstance().getIdCardById(empId);
		List<WorkStation> workStationListById = EmployeeManagementDBHelper.getInstance().getWorkStationById(empId);
		List<PerformanceReview> performanceReviewListById = EmployeeManagementDBHelper.getInstance().getPerformanceReviewById(empId);

		for (int i = 0; i < empListById.size(); i++) {

			tmpEmpDataSum = new EmployeeDataSummary();
			tmpEmpDataSum.setEmp(empListById.get(i));
			tmpEmpDataSum.setEmpIdCard(idListById.get(i));
			tmpEmpDataSum.setEmpWorkStation(workStationListById.get(i));
			tmpEmpDataSum.setEmpPerformanceReview(performanceReviewListById.get(i));

			empSummaryListById.add(tmpEmpDataSum);
		}

		return empSummaryListById;
	}
}
