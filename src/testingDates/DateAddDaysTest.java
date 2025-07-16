package testingDates;

import buildToTestLab.Date;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class DateAddDaysTest {
	private Date dateA;
	private Date dateB;
	private Date dateC;
	private Date dateD;
	private Date dateE;
	
	@Before
	public void setup () throws Exception {
		dateA = new Date();
		dateB = new Date();
		dateC = new Date();
		dateD = new Date();
		dateE = new Date();		
	}
	
	@Test
	public void testAddOneDaySameMonth() {
		dateA.setDate(2, 27, 2025);
		dateB.setDate(2, 28, 2024);
		dateC.setDate(7, 30, 2025);
		dateD.setDate(6, 29, 2025);
		
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
		dateA.setDate(7, 31, 2025);
		dateB.setDate(2, 28, 2025);
		dateC.setDate(2, 29, 2024);
		dateD.setDate(7, 31, 2025);
		dateE.setDate(6, 30, 2025);
		
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
		dateA.setDate(12, 31, 2025);
		dateB.setDate(1, 1, 2026);
		
		dateA.addOneDay();
		assertEquals(dateB, dateA);
	}
}
