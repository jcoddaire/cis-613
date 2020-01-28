package junit.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static java.time.Duration.*;

@DisplayName("JUnit 5 Demo - Exceptions, Timeout, Repeated Tests")
class JUnitDemo2 {
		
	@Test
	void test_exception1() {
		String s = "John";
		assertThrows(StringIndexOutOfBoundsException.class,() -> s.charAt(4));
	}
	
	@Test
	void test_exception2() {
		String s = "John";
		assertThrows(IndexOutOfBoundsException.class,() -> s.charAt(4));
	}
	
	@Test
	void test_exception3() {
		assertThrows(NumberFormatException.class,() -> Integer.parseInt("123"));
	}
	
	@Test
	void test_exception4() {
		assertThrows(NumberFormatException.class,() -> Integer.parseInt("one"));
	}
	
	@Test
	void test_timing1() {
		assertTimeout(ofMillis(10), Calculator::sayHello);
	}
	
	@Test
	void test_timing2() {
		Calculator calc = new Calculator();
		assertTimeout(ofMillis(10), calc::sayBye);
	}
	
	@Test
	void test_timing3() {
		assertTimeout(ofMillis(10), () -> { Thread.sleep(15); });
	}
	
	// useful in integration/functional/acceptance testing environments
	@RepeatedTest(5)
	void test_repeated() {
		assertEquals(5,5);
	}	
	
}
