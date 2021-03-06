package junit.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("JUnit 5 Demo - Parameterized Tests")
class JUnitDemo4 {
		
	@ParameterizedTest
	@CsvSource({"5,10","10,10","5,0","5,5","10,-5"})
	void tests_for_add(int a, int b) {
		Calculator calc = new Calculator();
		assertEquals(a+b, calc.add(a, b));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "data.txt")
	void tests_for_mult(int a, int b) {
		Calculator calc = new Calculator();
		assertEquals(a*b, calc.mul(a, b));
	}
	
	@ParameterizedTest
	@MethodSource({"dataProvider1"})
	void tests_for_sub1(int a, int b) {
		Calculator calc = new Calculator();
		assertEquals(a-b, calc.sub(a, b));
	}
	
	// data provider for test method tests_for_sub1
	static Stream<Arguments> dataProvider1() {
		return Stream.of(
			arguments(5,10),
			arguments(10,10),
			arguments(5,0),
			arguments(10,-5)
		);
	}
	
	@ParameterizedTest
	@MethodSource({"dataProvider2"})
	void tests_for_sub2(int a, int b) {
		Calculator calc = new Calculator();
		assertEquals(a-b, calc.sub(a, b));
	}
	
	// data provider for test method tests_for_sub2
	static Stream<Arguments> dataProvider2() {
		int[] set1 = {5,10,15};
		int[] set2 = {20,30,35,40};
		
		ArrayList<Arguments> argsList = new ArrayList<Arguments>();
		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				argsList.add(arguments(set1[i],set2[j]));
			}
		}
		
		Arguments[] args = argsList.toArray(new Arguments[argsList.size()]);
		return Stream.of(args);
	}
}
