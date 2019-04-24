package com.github.ffops.operations.entity;

import java.util.List;

import com.github.ffops.engines.entity.RadioStatus;

public class UnitReleaseStatus {

	public static UnitReleaseStatus createUnitReleaseStatus(String id, Operation operation,
			List<Participation> participations) {
		return new UnitReleaseStatus(id, operation, participations);
	}
	private String id; 
	private Operation operation; 
	private List<Participation> participations;
	private List<ReleasedEngine> engines;
	
	private UnitReleaseStatus(String id, Operation operation, List<Participation> participations) {
		super();
		this.id = id;
		this.operation = operation;
		this.participations = participations;
	}

	public void participate(Participation participation) {
		this.participations.add(participation);
	}

	
	
	public List<ReleasedEngine> getEngines() {
		return engines;
	}
	public String getId() {
		return id;
	}
	
	public Operation getOperation() {
		return operation;
	}
	public List<Participation> getParticipations() {
		return participations;
	}

	public void releaseEngine(String radioId) {
		this.engines.add(ReleasedEngine.createReleasedEngine(radioId, RadioStatus.ACCEPTED));
	} 
	
	
}
