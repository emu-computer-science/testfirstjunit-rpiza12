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
		Date dateC = new Date(2, 28, 2024);
		Date dateD = new Date(2, 29, 2024);
		Date dateE = new Date(3, 1, 2024);
		
		dateA.addOneDay();
		assertEquals(dateB, dateA);
		dateC.addOneDay();
		assertEquals(dateD, dateC);
		dateC.addOneDay();
		assertEquals(dateE, dateC);
	}
	
	@Test
	public void testAddOneDayCrossYear() {
		Date dateA = new Date(12, 31, 2025);
		Date dateB = new Date(1, 1, 2026);
		
		dateA.addOneDay();
		assertEquals(dateB, dateA);
	}
}
