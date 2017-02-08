package org.qimei.training.db;


public class EmployeeManagementDBHelper {
	
	private static EmployeeManagementDBHelper empMgmtDBHelper = null;
	
	private EmployeeManagementDBHelper() {
		super();
	}
	
	public static EmployeeManagementDBHelper getInstance() {
		if (empMgmtDBHelper == null) {
			empMgmtDBHelper = new EmployeeManagementDBHelper();
		}
		return empMgmtDBHelper;
	}

}
