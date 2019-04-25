package com.github.ffops.operations.boundary;

import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

import com.github.ffops.operations.control.UnitReleaseStatusStore;
import com.github.ffops.operations.control.Unmanaged;
import com.github.ffops.operations.entity.Operation;
import com.github.ffops.operations.entity.UnitReleaseStatus;

public class UnitReleaseListener {

	@Inject
	UnitReleaseStatusFactory factory;

	@Inject
	UnitReleaseStatusStore store;

	public void handleIncoming(@ObservesAsync @Unmanaged Operation operation) {

		UnitReleaseStatus status = factory.openUnitReleasePhase(operation);
		store.add(status);

	}
}
