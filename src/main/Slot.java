package main;

import exceptions.TimeOutOfBoundsException;
import time.Duration;
import time.Time;

public class Slot extends Duration{

	public Slot(Time lower, Time higher) throws TimeOutOfBoundsException {
		super(lower, higher);
		// TODO Auto-generated constructor stub
	}

}
