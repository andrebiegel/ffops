package com.github.ffops.operations.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Metered;

import com.github.ffops.operations.control.OperationStore;
import com.github.ffops.operations.control.Unmanaged;
import com.github.ffops.operations.entity.Operation;

@Path("/operation")
@Produces(MediaType.APPLICATION_JSON)
public class OperationsResource {

	@Inject
	@Unmanaged
	Event<Operation> incomingOperation;

	@Inject
	OperationStore store;

	@Inject
	OperationsFactory factory;

	@Resource
	ManagedExecutorService executor;

	@GET
	@Metered
	public CompletionStage<List<Operation>> operations() {
		return CompletableFuture.supplyAsync(store::operations, executor);
	}

	@PUT
	@Metered
	public CompletionStage<Void> add(Operation operation) {
		return this.incomingOperation.fireAsync(factory.initialize(operation), NotificationOptions.ofExecutor(executor))
				.thenAccept(this::storeElement);
	}

	private void storeElement(Operation operation) {
		this.store.store(operation);
	}

}
