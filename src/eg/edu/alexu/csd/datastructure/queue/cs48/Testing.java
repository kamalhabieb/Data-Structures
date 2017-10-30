package eg.edu.alexu.csd.datastructure.queue.cs48;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void testArrayEnqueue() {
		Array q = new Array(10);
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		Integer e = new Integer(4);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);

		assertEquals(q.size(), 6);
	}

	@Test
	public void testArrayDequeue() {
		Array q = new Array(10);
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		Integer e = new Integer(4);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		Integer f = (Integer) q.dequeue();
		assertEquals(f.intValue(), 3);
	}

	@Test
	public void testArrayEnqueueFull() {
		Array q = new Array(10);
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		Integer e = new Integer(4);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);
		assertEquals(q.size(), 10);

	}

	@Test
	public void testLinkedEnqueue() {
		Linkedlist q = new Linkedlist();
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		Integer e = new Integer(4);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);

		assertEquals(q.size(), 6);
	}

	@Test
	public void testLinkedDequeue() {
		Linkedlist q = new Linkedlist();
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		Integer e = new Integer(4);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		Integer f = (Integer) q.dequeue();
		assertEquals(f.intValue(), 3);
	}

	@Test
	public void testLinkedEnqueueFull() {
		Linkedlist q = new Linkedlist();
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		Integer e = new Integer(4);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(a);
		assertEquals(q.size(), 10);

	}

}
