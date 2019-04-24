package com.github.ffops.operations.boundary;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import com.github.ffops.operations.entity.Operation;

@ApplicationScoped
public class OperationsFactory {


	private String provideId() {
		return UUID.randomUUID().toString();
	}

	public Operation initialize(Operation operation) {
		operation.setId(provideId());
		return operation;
	}
}
