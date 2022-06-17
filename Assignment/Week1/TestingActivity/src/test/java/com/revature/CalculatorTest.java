package com.revature;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	private static CalTest sut; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception { 
	}

	@Before
	public void setUp() throws Exception {
		sut = new CalTest();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down behavior.");
	}

	@Test
	public void test() {
		int expected = 3; 
		int actual = sut.add(1,2);
		
		assertEquals(expected, actual);
				
	}
	
/*	@Test
	public void test2() {
		
	} */ 

}
