import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AllPairsTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "AllPairs-Data.csv")
	public void testAll(int month, int day, int year, String expectedResult) {
		// Test assertions using a different approach
		try {
			assertEquals(expectedResult,Date.nextDate(month, day, year));
		} catch (InvalidValueException ive) {
			assertEquals(expectedResult,ive.getClass().getName());
		} catch (InvalidDateException ide) {
			assertEquals(expectedResult,ide.getClass().getName());
		} catch (Exception ex) {
			fail(ex.getClass().getName() + " is not an expected exception!");
		}
	}

}
