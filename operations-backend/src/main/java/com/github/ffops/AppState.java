package com.github.ffops;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
public class AppState implements HealthCheck{

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.named("operations").up().withData("key", "value").build();
	}

}
