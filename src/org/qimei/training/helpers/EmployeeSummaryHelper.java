package org.qimei.training.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.qimei.training.db.EmployeeManagementDBHelper;
import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.EmployeeDataSummary;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.WorkStation;

public class EmployeeSummaryHelper {

	private static EmployeeSummaryHelper empSumHelper = null;
	
	private EmployeeSummaryHelper(){
		super();
	}
	
	public static EmployeeSummaryHelper getInstance(){
		if (empSumHelper == null) {
			empSumHelper = new EmployeeSummaryHelper();
		}
		return empSumHelper;
	}
	
	public List<EmployeeDataSummary> getAllEmpSummary() throws SQLException {
		
		List<EmployeeDataSummary> allEmpSummaryList = new ArrayList<EmployeeDataSummary>();
		EmployeeDataSummary tmpEmpDataSum = null;
		
		List<Employee> allEmpList = EmployeeManagementDBHelper.getInstance().getAllEmpsFromDB();
		List<IdCard> allIdList = EmployeeManagementDBHelper.getInstance().getAllIdCardFromDB();
		List<WorkStation> allWorkStationList = EmployeeManagementDBHelper.getInstance().getAllWorkStationFromDB();
		
		for (int i=0; i < allEmpList.size(); i++) {
			
			tmpEmpDataSum = new EmployeeDataSummary();
			tmpEmpDataSum.setEmp(allEmpList.get(i));
			tmpEmpDataSum.setEmpIdCard(allIdList.get(i));
			tmpEmpDataSum.setEmpWorkStation(allWorkStationList.get(i));
			
			allEmpSummaryList.add(tmpEmpDataSum);
		}
		
		return allEmpSummaryList;
	}
}
