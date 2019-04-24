package com.github.ffops.operations.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.annotation.Gauge;

import com.github.ffops.operations.entity.Operation;

@ApplicationScoped
public class OperationStore {

	private List<Operation> store;
	
	@PostConstruct
	public void init() {
		store = new ArrayList<>();
	}
	
	@CircuitBreaker (failOn = IOException.class)
	@Bulkhead
	@Fallback(fallbackMethod = "storeFallback")
	@Retry(maxRetries = 3)
	public void store (Operation op) {
		this.store.add(op);
	}

	public void storeFallback(Operation op) {
		this.store.add(op);
	}
	@Gauge(unit = "count")
	public int amount () {
		return this.store.size();
	}

	public List<Operation> operations() {
		return store;
	}
}
