package com.Developer.employeemanagement;

import com.Developer.employeemanagement.controller.EmployeeController;
import com.Developer.employeemanagement.entity.EmployeeEntity;
import com.Developer.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeManagementApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testFindAllEmployees() {
		// Mock EmployeeService to return a list of employees
		List<EmployeeEntity> mockEmployees = new ArrayList<>();
		EmployeeEntity emp1 = new EmployeeEntity(1L, "John Doe", "Male", new Date(), "123 Main St");
		EmployeeEntity emp2 = new EmployeeEntity(2L, "Jane Smith", "Female", new Date(), "456 Elm St");
		mockEmployees.add(emp1);
		mockEmployees.add(emp2);
		EmployeeService mockService = Mockito.mock(EmployeeService.class);
		Mockito.when(mockService.findAllEmployee()).thenReturn(mockEmployees);

		// Inject the mock service into the controller
		EmployeeController controller = new EmployeeController(mockService);

		// Call the controller method
		List<EmployeeEntity> actualEmployees = controller.findAllEmployee();

		// Assert that the returned list matches the expected list
		assertEquals(mockEmployees, actualEmployees);
	}
	@Test
	public void testFindEmployeeById() {
		Long empId = 1L;
		EmployeeEntity expectedEmployee = new EmployeeEntity(empId, "John Doe", "Male", new Date(), "123 Main St");

		// Mock EmployeeService to return the employee by ID
		EmployeeService mockService = Mockito.mock(EmployeeService.class);
		Mockito.when(mockService.findById(empId)).thenReturn(Optional.of(expectedEmployee));

		// Inject the mock service into the controller
		EmployeeController controller = new EmployeeController(mockService);

		// Call the controller method
		Optional<EmployeeEntity> actualEmployee = controller.findEmployeeById(empId);

		// Assert that the returned Optional contains the expected employee
		assertTrue(actualEmployee.isPresent());
		assertEquals(expectedEmployee, actualEmployee.get());
	}



	@Test
	public void testSaveEmployee() {
		EmployeeEntity newEmployee = new EmployeeEntity(1L, "Alice Brown", "Female", new Date(), "789 Maple St");

		// Mock EmployeeService to save the employee
		EmployeeService mockService = Mockito.mock(EmployeeService.class);
		Mockito.when(mockService.saveEmployee(newEmployee)).thenReturn(newEmployee);

		// Inject the mock service into the controller
		EmployeeController controller = new EmployeeController(mockService);

		// Call the controller method
		EmployeeEntity savedEmployee = controller.saveEmployee(newEmployee);

		// Assert that the returned object is not null and has an ID
		assertNotNull(savedEmployee);
		assertNotNull(savedEmployee.getId());
	}


}
