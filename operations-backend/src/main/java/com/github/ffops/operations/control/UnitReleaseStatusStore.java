package com.github.ffops.operations.control;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response.Status;

import com.github.ffops.operations.entity.UnitReleaseStatus;

@ApplicationScoped
public class UnitReleaseStatusStore {

	private List<UnitReleaseStatus> store;
	
	@PostConstruct
	public void init() {
		store = new ArrayList<>();
	}

	public void add(UnitReleaseStatus status) {
			this.store.add(status);
	}

	public List<UnitReleaseStatus> alarms() {
		return store;
	}

	public UnitReleaseStatus fetchById(String releasestatusId) {
		UnitReleaseStatus status = this.store.stream().filter(it -> it.getOperation().getId().equalsIgnoreCase(releasestatusId)).findFirst().orElseThrow(this::notFound);
		return status;
	}
	
	private NotFoundException notFound() {
		return new NotFoundException("Alarm not Found");
	}
}
