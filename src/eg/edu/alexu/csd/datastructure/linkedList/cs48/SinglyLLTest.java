package eg.edu.alexu.csd.datastructure.linkedList.cs48;

import static org.junit.Assert.*;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SinglyLLTest {

	SinglyLL test = new SinglyLL();

	@Test(expected = NullPointerException.class)
	public void testAddIndexed() {
		ILinkedList tests = (ILinkedList) test;
		Object elementA = new Object();
		Object elementB = new Object();
		Object elementC = new Object();
		Object elementD = new Object();
		Object elementE = new Object();
		Object elementF = new Object();

		tests.add(elementA);
		tests.add(elementB);
		tests.add(elementC);
		tests.add(elementD);
		tests.add(elementE);

		tests.add(3, elementF);
		tests.add(51, elementA);

		assertSame(elementA, tests.get(0));
		assertSame(elementB, tests.get(1));
		assertSame(elementC, tests.get(2));
		assertSame(elementF, tests.get(3));
		assertSame(elementD, tests.get(4));
		assertSame(elementE, tests.get(5));
		assertNull(tests.get(-1));
		assertNull(tests.get(6));
		assertNull(tests.get(51));

	}

	@Test
	public void testAdd() {
		ILinkedList tests = (ILinkedList) test;
		Object element = new Object();
		tests.add(element);
		assertSame(element, tests.get(0));
	}

	@Test
	public void testGet() {
		ILinkedList tests = (ILinkedList) test;
		Object elementA = new Object();
		Object elementB = new Object();
		Object elementC = new Object();
		Object elementD = new Object();
		Object elementE = new Object();
		Object elementF = new Object();
		Object elementG = new Object();

		tests.add(elementA);
		tests.add(elementB);
		tests.add(elementC);
		tests.add(elementD);
		tests.add(elementE);
		tests.add(elementF);
		tests.add(elementG);

		assertSame(elementD, tests.get(3));
	}

	@Test
	public void testSet() {
		ILinkedList tests = (ILinkedList) test;
		Object elementA = new Object();
		Object elementB = new Object();
		Object elementC = new Object();
		Object elementD = new Object();
		Object elementE = new Object();
		Object elementF = new Object();
		Object elementG = new Object();

		tests.add(elementA);
		tests.add(elementB);
		tests.add(elementC);
		tests.add(elementD);
		tests.add(elementE);
		tests.add(elementF);
		tests.add(elementG);

		tests.set(3, elementA);

		assertSame(elementA, tests.get(3));

	}

	@Test(expected = NullPointerException.class)
	public void testClear() {
		ILinkedList tests = (ILinkedList) test;
		Object element = new Object();
		tests.add(element);
		tests.add(element);
		tests.add(element);
		tests.add(element);
		tests.add(element);
		tests.add(element);
		tests.add(element);
		tests.clear();

		assertNull(tests.get(0));
	}

	@Test
	public void testIsEmpty() {
		ILinkedList tests = (ILinkedList) test;
		Object elementA = new Object();
		Object elementB = new Object();
		Object elementC = new Object();
		Object elementD = new Object();
		Object elementE = new Object();
		Object elementF = new Object();
		Object elementG = new Object();

		tests.add(elementA);
		tests.add(elementB);
		tests.add(elementC);
		tests.add(elementD);
		tests.add(elementE);
		tests.add(elementF);
		tests.add(elementG);

		assertFalse(tests.isEmpty());
	}

	@Test
	public void testSize() {
		ILinkedList tests = (ILinkedList) test;
		Object elementA = new Object();
		Object elementB = new Object();
		Object elementC = new Object();
		Object elementD = new Object();
		Object elementE = new Object();
		Object elementF = new Object();
		Object elementG = new Object();

		tests.add(elementA);
		tests.add(elementB);
		tests.add(elementC);
		tests.add(elementD);
		tests.add(elementE);
		tests.add(elementF);
		tests.add(elementG);

		assertEquals(7, tests.size());
	}

	@Test
	public void testRemove() {
		ILinkedList tests = (ILinkedList) test;
		Object elementA = new Object();
		Object elementB = new Object();
		Object elementC = new Object();
		Object elementD = new Object();
		Object elementE = new Object();
		Object elementF = new Object();
		Object elementG = new Object();

		tests.add(elementA);
		tests.add(elementB);
		tests.add(elementC);
		tests.add(elementD);
		tests.add(elementE);
		tests.add(elementF);
		tests.add(elementG);

		tests.remove(3);
		assertNotEquals(7, tests.size());
		assertNotSame(elementD, tests.get(3));
	}

	@Test(expected = NullPointerException.class)
	public void testSubList() {

		ILinkedList tests = (ILinkedList) test;
		Object elementA = new Object();
		Object elementB = new Object();
		Object elementC = new Object();
		Object elementD = new Object();
		Object elementE = new Object();
		Object elementF = new Object();
		Object elementG = new Object();

		tests.add(elementA);
		tests.add(elementB);
		tests.add(elementC);
		tests.add(elementD);
		tests.add(elementE);
		tests.add(elementF);
		tests.add(elementG);

		ILinkedList testSub = new SinglyLL();

		testSub = tests.sublist(2, 5);
		assertEquals(4, testSub.size());
		assertSame(elementC, testSub.get(0));
		assertSame(elementD, testSub.get(1));
		assertSame(elementE, testSub.get(2));
		assertSame(elementF, testSub.get(3));
		assertNull(testSub.get(4));

	}

	@Test
	public void testContain() {
		ILinkedList tests = (ILinkedList) test;
		tests.add(0);
		tests.add(1);
		tests.add(2);
		tests.add(3);

		assertTrue(tests.contains(3));
		assertFalse(tests.contains(8));
	}
}
