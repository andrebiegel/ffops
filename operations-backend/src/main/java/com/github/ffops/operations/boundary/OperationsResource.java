package com.github.ffops.operations.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.annotation.Resource;
import javax.annotation.processing.Completion;
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

import com.github.ffops.operations.entity.Operation;

@Path("operation")
@Produces(MediaType.APPLICATION_JSON)
public class OperationsResource {
	
	private List<Operation> store = new ArrayList<>();
	
	@Inject
	Event<String> incomingOperation; 
	
	@Resource
	ManagedExecutorService executor; 
	
	@GET
	@Metered
	public List<Operation> currentOperations(){
		return store;
	}
	
	@PUT
	@Metered
	
	public CompletionStage<Operation> add(Operation operation) {
		return null;
		//return this.incomingOperation.fireAsync("42", NotificationOptions.ofExecutor(executor)).thenAccept(id -> storeElement (id,operation));
	}

	private Operation storeElement(String id, Operation operation) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
