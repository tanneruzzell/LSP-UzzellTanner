package org.howard.edu.lsp.assignment6.junit;

import org.howard.edu.lsp.assignment6.integerset.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerSetTest {

	@Test
	@DisplayName("IntegerSet.add test cases")
	void testAdd() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(2);
		assertEquals("[ 1 2 3 ]", set1.toString());
	}

	@Test
	@DisplayName("IntegerSet.length test cases")
	void testLength() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		assertEquals(set1.length(), 3);
	}

	@Test
	@DisplayName("IntegerSet.clear test cases")
	void testClear() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.clear();
		assertEquals(set1.length(), 0);
	}

	@Test
	@DisplayName("IntegerSet.equals test cases when sets are equal")
	void testEqualsWhenEqual() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(2);
		set2.add(1);

		assertTrue(set1.equals(set2));
	}

	@Test
	@DisplayName("IntegerSet.equals test cases when sets not are equal")
	void testEqualsWhenNotEqual() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		IntegerSet set2 = new IntegerSet();
		set2.add(4);
		set2.add(5);
		set2.add(6);

		assertFalse(set1.equals(set2));
	}

	@Test
	@DisplayName("IntegerSet.isEmpty test cases when set is empty")
	void testIsEmptyWhenEmpty() {
		IntegerSet set1 = new IntegerSet();

		assertTrue(set1.isEmpty());
	}

	@Test
	@DisplayName("IntegerSet.isEmpty test cases when set is not empty")
	void testIsEmptyWhenNotEmpty() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		assertFalse(set1.isEmpty());
	}

	@Test
	@DisplayName("IntegerSet.union test cases")
	void testUnion() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);

		IntegerSet checkSet = new IntegerSet();
		checkSet.add(1);
		checkSet.add(2);
		checkSet.add(3);
		checkSet.add(4);
		checkSet.add(5);
		checkSet.add(6);
		set1.union(set2);

		assertTrue(set1.equals(checkSet));
	}

	@Test
	@DisplayName("IntegerSet.intersect test cases")
	void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);

		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(4);
		set2.add(6);
		set2.add(8);

		IntegerSet checkSet = new IntegerSet();

		checkSet.add(2);
		checkSet.add(4);

		set1.intersect(set2);

		assertTrue(set1.equals(checkSet));
	}

	@Test
	@DisplayName("IntegerSet.diff test cases")
	void testDiff() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);

		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(4);
		set2.add(6);
		set2.add(8);

		IntegerSet checkSet = new IntegerSet();
		checkSet.add(1);
		checkSet.add(3);
		checkSet.add(6);
		checkSet.add(5);
		checkSet.add(8);

		set1.diff(set2);

		assertTrue(set1.equals(checkSet));
	}

	@Test
	@DisplayName("IntegerSet.contains test cases when set contains the desired value")
	void testContains_whenSetContainsValue() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		assertTrue(set1.contains(1));
	}

	@Test
	@DisplayName("IntegerSet.contains test cases when set does not contain the desired value")
	void testContains_whenSetDoesNotContainValue() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);

		assertFalse(set1.contains(9));
	}

	@Test
	@DisplayName("IntegerSet.remove test cases when set contains the desired value")

	void testRemove_whenSetDoesContainValue() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);

		try {
			set1.remove(1);
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}

		assertEquals("[ 2 3 4 5 ]", set1.toString());
	}

	@Test
	@DisplayName("IntegerSet.remove test cases when set does not contains the desired value")
	void testRemove_whenSetDoesNotContainValue() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);

		try {
			set1.remove(10);
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}

		assertEquals("[ 1 2 3 4 5 ]", set1.toString());
	}

	@Test
	@DisplayName("IntegerSet.contains throws IntegerSetException")
	void testremove_throwsException() {

		IntegerSet set1 = new IntegerSet();

		Exception exception = assertThrows(Exception.class, () -> {
			set1.remove(1);
		});

		String expectedMessage = "Integer set is empty";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	@DisplayName("IntegerSet.largest test cases")
	void testLargest() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(6);
		set1.add(4);
		set1.add(5);

		try {
			assertEquals(6, set1.largest());
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("IntegerSet.largest throws IntegerSetException")
	void testLargest_throwsException() {
		

		IntegerSet set1 = new IntegerSet();

		Exception exception = assertThrows(Exception.class, () -> {
			int testa = set1.largest();
		});

		String expectedMessage = "Integer set is empty";
		String actualMessage = exception.getMessage();
		

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	@DisplayName("IntegerSet.smallest test cases")
	void testSmallest() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(0);
		set1.add(5);

		try {
			assertEquals(0, set1.smallest());
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("IntegerSet.smallest throws IntegerSetException")
	void testSmallest_throwsException() {
		
		IntegerSet set1 = new IntegerSet();

		Exception exception = assertThrows(Exception.class, () -> {
			set1.smallest();
		});

		String expectedMessage = "Integer set is empty";
		String actualMessage = exception.getMessage();
		

		assertTrue(actualMessage.contains(expectedMessage));

	}

}
