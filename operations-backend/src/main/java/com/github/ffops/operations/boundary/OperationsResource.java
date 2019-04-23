package com.github.ffops.operations.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.github.ffops.operations.entity.Operation;

@Path("operation")
public class OperationsResource {
	
	private List<Operation> store = new ArrayList<>();
	
	@GET
	public List<Operation> currentOperations(){
		return store;
	}
	
	@PUT
	public Operation add(Operation operation) {
		operation.setId(Integer.valueOf(42));
		this.store.add(operation);
		return operation;
	}
	
}
