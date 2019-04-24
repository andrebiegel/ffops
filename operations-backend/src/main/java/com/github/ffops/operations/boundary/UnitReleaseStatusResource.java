package com.github.ffops.operations.boundary;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.Metered;

import com.github.ffops.operations.control.UnitReleaseStatusStore;
import com.github.ffops.operations.entity.Participation;
import com.github.ffops.operations.entity.UnitReleaseStatus;

@Path("/releaseStatus")
@Produces(MediaType.APPLICATION_JSON)
public class UnitReleaseStatusResource {

	@Inject
	UnitReleaseStatusStore store;

	@Resource
	ManagedExecutorService executor;

	@Inject
	MetricRegistry metricRegistry;
	
	@GET
	@Metered
	public CompletionStage<List<UnitReleaseStatus>> openOperations() {
		return supplyAsync(this.store::alarms,executor);
	}

	@PUT
	@Path("participate/{releasestatusId}")
	public CompletionStage<Void> reportParticipation(@PathParam("releasestatusId") String releasestatusId,
			Participation participationReport) {
		metricRegistry.counter("operation_particpations_" + releasestatusId).inc();
		return CompletableFuture.supplyAsync(() -> this.store.fetchById(releasestatusId), executor)
				.thenAccept(status -> status.participate(participationReport));
	}
	
	
	@PUT
	@Path("release/{releasestatusId}/{radio-id}")
	public CompletionStage<Void> releaseWithEngine(@PathParam("releasestatusId") String releasestatusId,
			@PathParam("radio-id") String radioId) {
		metricRegistry.counter("operation_released_engine_" + radioId).inc();
		return CompletableFuture.supplyAsync(() -> this.store.fetchById(releasestatusId), executor)
				.thenAccept(status -> status.releaseEngine(radioId));
	}


}
