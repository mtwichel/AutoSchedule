package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.EmployeeNotFoundException;

public class Roster {

	private List<Employee> employeeList;
	private int currentEmployeeNumber;

	public Roster(){
		this.employeeList = new ArrayList<Employee>();
		this.currentEmployeeNumber = 0;
	}

	public void addEmployee(String employeeName){
		employeeList.add(new Employee(employeeName, currentEmployeeNumber, false));
		currentEmployeeNumber++;
	}
	public void removeEmployee(String empoyeeName) throws EmployeeNotFoundException{
		employeeList.remove(getEmployee(empoyeeName));
	}
	public int getNumEmployees(){
		return employeeList.size();
	}
	/**public Employee getEmployee(int empNum) throws EmployeeNotFoundException{
		for(Employee e : employeeList){
			if(e.getEmployeeNumber() == empNum){
				return e;
			}
		}
		try {
			throw new EmployeeNotFoundException();
		} catch (EmployeeNotFoundException e1) {
			System.out.println("Employee with number " + empNum + " was not found");
			throw new EmployeeNotFoundException();
		}
	}**/
	
	public Employee getEmployee(int num){
		return employeeList.get(num);
	}
	
	public Employee getEmployee(String empName) throws EmployeeNotFoundException{
		for(Employee e : employeeList){
			if(e.getEmployeeName().equals(empName)){
				return e;
			}
		}
		try {
			throw new EmployeeNotFoundException();
		} catch (EmployeeNotFoundException e1) {
			System.out.println("Employee with name " + empName + " was not found");
			throw new EmployeeNotFoundException();
		}
	}

}
