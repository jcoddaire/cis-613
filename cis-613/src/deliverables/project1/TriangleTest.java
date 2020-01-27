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
		
	}
	
	static Stream<Arguments> dataProviderForAllTestCases() {
		Integer[] values = {0, 1, 2, 100, 199, 200, 201};
		
		ArrayList<Arguments> argsList = new ArrayList<Arguments>();
		
		//
		// COMPLETE THIS SECTION OF METHOD
		//
		
		Arguments[] args = argsList.toArray(new Arguments[argsList.size()]);
		return Stream.of(args);
	}
	
}
