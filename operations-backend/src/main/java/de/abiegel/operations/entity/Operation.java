package de.abiegel.operations.entity;

import java.time.ZonedDateTime;

public class Operation {

	private String heading;
	private String alertingMessage;
	private ZonedDateTime start;
	private Integer id;

	Operation(String heading, String alertingMessage, ZonedDateTime start, Integer id) {
		super();
		this.heading = heading;
		this.alertingMessage = alertingMessage;
		this.start = start;
		this.id = id;
	}


}
