package com.github.ffops.operations.entity;

import java.time.ZonedDateTime;

public class Participation {


	public static Participation createParticipation(String operationId, String personalNumber, ZonedDateTime eta) {
		return new Participation(operationId, personalNumber, eta);
	}
	private String operationId;
	private String personalNumber;
	//estimated time oF arrival
	private ZonedDateTime eta;
	
	
	private Participation(String operationId, String personalNumber, ZonedDateTime eta) {
		super();
		this.operationId = operationId;
		this.personalNumber = personalNumber;
		this.eta = eta;
	}
	public String getPersonalNumber() {
		return personalNumber;
	}
	public ZonedDateTime getEta() {
		return eta;
	}
	public String getOperationId() {
		return operationId;
	}
	
	
}
