package testingDates;

import buildToTestLab.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateSetDateTest {
	@Test
	public void testSetDate() { // (String, int, int)
		Date dateA = new Date(7, 21, 2025);
		dateA.setDate("July", 14, 2025);
		
		Date dateB = new Date(7, 21, 2025);
		dateB.setDate("bubbles", 14, 2025);
		
		Date dateC = new Date(7, 27, 2025);
		dateC.setDate("july", 14, 2025);
		
		assertEquals(new Date("July", 14, 2025), dateA);
		assertEquals(new Date("July", 21, 2025), dateB);
		assertEquals(new Date("July", 27, 2025), dateC);
	}
}
