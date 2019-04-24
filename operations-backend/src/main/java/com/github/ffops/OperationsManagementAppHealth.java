package com.github.ffops;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class OperationsManagementAppHealth implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.named("ressources").withData("firemen", "/firemen")
				.withData("operation", "/operation").withData("engines", "/engine")
				.state(checkFiremen() && checkOperation() && checkEngine()).build();
	}

	private boolean checkEngine() {
		// change when something can be tested at startup
		return true;
	}

	private boolean checkOperation() {
		// change when something can be tested at startup
		return true;
	}

	private boolean checkFiremen() {
		// change when something can be tested at startup
		return true;
	}

}
