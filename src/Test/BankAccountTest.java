package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Core_Week_3.BankAccount;
 
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

	@Test
	public void testCalcBal() {
		double result = testAcc.calculateTotalBalance();
		assertEquals(50.25,result,.01);
	}
	@Test
	public void testIntRate() { 
		double result = testAcc.getInterestRate();
		assertEquals(.5,result,0);
	}

}
