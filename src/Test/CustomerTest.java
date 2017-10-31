/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Customer;

/**
 * @author Bill Feigal 
 *
 */
public class CustomerTest {   

	Customer testCust = new Customer(null, null);
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testCust = new Customer("Timothy", "4795 Anyroad");
		testCust.setCity("Eagan");
		testCust.setState("MN");
		testCust.setZip("55122");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testCust = null;
	}
	/**
	 * Tests the printing of the address to the console
	 */
	@Test
	public void testAddress() {
		String result = testCust.displayAddress();
		System.out.println(result);
		assertEquals("Check that address prints correctly","4795 Anyroad\nEagan, MN 55122", result);
	}
	/**
	 * Tests the printing of the address label to the console
	 */
	@Test
	public void testAddressLabel() {
		String result = testCust.displayAddressLabel();
		System.out.println(result);
		assertEquals("Check that address label prints correctly","Timothy\n4795 Anyroad\nEagan, MN 55122", result);
	}

}
