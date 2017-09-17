package practics.quiz.test13;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
	
	private Address address1;
	private Address address2;
	
	@Before
	public void setUp() {
		address1 = new Address(State.NY, "New York", "17 Avenu", 1);
		address2 = new Address(State.NY, "New York", "17 Avenu", 1);
	}

	@Test
	public void testToString() {
		assertEquals("Address[state=NY, city='New York', street='17 Avenu', houseNumber=1]", address1.toString());
	}

	@Test
	public void testEquals() {
		assertEquals(address2, address1);
	}

	@Test
	public void testHashCode() {
		assertFalse(address1.hashCode() != address2.hashCode());
	}

	@Test
	public void testComprareStateLess() {
		Address address1 = new Address(State.CA, "New York", "17 Avenu", 1);
		Address address2 = new Address(State.NY, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) < 0);
	}

	@Test
	public void testComprareEquals() {
		Address address1 = new Address(State.CA, "New York", "17 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) == 0);
	}

	@Test
	public void testComprareStateMore() {
		Address address1 = new Address(State.FL, "New York", "17 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) > 0);
	}

	@Test
	public void testComprareStateFirstNull() {
		Address address1 = new Address(null, "New York", "17 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) < 0);
	}

	@Test
	public void testComprareStateSecondNull() {
		Address address1 = new Address(State.CA, "New York", "17 Avenu", 1);
		Address address2 = new Address(null, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) > 0);
	}

	@Test
	public void testComprareStateBothNull() {
		Address address1 = new Address(null, "New York", "17 Avenu", 1);
		Address address2 = new Address(null, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) == 0);
	}

	@Test
	public void testComprareCityLess() {
		Address address1 = new Address(State.CA, "Alabama", "17 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) < 0);
	}

	@Test
	public void testComprareCityMore() {
		Address address1 = new Address(State.CA, "Washington", "17 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) > 0);
	}

	@Test
	public void testComprareCityFirstNull() {
		Address address1 = new Address(State.CA, null, "17 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) < 0);
	}

	@Test
	public void testComprareCitySecondNull() {
		Address address1 = new Address(State.CA, "New York", "17 Avenu", 1);
		Address address2 = new Address(State.CA, null,  "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) > 0);
	}

	@Test
	public void testComprareCityBothNull() {
		Address address1 = new Address(State.CA, null, "17 Avenu", 1);
		Address address2 = new Address(State.CA, null, "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) == 0);
	}

	@Test
	public void testComprareStreetLess() {
		Address address1 = new Address(State.CA, "New York", "10 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) < 0);
	}

	@Test
	public void testComprareStreetMore() {
		Address address1 = new Address(State.CA, "New York", "27 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) > 0);
	}

	@Test
	public void testComprareStreetFirstNull() {
		Address address1 = new Address(State.CA, "New York", null, 1);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) < 0);
	}

	@Test
	public void testComprareStreetSecondNull() {
		Address address1 = new Address(State.CA, "New York", "17 Avenu", 1);
		Address address2 = new Address(State.CA, "New York", null, 1);
		assertTrue(address1.compareTo(address2) > 0);
	}

	@Test
	public void testComprareStreetBothNull() {
		Address address1 = new Address(State.CA, "New York", null, 1);
		Address address2 = new Address(State.CA, "New York", null, 1);
		assertTrue(address1.compareTo(address2) == 0);
	}

	@Test
	public void testComprareHouseNumberLess() {
		Address address1 = new Address(State.CA, "New York", "17 Avenu", 0);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) < 0);
	}

	@Test
	public void testComprareHouseNumberMore() {
		Address address1 = new Address(State.CA, "New York", "17 Avenu", 5);
		Address address2 = new Address(State.CA, "New York", "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) > 0);
	}

	@Test
	public void testComprareHouseNumberMore1() {
		Address address1 = new Address(State.CA, new String("New York"), "17 Avenu", 5);
		Address address2 = new Address(State.CA, new String("New York"), "17 Avenu", 1);
		assertTrue(address1.compareTo(address2) > 0);
	}
}
