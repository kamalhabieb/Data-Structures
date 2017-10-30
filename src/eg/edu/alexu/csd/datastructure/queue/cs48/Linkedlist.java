package eg.edu.alexu.csd.datastructure.queue.cs48;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.stack.cs48.LinkedList;

public class Linkedlist implements IQueue, ILinkedBased {

	LinkedList q = new LinkedList();
	int size = 0;

	public void enqueue(Object item) {
		q.add(item);
		size++;
	}

	public Object dequeue() {
		Object temp = q.dequeue();
		size--;
		return temp;
	}

	public boolean isEmpty() {
		return (q.head == null);
	}

	public int size() {
		return size;
	}

}
