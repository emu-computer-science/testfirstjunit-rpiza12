package testingDates;

import buildToTestLab.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateAddDaysTest {
	@Test
	public void testAddOneDaySameMonth() {
		Date dateA = new Date(7, 31, 2025);
		Date dateB = new Date(2, 29, 2024);
		Date dateC = new Date(2, 28, 2024);
		Date dateD = new Date(7, 30, 2025);
		Date dateE = new Date(12, 31, 2025);
		Date dateF = new Date(6, 30, 2025);
		
		dateA.addOneDay();
		dateB.addOneDay();
		dateC.addOneDay();
		dateD.addOneDay();
		dateE.addOneDay();
		dateF.addOneDay();
		
		assertEquals(new Date(8, 1, 2025), dateA);
		assertEquals(new Date(3, 1, 2024), dateB);
		assertEquals(new Date(2, 29, 2024), dateC);
		assertEquals(new Date(7, 31, 2025), dateD);
		assertEquals(new Date(1, 1, 2025), dateE);
		assertEquals(new Date(7, 1, 2025), dateF);
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
