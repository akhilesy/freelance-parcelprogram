package itemTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import itemSrc.CustInQueue;
import itemSrc.Manager;
import itemSrc.Parcel;
import itemSrc.ParcelMap;
import itemSrc.QueueOfCusts;
import itemSrc.Worker;

public class ManagerTest {

	/**
	 * The Manager class is fully implemented You're to write JUnit tests for it.
	 * This is likely to be possible after implementing the other classes
	 */
	private Manager manager = new Manager();;
	private Worker wareHouseWorker;
	/*
	 * @BeforeEach public void setup() { manager=new Manager(); }
	 */

	@Test
	public void testManager() {
		CustInQueue que = new CustInQueue("Andrew Robertson", "X919");
		que.setInQueue(true);
		QueueOfCusts qOfCusts = new QueueOfCusts();
		qOfCusts.addDetails(que);
		assertSame(qOfCusts.get(0), que);
		assertTrue(que.isInQueue());

		Parcel parsal = new Parcel("lt64s", 2, 5, 4, 3, 1);
		ParcelMap parcelMap = new ParcelMap();
		parcelMap.addDetails(parsal);
		parcelMap.setCollected(parsal);
		
		assertTrue(parcelMap.allGone());

	}

	@Test
	public void testInitialiseData() {
		CustInQueue que = new CustInQueue("Andrew Robertson", "X919");
		que.setInQueue(true);
		QueueOfCusts qOfCusts = new QueueOfCusts();
		qOfCusts.addDetails(que);
		assertSame(qOfCusts.get(0), que);
		assertTrue(que.isInQueue());

	}

	@Test
	public void testInitialiseWorkers() {
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
		assertEquals(qOfCusts.getNext(), cin2);
		assertEquals(parcelList.findParcel("lt64s"), p);
		assertEquals(parcelList.findParcel("ntqx"), p2);

	}

	@Test
	public void testReadCustFile() throws FileNotFoundException {
		File file = new File("Custs.csv");
		Scanner sc = new Scanner(file);
		String data = sc.nextLine();
		assertEquals("Andrew Robertson,X919", data);
	}

	@Test
	public void testReadParcelFile() throws FileNotFoundException {
		File file = new File("Parcels.csv");
		Scanner sc = new Scanner(file);
		String data = sc.nextLine();
		assertEquals("X009,9,1,9,9,7", data);
	}

}
