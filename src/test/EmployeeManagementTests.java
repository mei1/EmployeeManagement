package test;

import java.sql.SQLException;

import org.junit.Test;
import org.qimei.training.db.EmployeeManagementDBManager;

public class EmployeeManagementTests {

	@Test
	public void testEmployeeManagementDb() throws SQLException {
		EmployeeManagementDBManager empMgmtDbManager = EmployeeManagementDBManager.getInstance();
	}

}
