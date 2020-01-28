package deliverables.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import java.util.*;

class DateTest {

	@ParameterizedTest
	@MethodSource({"dataProviderForAllTestCases"})
	void testAll(int month, int day, int year, String expectedResult)
											throws InvalidValueException, InvalidDateException {
		
		// COMPLETE THIS METHOD
		
	}
	
	static Stream<Arguments> dataProviderForAllTestCases() {
		int[] months = {0, 1, 2, 6, 11, 12, 13};
		int[] days = {0, 1, 2, 15, 30, 31, 32};
		int[] years = {1811, 1812, 1813, 1912, 2011, 2012, 2013};
		
		ArrayList<Arguments> argsList = new ArrayList<Arguments>();
		
		//
		// COMPLETE THIS SECTION OF METHOD
		//
		
		Arguments[] args = argsList.toArray(new Arguments[argsList.size()]);
		return Stream.of(args);
	}
	
	private static String expectedOutput(int month, int day, int year) {
		if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1812 || year > 2012) {
			return "InvalidValueException";
		}
		try {
			GregorianCalendar g = new GregorianCalendar();
			g.setLenient(false);
			
			//
			// TO DO:
			//		use set() and add() methods of GregorianCalendar class to
			//		the set the date information and then advance it by 24 hours
			//		to go to next date
			//
			//		construct string representation of object g in format "MM/DD/YYYY"
			//
			
			return "";	// replace this with the string constructed above
			
		} catch (IllegalArgumentException ex) {
			return "InvalidDateException";
		}
	}

}
