package test;

import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qimei.training.db.EmployeeManagementDBHelper;
import org.qimei.training.db.EmployeeManagementDBManager;
import org.qimei.training.pojo.Employee;
import org.qimei.training.pojo.IdCard;
import org.qimei.training.pojo.WorkStation;

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
		emp.setDob(new Date("1/1/1989"));
		emp.setJoinDate(new Date("1/1/2017"));
		emp.setSalary(10000);
		
		int rowCount = dbHelper.insertIntoEmps(emp);
		
		assert(rowCount > 0);
	}
	
	@Test
	public void testInsertIdCard() throws SQLException {
		
		IdCard empIdCard = new IdCard();
		Employee emp = new Employee();
		emp.setEmpId(1);
		empIdCard.setCompanyName("Google");
		empIdCard.setEmployee(emp);
		empIdCard.setEmployeeName("Tan Qi Mei");
		empIdCard.setEmployeePhoto("Pretty photo");
		empIdCard.setIssueDate(new Date("1/1/2017"));
		empIdCard.setNewOrReplace("New");
		
		int rowCount = dbHelper.inserIntoIdCard(empIdCard);
		
		assert (rowCount > 0);
		
	}
	
	@Test
	public void testInsertWorkStation() throws SQLException {
		
		Employee emp = new Employee();
		emp.setEmpId(1);
		WorkStation empWorkStation = new WorkStation();
		empWorkStation.setEmployee(emp);
		empWorkStation.setDeskPhoneNumber(1231231);
		empWorkStation.setFloorNumber(23);
		empWorkStation.setLaptop("Dell");
		empWorkStation.setLaptopId(12321);
		empWorkStation.setMouse("Logitech");
		empWorkStation.setMouseId(12312);
		empWorkStation.setSeatNumber(234);
		empWorkStation.setSeatNumber(3);
		
		int rowCount = dbHelper.insetIntoWorkStation(empWorkStation);
		
		assert (rowCount > 0);
	}

}
