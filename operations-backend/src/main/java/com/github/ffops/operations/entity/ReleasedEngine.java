package com.github.ffops.operations.entity;

import java.util.ArrayList;
import java.util.List;

import com.github.ffops.engines.entity.RadioStatus;

public class ReleasedEngine {

	public static ReleasedEngine createReleasedEngine(String radioId, RadioStatus radioStatus) {
		return new ReleasedEngine(radioId, radioStatus, new ArrayList<ReleasedFireMen>());
	}

	public static ReleasedEngine createReleasedEngine(String radioId, RadioStatus radioStatus,
			List<ReleasedFireMen> crew) {
		return new ReleasedEngine(radioId, radioStatus, crew);
	}

	private String radioId;
	private RadioStatus radioStatus;
	private List<ReleasedFireMen> crew;

	private ReleasedEngine(String radioId, RadioStatus radioStatus, List<ReleasedFireMen> crew) {
		super();
		this.radioId = radioId;
		this.radioStatus = radioStatus;
		this.crew = crew;
	}

	public String getRadioId() {
		return radioId;
	}

	public RadioStatus getRadioStatus() {
		return radioStatus;
	}

	public List<ReleasedFireMen> getCrew() {
		return crew;
	}

}
