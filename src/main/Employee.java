package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Employee {
	
	private String employeeName;
	private Map<Preference, Integer> weights;
	private List<Preference> preferences;
	private List<EmployeeRule> rules;
	private boolean isShiftLeader;
	private int employeeNumber;
	
	public Employee(String employeeName, int empolyeeNumber, boolean isShiftLeader){
		this.employeeName = employeeName;
		this.setShiftLeader(isShiftLeader);
		this.employeeNumber = empolyeeNumber;
		this.preferences = new ArrayList<Preference>();
		this.rules = new ArrayList<EmployeeRule>();
	}
	
	public boolean isValid(Shift shift){
		boolean answer = true;
		for (EmployeeRule rule : rules){
			if(!rule.isValid(shift)){
				answer = false;
			}
		}
		return answer;
	}
	
	public int generateHappiness(Schedule schedule){
		int answer = 0;
		for(Preference pref: preferences){
			answer += (pref.calcutlateHappiness(schedule) * weights.get(pref));
		}
		return answer;
	}
	
	public void addPreference(Preference pref){
		preferences.add(pref);
		weights.put(pref, pref.getWeight());
	}
	
	public void removePreference(Preference pref){
		preferences.remove(pref);
		weights.remove(pref);
	}

	public boolean isShiftLeader() {
		return isShiftLeader;
	}

	public void setShiftLeader(boolean isShiftLeader) {
		this.isShiftLeader = isShiftLeader;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

}
