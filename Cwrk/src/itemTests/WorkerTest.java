package itemTests;

import static org.junit.Assert.*;

import org.junit.*;

import itemSrc.*;

public class WorkerTest {

	Worker wareHouseWorker;

	/**
	 * This tests the Worker constructor You are to implement this constructor
	 */
	@Test
	public void testWorker() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing() == 0);
		CustInQueue cin = new CustInQueue("Andrew", "px21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");

		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();

		ParcelMap parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);

		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p);
		parcelList.addDetails(p2);
		wareHouseWorker = new Worker(qOfCusts, parcelList, 5, 4);

		assertTrue(wareHouseWorker.getNum() == 4);
		assertEquals(wareHouseWorker.getNext().getName(), "Andrew");
		wareHouseWorker.setClosed();
		assertEquals(wareHouseWorker.getNext().getName(), "Janice");
	}

	/*
	 * This tests whether the current customer can be obtained You are to implement
	 * this method
	 * 
	 * 
	 */
	@Test
	public void testGetCurrentCust() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing() == 0);
		CustInQueue cin = new CustInQueue("Andrew", "px21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");

		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		
		  qOfCusts.addDetails(cin2);
		  qOfCusts.addToQueue();
		 

		ParcelMap parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);

		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p);
		parcelList.addDetails(p2);

		wareHouseWorker = new Worker(qOfCusts, parcelList, 5, 4);
		assertEquals(qOfCusts.getNext(), cin);
		wareHouseWorker.setClosed();
		
		
		assertEquals(qOfCusts.getNext(), cin2);
	}

	/**
	 * This has already been tested with the constructor Implementation is provided
	 */
	@Test
	public void testGetNum() {
		
	}

	/**
	 * This tests whether a worker has closed processing a customer's job Provide an
	 * implementation of this method
	 */
	@Test
	public void testGetClosed() {
		QueueOfCusts qOfCusts = new QueueOfCusts();

		CustInQueue cin = new CustInQueue("Andrew", "px21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");

		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		
		  qOfCusts.addDetails(cin2);
		  qOfCusts.addToQueue();
		 

		ParcelMap parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);

		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p);
		parcelList.addDetails(p2);

		wareHouseWorker = new Worker(qOfCusts, parcelList, 5, 4);
		assertEquals(qOfCusts.getNext(), cin);
		wareHouseWorker.setClosed();
	
		assertFalse(wareHouseWorker.getCurrentCust() == cin);
		assertFalse(wareHouseWorker.getCurrentCust() == cin2);
	}

	/**
	 * this has been tested alongside the getClosed method Provide an implementation
	 * for this method
	 */
	@Test
	public void testSetClosed() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing() == 0);
		CustInQueue cin = new CustInQueue("Andrew", "px21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");

		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();

		ParcelMap parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p);
		parcelList.addDetails(p2);
		wareHouseWorker = new Worker(qOfCusts, parcelList, 5, 4);
		
		wareHouseWorker.setClosed();
		
		assertEquals(qOfCusts.getNext(), cin);
		assertFalse(wareHouseWorker.getClosed() == parcelList.allGone());
       wareHouseWorker.processOneCustomer();

		assertTrue(parcelList.allGone() == wareHouseWorker.getClosed());

	}

	/**
	 * You're provided with a working implementation of this method Write the tests
	 * for it
	 * test case written
	 */
	@Test
	public void testProcessOneCustomer() {

		
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing() == 0);
		CustInQueue cin = new CustInQueue("Andrew", "px21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");

		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();

		ParcelMap parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p);
		parcelList.addDetails(p2);
		wareHouseWorker = new Worker(qOfCusts, parcelList, 5, 4);
		assertEquals(qOfCusts.getNext(), cin);
		assertTrue(wareHouseWorker.getFinished() == parcelList.allGone());
		
		assertEquals(qOfCusts.getNext(), cin2);
		wareHouseWorker.processOneCustomer();
         assertFalse(parcelList.allGone() == wareHouseWorker.getFinished());

	}

}
