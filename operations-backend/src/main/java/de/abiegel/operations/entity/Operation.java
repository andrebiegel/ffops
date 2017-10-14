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

	public static class OperationBuilder {
		public static class OperationBuilderData {
			public String heading;
			public String alertingMessage;
			public ZonedDateTime start;
			public Integer id;

			public OperationBuilderData() {
			}
		}

		private OperationBuilderData data = new OperationBuilderData();

		public OperationBuilder withHeading(String heading) {
			this.data.heading = heading;
			return this;
		}

		public OperationBuilder withAlertingMessage(String alertingMessage) {
			this.data.alertingMessage = alertingMessage;
			return this;
		}

		public OperationBuilder withStart(ZonedDateTime start) {
			this.data.start = start;
			return this;
		}

		public OperationBuilder withId(Integer id) {
			this.data.id = id;
			return this;
		}

		public Operation build() {
			return new Operation(data.heading, data.alertingMessage, data.start, data.id);
		}
	}

	public static OperationBuilder operation() {
		return new OperationBuilder();
	}

}
