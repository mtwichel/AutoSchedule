package main;

import java.util.ArrayList;
import java.util.List;

import exceptions.TimeOutOfBoundsException;
import time.Duration;
import time.Time;

public class PlanOGram {
	
	private List<Duration> blocks;
	private List<Integer> numPeople;
	
	public PlanOGram() throws TimeOutOfBoundsException{
		
		blocks = new ArrayList<>();
		numPeople = new ArrayList<>();
		
		blocks.add(new Duration(new Time(5, 0), new Time(6, 0)));
		numPeople.add(2);
		blocks.add(new Duration(new Time(6, 0), new Time(7, 0)));
		numPeople.add(3);
		blocks.add(new Duration(new Time(7, 0), new Time(8, 0)));
		numPeople.add(4);
		blocks.add(new Duration(new Time(8, 0), new Time(9, 0)));
		numPeople.add(5);
		blocks.add(new Duration(new Time(9, 0), new Time(21, 0)));
		numPeople.add(6);
		
	}
	
	public int getSlots() throws TimeOutOfBoundsException{
		int numSlotsPerDay = 0;
		 for(int i=0; i<getNumBlocks(); i++){
			numSlotsPerDay += ((getBlock(i).getElapsedInMinutes())/15)*getBlockNumPeople(i);
		}
		 return numSlotsPerDay;
	}
	
	public int getNumBlocks(){
		return 5;
	}
	public Duration getBlock(int index){
		return blocks.get(index);
	}
	public int getBlockNumPeople(int index){
		return numPeople.get(index);
	}

}
