package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.database.DatabaseConnection;

class ManagerLoginTest {

	private static DatabaseConnection sut; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sut = new DatabaseConnection(); 
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

	//Test to Login
	/*
	 * @Test void Lognintest() {
	 * 
	 * //String username = "Jairus"; //String password = "password";
	 * 
	 * sut.RetrieveUserInfo();
	 * 
	 * //String result = "Proceeding to Manager Menu";
	 * //fail("Not yet implemented"); }
	 */
	
	/*
	 * @Test void transactionTest() {
	 * 
	 * sut.ViewTransaction();
	 * 
	 * }
	 */
	//Test for new user creation 
	@Test
	void newUserTest() {
		String ExampleName = "Example";
		String ExamplePass = "ExamplePass";
		String Type = "customer"; 
		
		sut.newUserCreation(ExampleName, ExamplePass, Type);
	}
	
	/*
	 * @Test void makeOfferTest() {
	 * 
	 * sut.MakeOffer();
	 * 
	 * }
	 */

}
