package testingDates;

import buildToTestLab.Date;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class DateSetDateTest {
	private Date dateA;
	private Date dateB;
	private Date dateC;
	
	@Before
	public void setUp() throws Exception{
		dateA = new Date(7, 21, 2025);
		dateB = new Date(7, 21, 2025);
		dateC = new Date(7, 27, 2025);
	}
	
	// testing setDate(String, int, int)
	@Test
	public void testSetDate() { // 
		dateA.setDate("July", 14, 2025);
		dateB.setDate("bubbles", 14, 2025);
		dateC.setDate("july", 14, 2025);
		
		assertEquals(new Date("July", 14, 2025), dateA);
		assertEquals(new Date("July", 21, 2025), dateB);
		assertEquals(new Date("July", 27, 2025), dateC);
	}
}
