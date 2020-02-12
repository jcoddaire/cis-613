package deliverables.project2;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.*;

class DateTest {
	
	@BeforeAll
	static void prepareTestData() {
		int[] months = {0, 2, 6, 7, 12, 13};
		int[] days = {0, 14, 28, 29, 30, 31, 32};
		int[] years = {1811, 1996, 2000, 2002, 2013};
		
		try {
			File file = new File("src/ECT-Data.csv");
			if (!file.exists()) {
				// TO DO: create the comma delimited data file: month,day,year,expectedoutput
			}
			
		} catch (Exception ex) {}
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "ECT-Data.csv")
	void testAll(int month, int day, int year, String expectedResult)
											throws InvalidValueException, InvalidDateException {
		// TO DO: Same as in Project 1
	}
	
	private static String expectedOutput(int month, int day, int year) {
		if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1812 || year > 2012) {
			return "InvalidValueException";
		}
		try {
			GregorianCalendar g = new GregorianCalendar();
			g.setLenient(false);

			// TO DO: Same as in Project 1
			
			return "";
			
		} catch (IllegalArgumentException ex) {
			return "InvalidDateException";
		}
	}

}
