package deliverables.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;
import java.util.*;

class DateTest {

	@ParameterizedTest
	@MethodSource({"dataProviderForAllTestCases"})
	void testAll(int month, int day, int year, String expectedResult)
											throws InvalidValueException, InvalidDateException {
		
		// COMPLETE THIS METHOD

		if(expectedResult.equals("InvalidValueException")) {
			assertThrows(InvalidValueException.class,() -> Date.nextDate(month, day, year));
		}
		else if(expectedResult.equals("InvalidDateException")) {
			assertThrows(InvalidDateException.class,() -> Date.nextDate(month, day, year));
		}
		else {
			assertEquals(expectedResult, Date.nextDate(month, day, year));
		}
	}
	
	static Stream<Arguments> dataProviderForAllTestCases() {
		int[] months = {0, 1, 2, 6, 11, 12, 13};
		int[] days = {0, 1, 2, 15, 30, 31, 32};
		int[] years = {1811, 1812, 1813, 1912, 2011, 2012, 2013};
		
		ArrayList<Arguments> argsList = new ArrayList<Arguments>();
		
		//
		// COMPLETE THIS SECTION OF METHOD
		//

		for (int i = 0; i < months.length; i++) {
			for (int j = 0; j < days.length; j++) {
				for (int k = 0; k < years.length; k++) {

					int a = months[i];
					int b = days[j];
					int c = years[k];

					String expectedNextDate = expectedOutput(a, b, c);

					argsList.add(arguments(a, b, c, expectedNextDate));
				}
			}
		}
		
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

			g.set(Calendar.YEAR, year);
			g.set(Calendar.MONTH, month - 1);
			g.set(Calendar.DAY_OF_MONTH, day);

			g.add(GregorianCalendar.DAY_OF_YEAR, 1);

			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

			return formatter.format(g.getTime());

		} catch (IllegalArgumentException ex) {
			return "InvalidDateException";
		}
	}

}
