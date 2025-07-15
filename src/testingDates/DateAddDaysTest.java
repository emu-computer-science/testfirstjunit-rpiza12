package testingDates;

import buildToTestLab.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateAddDaysTest {
	@Test
	public void testAddOneDaySameMonth() {
		Date dateA = new Date(2, 27, 2025);
		Date dateB = new Date(2, 28, 2024);
		Date dateC = new Date(7, 30, 2025);
		Date dateD = new Date(6, 29, 2025);
		
		dateA.addOneDay();
		dateB.addOneDay();
		dateC.addOneDay();
		dateD.addOneDay();
		
		assertEquals(new Date(2, 28, 2025), dateA);
		assertEquals(new Date(2, 29, 2024), dateB);
		assertEquals(new Date(7, 31,2025), dateC);
		assertEquals(new Date(6, 30, 2025), dateD);
	}
	
	@Test 
	public void testAddOneDayCrossMonth() {
		Date dateA = new Date(7, 31, 2025);
		Date dateB = new Date(2, 28, 2025);
		Date dateC = new Date(2, 29, 2024);
		Date dateD = new Date(7, 31, 2025);
		Date dateE = new Date(6, 30, 2025);
		
		dateA.addOneDay();
		assertEquals(new Date(8, 1, 2025), dateA);
		dateB.addOneDay();
		assertEquals(new Date(3, 1, 2025), dateB);
		dateC.addOneDay();
		assertEquals(new Date(3, 1, 2024), dateC);
		dateD.addOneDay();
		assertEquals(new Date(8, 1, 2025), dateD);
		dateE.addOneDay();
		assertEquals(new Date(7, 1, 2025), dateE);
	}
	
	@Test
	public void testAddOneDayCrossYear() {
		Date dateA = new Date(12, 31, 2025);
		Date dateB = new Date(1, 1, 2026);
		
		dateA.addOneDay();
		assertEquals(dateB, dateA);
	}
}
