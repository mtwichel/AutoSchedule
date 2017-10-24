package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

import exceptions.EmployeeNotFoundException;
import exceptions.ShiftNotOnGapException;
import exceptions.TimeOutOfBoundsException;
import time.Duration;
import time.Time;

public class DaySchedule extends Duration{
	
	private Roster roster;
	private Map<Employee, Shift> shifts;
	
	public DaySchedule(Roster r, Duration openToClose) throws TimeOutOfBoundsException{
		super(openToClose.getLower(), openToClose.getHigher());
		shifts = new HashMap<Employee, Shift>();
		roster = r;	
	}
	
	public void assignShift(Shift shift){
		shifts.put(shift.getEmployee(), shift);
	}
	
	public String toString(){
		String ans = "";
		
		ans += "------------------\n";
		
		for(int i=0; i<roster.getNumEmployees(); i++){
			ans += shifts.get(roster.getEmployee(i)) + "\n";
		}
		
		ans += "------------------\n";
		
		return ans;
	}
	
	public static void main(String[] args) throws TimeOutOfBoundsException{
		Roster r = new Roster();
		r.addEmployee("Joe");
		r.addEmployee("Jeff");
		r.addEmployee("Marcus");
		DaySchedule d = new DaySchedule(r, new Duration(new Time(5, 00), new Time(21, 52)));
		try {
			d.assignShift(new Shift(new Time(5, 45), new Time(8, 00), r.getEmployee("Marcus")));
			System.out.println(d);
		} catch (ShiftNotOnGapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (EmployeeNotFoundException e1){
			e1.printStackTrace();
		}
	}

}
