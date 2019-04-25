package com.github.ffops.firemen.boundary;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.github.ffops.firemen.control.FireMenStore;
import com.github.ffops.firemen.entity.FireMen;

@ApplicationScoped
public class FireMenFactory {

	@Inject
	@ConfigProperty(name = "firemen.personalNumber.separator", defaultValue = "-")
	String ID_SEPARATOR = "-";

	@Inject
	@ConfigProperty(name = "firemen.station.id", defaultValue = "21")
	String personalNrPrefix;

	@Inject
	FireMenStore firemenStore;

	private String provideId() {
		return personalNrPrefix + ID_SEPARATOR + firemenStore.amount();
	}

	public FireMen initialize(FireMen collegue) {
		return FireMen.createFireMen(collegue.getName(), provideId(), collegue.isGroupleader(), collegue.isScba());
	}
}
