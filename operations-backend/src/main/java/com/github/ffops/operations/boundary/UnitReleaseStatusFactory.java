package com.github.ffops.operations.boundary;

import java.util.ArrayList;
import java.util.UUID;

import com.github.ffops.operations.entity.Operation;
import com.github.ffops.operations.entity.Participation;
import com.github.ffops.operations.entity.UnitReleaseStatus;

public class UnitReleaseStatusFactory {

	public UnitReleaseStatus openUnitReleasePhase(Operation operation) {
		return UnitReleaseStatus.createUnitReleaseStatus(UUID.randomUUID().toString(), operation,
				new ArrayList<Participation>());
	}

}
