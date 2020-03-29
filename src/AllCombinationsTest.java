import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.*;

class AllCombinationsTest {
	
	@BeforeAll
	public static void prepareTestData() {
		// nominal values from valid & invalid equivalence classes M1, M2, M3, M4, M5, M6
		int[] months = {6, 7, 2, 12, 0, 13};
		
		// nominal values from valid & invalid equivalence classes D1, D2, D3, D4, D5, D6, D7
		int[] days = {14, 28, 29, 30, 31, 0, 32};
		
		// nominal values from valid & invalid equivalence classes Y1, Y2, Y3, Y4, Y5
		int[] years = {2000, 1996, 2002, 1811, 2013};
		
		try {
			File file = new File("src/AllCombinations-Data.csv");
			if (!file.exists()) {
				FileWriter outFile = new FileWriter(file);
		
				for (int i = 0; i < months.length; i++) {
					for (int j = 0; j < days.length; j++) {
						for (int k = 0; k < years.length; k++) {
							String expected = expectedOutput(months[i],days[j],years[k]);
							outFile.write(months[i] + "," + days[j] + "," + years[k] + "," + expected + "\n");
						}
					}
				}
			
				outFile.close();
			}
			
		} catch (Exception ex) {}
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "AllCombinations-Data.csv")
	public void testAll(int month, int day, int year, String expectedResult)
											throws InvalidValueException, InvalidDateException {
		if (expectedResult.equals("InvalidValueException")) {
			assertThrows(InvalidValueException.class, () -> Date.nextDate(month, day, year));
		} else if (expectedResult.equals("InvalidDateException")) {
			assertThrows(InvalidDateException.class, () -> Date.nextDate(month, day, year));
		} else {
			assertEquals(expectedResult,Date.nextDate(month, day, year));
		}
	}
	
	private static String expectedOutput(int month, int day, int year) {
		if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1812 || year > 2012) {
			return "InvalidValueException";
		}
		try {
			GregorianCalendar g = new GregorianCalendar();
			g.setLenient(false);
			g.set(year, month-1, day);
			g.add(Calendar.HOUR, 24);
			return String.format("%02d/%02d/%04d", g.get(Calendar.MONTH)+1,
									g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.YEAR));
		} catch (IllegalArgumentException ex) {
			return "InvalidDateException";
		}
	}

}
