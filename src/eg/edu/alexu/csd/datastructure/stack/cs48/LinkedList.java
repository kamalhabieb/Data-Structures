package eg.edu.alexu.csd.datastructure.stack.cs48;

public class LinkedList {

	public Node head = null;
	public Node tail = head;

	/**
	 * @param index
	 * @param element
	 */
	public void add(int index, Object element) {
		Node insertedNode = new Node();
		insertedNode.value = element;

		if (head == null && index != 0) {
			throw null;
		} else if (index == 0) {
			insertedNode.next = head;
			if (head != null) {
				head.prev = insertedNode;
			}
			head = insertedNode;
			if (tail == null) {
				tail = head;
			}
		} else {
			Node i = head;
			for (int counter = 0; counter < (index - 1); counter++) {
				i = i.next;
			}
			if (i == tail) {
				tail.next = insertedNode;
				tail = insertedNode;
				tail.prev = i;
				tail.next = null;
			} else {
				Node j = i.next;
				insertedNode.next = i.next;
				insertedNode.prev = i;
				i.next = insertedNode;
				j.prev = insertedNode;
			}
		}
	}

	/**
	 * @param element
	 */
	public void add(Object element) {
		Node appended = new Node();
		appended.value = element;
		if (head == null) {
			head = appended;
			tail = appended;
			tail.next = null;
		} else {
			Node i = tail;
			tail.next = appended;
			tail = appended;
			tail.prev = i;
			tail.next = null;
		}
	}

	/**
	 * @return
	 */
	public Object get() {
		return tail.value;

	}

	/**
	 * @return
	 */
	public Object dequeue() {
		Object temp = head.value;
		head = head.next;
		return temp;

	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	/**
		 * 
		 */
	public void remove() {
		if (head == null) {
			throw null;
		}
		if (head.next == null) {
			head = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
	}

	/**
	 * @return
	 */
	public int size() {
		int size = 0;
		Node i = head;
		while (i != null) {
			size++;
			i = i.next;
		}
		return size;
	}

}