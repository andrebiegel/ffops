package com.github.ffops.operations.management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperationsResourceJerseyIT {

	private static Client client;
	private static WebTarget tut;

	@BeforeAll
	public static void  init() {

		client = ClientBuilder.newClient();
		tut = client.target("http:localhost:8080/operations-management/resources/operation");
	}

	/**
	 * Is Empty after startup
	 */
	@Test
	public void getAll() {
		JsonArray elements = this.tut.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		assertEquals(0, elements.size());
	}
}
