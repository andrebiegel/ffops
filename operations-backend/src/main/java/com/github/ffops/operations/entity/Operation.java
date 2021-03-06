package com.github.ffops.operations.entity;

import java.time.ZonedDateTime;

import javax.json.bind.annotation.JsonbProperty;

public class Operation {

	private String heading;
	@JsonbProperty("message")
	private String alertingMessage;
	private ZonedDateTime start;
	private String id;

	Operation(String heading, String alertingMessage, ZonedDateTime start, String id) {
		super();
		this.heading = heading;
		this.alertingMessage = alertingMessage;
		this.start = start;
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getAlertingMessage() {
		return alertingMessage;
	}

	public void setAlertingMessage(String alertingMessage) {
		this.alertingMessage = alertingMessage;
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
