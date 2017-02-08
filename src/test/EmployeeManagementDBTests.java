package test;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qimei.training.db.EmployeeManagementDBHelper;
import org.qimei.training.db.EmployeeManagementDBManager;
import org.qimei.training.pojo.Employee;

public class EmployeeManagementDBTests {

	EmployeeManagementDBManager dbManager = null;
	EmployeeManagementDBHelper dbHelper = null;
	
	@Before
	public void setUp() throws Exception {
		dbManager = EmployeeManagementDBManager.getInstance();
		dbHelper = EmployeeManagementDBHelper.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertEmployee() throws SQLException {
		
		Employee emp = new Employee();
		emp.setFirstName("Qi Mei");
		emp.setLastName("Tan");
		emp.setAddress("Singapore");
		emp.setAge(28);
		
		int rowCount = dbHelper.insertIntoEmps(emp);
		
		assert(rowCount > 0);
	}

}
