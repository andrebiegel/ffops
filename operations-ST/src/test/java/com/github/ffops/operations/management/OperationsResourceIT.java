package com.github.ffops.operations.management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperationsResourceIT {

	private Client client;
	private WebTarget tut;

	@BeforeAll
	public void init() {

		this.client = ClientBuilder.newClient();
		this.tut = this.client.target("http:localhost:8080/");
	}

	@Test
	public void getAll() {
		JsonArray elements = this.tut.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		assertEquals(0, elements.size());
	}
}