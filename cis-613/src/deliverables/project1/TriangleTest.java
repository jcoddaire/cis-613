package deliverables.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import java.util.*;

class TriangleTest {
	
	@ParameterizedTest
	@MethodSource({"dataProviderForAllTestCases"})
	void testAll(int a, int b, int c, String expectedResult) throws InvalidValueException {
		
		// COMPLETE THIS METHOD		
		
		// First determine if the parameters are a valid triangle.
		boolean c1 = 1 <= a && a <= 200;
		boolean c2 = 1 <= b && b <= 200;
		boolean c3 = 1 <= c && c <= 200;
		
		// if the parameters are not valid, check for an exception to be thrown.
		if(!(c1 && c2 && c3)) {
			assertThrows(InvalidValueException.class,() -> Triangle.type(a, b, c));
		}
		// if the parameters are valid, see if we get the correct triangle type.
		else {
			// 
			assertEquals(expectedResult, Triangle.type(a, b, c));	
		}
	}
	
	static Stream<Arguments> dataProviderForAllTestCases() {
		Integer[] values = {0, 1, 2, 100, 199, 200, 201};
		
		ArrayList<Arguments> argsList = new ArrayList<Arguments>();
		
		//
		// COMPLETE THIS SECTION OF METHOD
		//		
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				for (int k = 0; k < values.length; k++) {
					
					String triangleType;
					if(!((i < j + k) && (j < i + k) && (k < i + j))) {
						triangleType = "NotATriangle";
					}
					else {
						if (i == j && j == k) {
							triangleType = "Equilateral";
						} else if (i != j && i != k && j != k) {
							triangleType = "Scalene";
						} else {
							triangleType = "Isosceles";
						}
					}
					
					argsList.add(arguments(values[i],values[j], values[k], triangleType));
				}
			}
		}
		
		Arguments[] args = argsList.toArray(new Arguments[argsList.size()]);
		return Stream.of(args);
	}
	
}
