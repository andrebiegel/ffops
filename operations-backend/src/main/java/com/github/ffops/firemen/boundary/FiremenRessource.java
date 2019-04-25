package com.github.ffops.firemen.boundary;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.ffops.firemen.control.FireMenStore;
import com.github.ffops.firemen.entity.FireMen;

@Path("/firemen")
@Produces(MediaType.APPLICATION_JSON)
public class FiremenRessource {

	@Inject
	FireMenFactory factory;

	@Inject
	FireMenStore store;

	@Resource
	ManagedExecutorService executor;

	/**
	 * Returns all existent firemen
	 * 
	 */
	@GET
	public CompletionStage<List<FireMen>> firemens() {
		return CompletableFuture.supplyAsync(this.store::firemens, executor);
	}

	@POST
	public FireMen add(FireMen collegue) {
		FireMen initalized = factory.initialize(collegue);
		store.add(initalized);
		return initalized;
	}
}
