package itemTests;

import static org.junit.Assert.*;
import org.junit.Test;

import itemSrc.*;
/**
 *  a JUnit test class for the CustInQueue class
 * @author John Kanyaru
 *
 */
public class CustInQueueTest {

	/**
	 * The constructor is tested below
	 * You are to implement this constructor
	 */
	@Test
	public void testCustInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		assertSame(cinqueue.getName(),"Andrew");
		assertEquals(cinqueue.getpId(),"px34");
		
	}
/**
 * tested alongside the constructor
 * You are to implement this method
 */
	@Test
	public void testGetName() {
		
	}
	/**
	 * this is to test whether the name value can be changed
	 * You are to implement this method
	 */
	@Test
	public void testSetName() {
		CustInQueue cinqueue = new CustInQueue("Meg", "px34");
		cinqueue.setName("Meg");
		assertSame(cinqueue.getName(),"Meg"); //if you test with the old name Andrew, it will fail the test
		assertEquals(cinqueue.getpId(),"px34");//this was not changed in the setName method
		
	}
/**
 * tested alongside the constructor- no need to repeat it here
 * You are to implement this method
 */
	@Test
	public void testGetpId() {
		
	}
/**
 * This tests whether the value of the product id can be changed
 * You are to implement this method
 */
	@Test
	public void testSetpId() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "pt35");
	    cinqueue.setpId("pt35");
		assertEquals(cinqueue.getpId(),"pt35");
	}
/**
 * The implementation of this method is provided.
 * Write tests for this method
 */
	@Test
	public void testGetqNum() {
		
	}
/**
 * this tests whether the value of a customer's queue number can be changed
 * You are to implement this method
 */
	@Test
	public void testSetqNum() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		cinqueue.setqNum(1);
		assertTrue(cinqueue.getqNum()==1);
		
	}
/**
 * This tests whether the customer is in queue being processed
 * You are to provide an implemented of 
 */
	@Test
	public void testIsInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		assertFalse(cinqueue.isInQueue()!=false);
	}
/**
 * this tests whether a customer can be placed or removed from the 
 * queue by setting inqueue flag to true or false
 * You are to implement this method
 */
	@Test
	public void testSetInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		cinqueue.setInQueue(true);
		assertFalse(cinqueue.isInQueue()==false);
	}

}
