package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.ShiftNotOnGapException;
import exceptions.TimeOutOfBoundsException;
import time.Duration;
import time.Time;

public class Schedule {
	
	
	List[][] shifts;
	int numSlotsPerDay;
	
	public Schedule(PlanOGram planogram) throws TimeOutOfBoundsException {
		
		numSlotsPerDay = planogram.getSlots();
		
		

		shifts = new List[7][numSlotsPerDay];

		
		for (int day = 0; day<7; day++){
			for(int slot=0; slot<numSlotsPerDay; slot++){
				shifts[day][slot] = new ArrayList<>();
			}
		}
		
	}

	private void assignSlot(Employee e, int day, int slot){
		shifts[day][slot].add(e);
	}
	


	public static void main(String[] args) throws TimeOutOfBoundsException, ShiftNotOnGapException{
		Schedule s;
		
		Roster r = new Roster();
		r.addEmployee("Joe");
		r.addEmployee("Jeff");
		r.addEmployee("Marcus");
		
		//Duration ho = new Duration(new Time(5, 0), new Time(22, 0));
		//System.out.println(s);
	}
}

