package main;

import java.util.ArrayList;
import java.util.List;

import exceptions.TimeOutOfBoundsException;

public class Model {
	
	private Roster roster; 
	List<Schedule> shedules;
	private PlanOGram planogram;
	
	public Model(Roster r, PlanOGram p) throws TimeOutOfBoundsException{
		this.roster = r;
		this.planogram = p;
		this.shedules = new ArrayList<>();
	
	
	for(int i=0; i<roster.getNumEmployees(); i++){
		for(int j=0; j<planogram.getSlots(); j++){
			shedules.add(new Schedule(planogram));
			
		}
	}
	}
}
