package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.BankAccount;
 
public class BankAccountTest {  
	BankAccount testAcc = new BankAccount();
	
	@Before
	public void setUp() throws Exception {
		testAcc = new BankAccount(50,1,"12345","Timmy");
				
	}

	@After
	public void tearDown() throws Exception {  
		testAcc = null;
	}
	/**
	 * Tests the calculation of a new balance
	 */
	@Test
	public void testCalcBal() {
		double result = testAcc.calculateTotalBalance();
		assertEquals(50.25,result,.01);
	}
	/** 
	 * Tests whether the interest rates returned are correct for each account type
	 */
	@Test
	public void testIntRate() { 
		double result = testAcc.getInterestRate();
		assertEquals(.5,result,0);
		
		testAcc.setAccountType(2);
		result = testAcc.getInterestRate();
		assertEquals(4.5,result,0);
		
		testAcc.setAccountType(3);
		result = testAcc.getInterestRate();
		assertEquals(1,result,0);
		
		testAcc.setAccountType(4);
		result = testAcc.getInterestRate();
		assertEquals(15,result,0);
	}

}
