package com.github.ffops.operations.management;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;

class OperationsResourceIT {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		RestAssured
		.given()
			.baseUri("http://localhost")
			.port(Integer.valueOf(System.getenv("it-backend.port")))
		.when().
			get("resources/operation")
		.then()
			.body("id",Matchers.arrayWithSize(1));

	}

}
