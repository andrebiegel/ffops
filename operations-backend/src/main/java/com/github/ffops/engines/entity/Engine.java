package com.github.ffops.engines.entity;

public class Engine {

	public static Engine createEngine(String type, String radioId, int seats) {
		return new Engine(type, radioId, seats);
	}
	// standard name of the engine like tlf 4000 
	private String type;
	private String  radioId; 
	private int seats;
	private Engine(String type, String radioId, int seats) {
		super();
		this.type = type;
		this.radioId = radioId;
		this.seats = seats;
	}
	public String getType() {
		return type;
	}
	public String getRadioId() {
		return radioId;
	}
	public int getSeats() {
		return seats;
	} 
	
	
}
