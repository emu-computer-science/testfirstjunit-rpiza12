package testingDates;

import buildToTestLab.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateAddDaysTest {
	@Test
	public void testAddOneDaySameMonth() {
		Date dateA = new Date(7, 12, 2025);
		dateA.addOneDay();
		assertEquals(new Date(7, 13, 2025), dateA);
	}
	
	@Test 
	public void testAddOneDayCrossMonth() {
		Date dateA = new Date(7, 31, 2025);
		Date dateB = new Date(8, 1, 2025);
		
		dateA.addOneDay();
		assertEquals(dateB, dateA);
	}
	
	@Test
	public void testAddOneDayCrossYea() {
		Date dateA = new Date(12, 31, 2025);
		Date dateB = new Date(1, 1, 2026);
		
		dateA.addOneDay();
		assertEquals(dateB, dateA);
	}
}
