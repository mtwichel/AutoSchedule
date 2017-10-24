package main;

import java.util.ArrayList;
import java.util.List;

import exceptions.ShiftNotOnGapException;
import exceptions.TimeOutOfBoundsException;
import time.Day;
import time.Duration;
import time.Time;

public class Shift extends Duration{
	
	private List<Employee> otherWorkers;
	private Employee employee;
	private Day day;
	private int gap;

	public Shift(Time lower, Time higher, Employee employee, Day day, int gap) throws TimeOutOfBoundsException, ShiftNotOnGapException {
		super(lower, higher);
		this.gap = gap;
		if((this.lower.getMinutes()%gap != 0	|| (this.higher.getMinutes()%gap != 0))){
			try {
				throw new ShiftNotOnGapException();
			} catch (ShiftNotOnGapException e) {
				System.out.println("Shifts must be done in "+ gap + " minute segments");
				throw new ShiftNotOnGapException();
			}
		}
		this.employee = employee;
		this.otherWorkers = new ArrayList<Employee>();
	}
	
	public int getGap(){
		return this.gap;
	}
	public Day getDay(){
		return this.day;
	}
	
	public String toString(){
		return "" + employee.getEmployeeName() + ": " + super.toString();
	}
	
	public static void main(String[] args){
		Employee e = new Employee("Marcus", 0, false);
		try {
			Shift s = new Shift(new Time(15,0), new Time(18, 0), e, new Day(0), 15);
//			System.out.println(s);
		} catch (TimeOutOfBoundsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ShiftNotOnGapException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public Employee getEmployee(){
		return this.employee;
	}

}
