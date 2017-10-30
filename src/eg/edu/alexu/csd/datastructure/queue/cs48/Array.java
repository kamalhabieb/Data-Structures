package eg.edu.alexu.csd.datastructure.queue.cs48;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class Array implements IQueue, IArrayBased {
	int n, f, r = 0;
	Object[] q;

	public Array(int n) {
		this.n = n + 1;
		q = new Object[n + 1];
	}

	public void enqueue(Object item) {
		if (f == (r + 1) % n || item == null) {
			throw null;
		} else {
			q[r] = item;
			r = (r + 1) % n;
		}
	}

	public Object dequeue() {
		if (isEmpty()) {
			throw null;
		} else {
			Object temp = q[f];
			f = (f + 1) % n;
			return temp;
		}
	}

	public boolean isEmpty() {
		if (f == r) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return (n - f + r) % n;
	}

}
