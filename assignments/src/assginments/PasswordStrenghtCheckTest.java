package assginments;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordStrenghtCheckTest {

	@Test
	public void testChecker() {
		
		PasswordStrenghtCheck ps=new PasswordStrenghtCheck();
		String s1="V@ltech123";
		assertEquals("Moderate",ps.checker(s1));
		String s2="V@lte3";
		assertEquals("Weak",ps.checker(s2));
	}
	

}
