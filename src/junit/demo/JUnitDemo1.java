package junit.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("JUnit 5 Demo - Basic Tests")
class JUnitDemo1 {
	
	@BeforeAll
	static void beforeAllMethod() {
		// code in this method is run only once before any of the test methods
	}

	@BeforeEach
	void beforeEachMethod() {
		// code in this method is run before each test method
	}
	
	@Test
	@DisplayName("Test for add method")
	void testAdd() {
		Calculator calc = new Calculator();
		int x = 10;
		int y = 15;
		int expected =  x + y;
		assertEquals(expected, calc.add(x,y));
	}
	
	@Test
	void test_sub() {
		Calculator calc = new Calculator();
		int x = 10;
		int y = 15;
		int expected =  x - y;
		assertEquals(expected, calc.sub(x,y));
	}

	@Test
	void test_mul() {
		Calculator calc = new Calculator();
		int x = 10;
		int y = 15;
		int expected =  x * y;
		assertEquals(expected, calc.mul(x,y));
	}
	
	@Test
	void test_div() {
		Calculator calc = new Calculator();
		int x = 10;
		int y = 15;
		int expected =  x / y;
		assertEquals(expected, calc.div(x,y));
	}
	
	@Test
	@Disabled("Place reason for disabling this test here")
	void test_xyz() {
		// TO DO: When the code to test is ready
	}
	
 	@AfterEach
	void afterEachMethod() {
		// code in this method is run after each test method
	}
	
	@AfterAll
	static void afterAllMethod() {
		// code in this method is run only once after all of the test methods
	}

}
