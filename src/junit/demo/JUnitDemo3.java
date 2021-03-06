package junit.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.*;

@DisplayName("JUnit 5 Demo - Assumptions and Conditional Testing")
class JUnitDemo3 {
			
	@Test
	@EnabledOnOs(value = { LINUX, MAC })
	void testOnCondition1() {
		Calculator calc = new Calculator();
		assertEquals(10,calc.add(-5,15));
	}
	
	@Test
	@EnabledOnOs(value = { WINDOWS })
	void testOnCondition2() {
		Calculator calc = new Calculator();
		assertEquals(10,calc.add(-5,15));
	}
	
	@Test
	void testOnAssumption1() {
		assumeTrue("john".equalsIgnoreCase("JOHN"));
		Calculator calc = new Calculator();
		assertEquals(10,calc.add(-5,15));
	}
	
	@Test
	void testOnAssumption2() {
		assumeTrue("john".equals("jane"));
		Calculator calc = new Calculator();
		assertEquals(10,calc.add(-5,15));
	}
	
}
