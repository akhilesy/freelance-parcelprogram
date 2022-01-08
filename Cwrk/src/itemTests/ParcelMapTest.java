package itemTests;

import static org.junit.Assert.*;

import org.junit.Test;

import itemSrc.*;

public class ParcelMapTest {

	ParcelMap parcelList;

	/**
	 * This is the constructor. Provide an implementation of a constructor that
	 * passes these tests
	 */
	@Test
	public void testParcelMap() {
		parcelList = new ParcelMap();
		assertFalse(parcelList.hasParcel() == true);
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		parcelList.addDetails(p);
		assertTrue(parcelList.getNumberOfEntries() == 2);
		assertEquals(parcelList.findParcel("ntqx"), p2);
	}

	/**
	 * This method has been tested in the constructor. Provide an implementation for
	 * it
	 */
	@Test
	public void testAddDetails() {
		parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
assertTrue(parcelList.getNumberOfEntries() == 1);
		parcelList.addDetails(p);
		assertEquals(parcelList.findParcel("lt64s"), p);
		assertTrue(parcelList.getNumberOfEntries() == 2);

	}

	/**
	 * This method has already been tested with the constructor. provide an
	 * implementation for it
	 */
	@Test
	public void testHasParcel() {
		parcelList = new ParcelMap();

		assertTrue(parcelList.hasParcel() == false);
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		assertFalse(parcelList.hasParcel() == false);
		parcelList.addDetails(p);
		assertTrue(parcelList.getNumberOfEntries() == 2);
	}

	/**
	 * This method has already been tested above, and in the constructor Provide
	 * implementation for it
	 */
	@Test
	public void testGetNumberOfEntries() {
		parcelList = new ParcelMap();
		assertTrue(parcelList.getNumberOfEntries() == 0);
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		assertTrue(parcelList.getNumberOfEntries() > 0);
		parcelList.addDetails(p);
		assertTrue(parcelList.getNumberOfEntries() == 2);
	}

	/**
	 * this method tests whether all parcels have been marked as collected, all gone
	 * provide the implementation for it
	 */
	@Test
	public void testAllGone() {
		parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		parcelList.setCollected(p2);
		assertTrue(parcelList.allGone() == true);
		parcelList.addDetails(p);
		assertFalse(parcelList.allGone() == true);

	}

	/**
	 * We test whether a recorded parcel has the correct number of fields i.e. id,
	 * days, length, width, height, weight, collected This is one way of testing it
	 * You are to provide an implementation for this method
	 */
	@Test
	public void testListDetails() {
		parcelList = new ParcelMap();
		// Parcel p = new Parcel("lt64s", 2, 5, 4, 3,1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		String details[] = parcelList.listDetails().split(",");
		assertTrue(details.length == 6);
	}

	/**
	 * This tests whether we can mark a parcel as collected You are to provide the
	 * implementation
	 */
	@Test
	public void testSetCollected() {
		parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		parcelList.addDetails(p);
		parcelList.setCollected(p2);
		assertTrue(parcelList.hasParcel() == true);
		parcelList.setCollected(p);

		assertTrue(parcelList.allGone() == true);
	}

	/**
	 * This tests that we can list uncollected items Provide an implementation for
	 * this method
	 */
	@Test
	public void testListUncollected() {
		parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		parcelList.addDetails(p);
		parcelList.setCollected(p2);
		
		assertTrue(parcelList.findParcel("ntqx").isCollected() == true);

	}

	/**
	 * this tests whether we can find a parcel that matches a certain id You are to
	 * provide an implementation for this method
	 */
	@Test
	public void testFindParcel() {
		parcelList = new ParcelMap();
		Parcel p = new Parcel("lt64s", 2, 5, 4, 3, 1);
		Parcel p2 = new Parcel("ntqx", 1, 3, 2, 3, 1);
		parcelList.addDetails(p2);
		parcelList.addDetails(p);
		assertNotEquals(parcelList.findParcel("ntqx"), p);
		assertEquals(parcelList.findParcel("ntqx"), p2);
	}

}
