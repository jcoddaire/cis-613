package deliverables.project2;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import deliverables.project1.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

				ArrayList<String> argsList = new ArrayList<String>();

				for (int i = 0; i < months.length; i++) {
					for (int j = 0; j < days.length; j++) {
						for (int k = 0; k < years.length; k++) {

							int a = months[i];
							int b = days[j];
							int c = years[k];

							String expectedNextDate = expectedOutput(a, b, c);

							// write to a comma delimited string.
							// note that this will NOT be rfc4180 compliant (https://tools.ietf.org/html/rfc4180),
							// but it will work under these very tight test scenarios.
							// The correct way to do this is to use a library, but the
							// instructions require only this single .java file be submitted,
							// not any dependencies.
							argsList.add(a + "," + b+ "," + c+ "," + expectedNextDate);
						}
					}
				}

				// write argsList to CSV.
				try (PrintWriter csvWriter = new PrintWriter(new FileWriter(file));){
					for(String item : argsList){
						csvWriter.println(item);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
		} catch (Exception ex) {}
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "ECT-Data.csv")
	void testAll(int month, int day, int year, String expectedResult)
			throws deliverables.project2.InvalidValueException, deliverables.project2.InvalidDateException {

		if(expectedResult.equals("InvalidValueException")) {
			assertThrows(deliverables.project1.InvalidValueException.class,() -> deliverables.project1.Date.nextDate(month, day, year));
		}
		else if(expectedResult.equals("InvalidDateException")) {
			assertThrows(deliverables.project1.InvalidDateException.class,() -> deliverables.project1.Date.nextDate(month, day, year));
		}
		else {
			assertEquals(expectedResult, deliverables.project2.Date.nextDate(month, day, year));
		}
	}
	
	private static String expectedOutput(int month, int day, int year) {
		if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1812 || year > 2012) {
			return "InvalidValueException";
		}
		try {
			GregorianCalendar g = new GregorianCalendar();
			g.setLenient(false);

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
