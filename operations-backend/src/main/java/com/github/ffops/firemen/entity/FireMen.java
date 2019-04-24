package com.github.ffops.firemen.entity;

public class FireMen {

	public static FireMen createFireMen(String name, String id, boolean groupleader, boolean scba) {
		return new FireMen(name, id, groupleader, scba);
	}
	private String name; 
	private String personalNumber; 
	private boolean groupleader; 
	//can he use self-contained breathing apparatus at the moment ? 
	private boolean scba;
	
	public String getName() {
		return name;
	}
	public String getId() {
		return personalNumber;
	}
	public boolean isGroupleader() {
		return groupleader;
	}
	public boolean isScba() {
		return scba;
	}
	private FireMen(String name, String id, boolean groupleader, boolean scba) {
		super();
		this.name = name;
		this.personalNumber = id;
		this.groupleader = groupleader;
		this.scba = scba;
	}
	
	
}
