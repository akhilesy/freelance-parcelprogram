package itemTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itemSrc.*;

public class QueueOfCustsTest {

	QueueOfCusts qOfCusts;

	/*
	 * The constructor is tested below You are to implement this constructor
	 */
	@Test
	public void testQueueOfCusts() {
		qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing() == 0);
	}

	/*
	 * a test to show that you can add customers to the queue You are to implement
	 * this method
	 */
	@Test
	public void testAddDetails() {
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		assertSame(qOfCusts.get(0), cinqueue);

	}

	/*
	 * a test to show that the count of customers changes when a customer is added
	 * to the queue You are to implement this method
	 */
	@Test
	public void testGetNumberOfEntries() {
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		assertTrue(qOfCusts.getNumberOfEntries() == 1);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		assertTrue(qOfCusts.getNumberOfEntries() == 2);
	}

	/*
	 * a test method to check how many customers have been added to the queue You
	 * are to implement this method
	 */
	@Test
	public void testGetNumQueueing() {
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNumQueueing() == 1);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNumQueueing() == 2);

	}

	/*
	 * a method to test that a customer in a specific location in the collection can
	 * be obtained You are to implement this method
	 */
	@Test
	public void testGet() {
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		System.out.println(qOfCusts.get(0).equals(cinqueue));
		assertSame(qOfCusts.get(0), cinqueue);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.get(1), cinqueue2);

	}

	/*
	 * a method to test that you can find the next customer in the queue. You are to
	 * implement this method
	 * 
	 */
	@Test
	public void testGetNext() {
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertSame(qOfCusts.getNext(), cinqueue);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.getNext(), cinqueue2);
	}


	
	/*
	 * test case written for below  --
	 * A method that return the String value of an object
	 */
	@Test
	public void testGetQueueString() {
		qOfCusts = new QueueOfCusts();

		CustInQueue p2 = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(p2);
		qOfCusts.addToQueue();
		String details[] = qOfCusts.getQueueString().split(",");
		assertTrue(details.length == 4);

	}

	/*
	 * 
	 * test case written below --
	 * A method that mark the all object is inQueue;
	 */
	@Test
	public void testAddToQueue() {
		qOfCusts = new QueueOfCusts();
        CustInQueue p1 = new CustInQueue("Andrew", "px34");
		CustInQueue p2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(p1);
		qOfCusts.addToQueue();
        qOfCusts.addDetails(p2);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNext().isInQueue() == true);
		
		
	}

}
