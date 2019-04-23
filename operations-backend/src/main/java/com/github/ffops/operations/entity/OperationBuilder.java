package com.github.ffops.operations.entity;

import java.time.ZonedDateTime;

public class OperationBuilder {
	private String heading;
	private String alertingMessage;
	private ZonedDateTime start;
	private Integer id;

	public OperationBuilder withHeading(String heading) {
		this.heading = heading;
		return this;
	}

	public OperationBuilder withAlertingMessage(String alertingMessage) {
		this.alertingMessage = alertingMessage;
		return this;
	}

	public OperationBuilder withStart(ZonedDateTime start) {
		this.start = start;
		return this;
	}

	public OperationBuilder withId(Integer id) {
		this.id = id;
		return this;
	}

	public Operation build() {
		return new Operation(heading, alertingMessage, start, id);
	}
	
	public static OperationBuilder operation() {
		return new OperationBuilder();
	}

}