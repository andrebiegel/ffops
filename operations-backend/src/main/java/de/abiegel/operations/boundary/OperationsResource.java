package de.abiegel.operations.boundary;

import java.util.List;

import javax.ws.rs.Path;

import de.abiegel.operations.entity.Operation;

@Path("operation")
public class OperationsResource {
	private List<Operation> store;
	
}
