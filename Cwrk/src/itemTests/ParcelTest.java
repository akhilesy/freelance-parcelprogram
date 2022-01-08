package itemTests;

import static org.junit.Assert.*;

import org.junit.Test;

import itemSrc.*;

/**
 * a test class for the the item being processed...in this case a Parcel
 * Please note that you will need to write code that matches 
 * these tests for the class provided to you
 * @author John Kanyaru
 *
 */
public class ParcelTest {

	Parcel  p; 
	
	@Test
	public void testParcel() {
		  p = new Parcel("bk021", 2, 3, 4, 3, 9);
		  assertEquals(p.getId(), "bk021");
		
	}

	@Test
	public void testGetId() {
		  p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		  assertTrue(p.getId() =="bk0221");
	}

	@Test
	public void testSetId() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertSame(p.getId(),"bk0221");
		 p.setId("pe3p");
		 assertEquals(p.getId(),"pe3p");
		 
	}

	@Test
	public void testGetDays() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertFalse(p.getDays()!=2);
		 
	}

	@Test
	public void testSetDays() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertFalse(p.getDays()!=2);
		 p.setDays(1);
		 assertFalse(p.getDays()==2);
	}

	@Test
	public void testGetLength() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertTrue(p.getLength()==3);
	}

	@Test
	public void testSetLength() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertTrue(p.getLength()==3);
		 p.setLength(5);
		 assertFalse(p.getLength()==3);
	}

	@Test
	public void testGetWidth() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertTrue(p.getWidth()==4);
		
	}

	@Test
	public void testSetWidth() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertTrue(p.getWidth()==4);
		 p.setWidth(7);
		 assertFalse(p.getWidth()!=7);
	}

	@Test
	public void testGetHeight() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertTrue(p.getHeight()==8);
	}

	@Test
	public void testSetHeight() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertFalse(p.getHeight()!=8);
		 p.setHeight(2);
		 assertTrue(p.getHeight()==2);
	}

	@Test
	public void testGetWeight() {
		p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertTrue(p.getWeight()==9);
	}

	@Test
	public void testSetWeight() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertFalse(p.getWeight()!=9);
		 p.setWeight(11);
		 assertTrue(p.getWeight()==11);
	}

	@Test
	public void testIsCollected() {
		 p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertFalse(p.isCollected()!=false);
		 
	}

	@Test
	public void testSetCollected() {
		p = new Parcel("bk0221", 2, 3, 4, 8, 9);
		 assertFalse(p.isCollected()!=false);
		 p.setCollected(true);
		 assertTrue(p.isCollected()==true);
	}

}
