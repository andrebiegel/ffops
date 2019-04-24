package com.github.ffops.engines.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.ffops.engines.entity.Engine;


@Path("/engine")
@Produces(MediaType.APPLICATION_JSON)
public class EngineRessource {

	List<Engine> store = new ArrayList<>();
	
	@GET
	public List<Engine> getAll(){
		
		return store;
	}
	
	@PUT
	public Engine add(Engine engine) {
		this.store.add(engine);
		return engine;
	}

}
