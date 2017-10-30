package eg.edu.alexu.csd.datastructure.linkedList.cs48;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoublyLL implements ILinkedList {

	public Node Head = null;

	public void add(int index, Object element) {
		Node insertedNode = new Node();
		insertedNode.value = element;

		if (Head == null && index != 0) {
			throw null;
		} else if (index < 0 || index > size()) {
			throw null;
		} else if (index == 0) {
			insertedNode.next = Head;
			insertedNode.prev = null;
			Head = insertedNode;
		} else {
			Node refCounter = Head;
			for (int counter = 0; counter < (index - 1); counter++) {
				refCounter = refCounter.next;
			}
			insertedNode.next = refCounter.next;
			insertedNode.prev = refCounter;
			refCounter.next = insertedNode;
			Node temp = new Node();
			temp.prev = insertedNode;
			temp = insertedNode.next;

			// temp : temporary reference to the node next to the new node

		}

	}

	// ************* APPENDING FUNCTION ****************

	public void add(Object element) {
		Node appended = new Node();
		appended.value = element;
		if (Head == null) {
			Head = appended;
			appended.next = null;
			appended.prev = null;
		} else {
			Node i = Head;
			while (i.next != null) {
				i = i.next;
			}
			i.next = appended;
			appended.prev = i;
			appended.next = null;
		}
	}

	// ********************* Object Get Function ************************

	public Object get(int index) {
		if (index >= size() || index < 0 || Head == null) {
			throw null;
		} else {
			int counter = 0;
			Node i = Head;
			while (counter < index && i != null) {
				i = i.next;
				counter++;
			}
			return i.value;
		}
	}

	// ************* Set Function *******************
	public void set(int index, Object element) {
		Node i = Head;
		if (index >= 0 && index < size()) {
			for (int counter = 0; counter < index; counter++) {
				i = i.next;
			}
			i.value = element;
		} else {
			throw null;
		}

	}

	// ************* CLEAR FUNCTION ****************

	public void clear() {
		if (Head == null) {
			throw null;
		}
		Head = null;
	}

	// ************* IS EMPTY FUNC ****************
	public boolean isEmpty() {
		if (Head == null)
			return true;
		else
			return false;
	}

	// ************* REMOVE FUNCTION ****************

	public void remove(int index) {
		if (Head == null) {
			throw null;
		}
		Node i = Head;
		Node j = Head.next;

		if (index < 0 || index >= size()) {
			throw null;
		} else if (index == 0) {
			Head = Head.next;
		} else {
			for (int counter = 0; counter < (index - 1); counter++) {
				i = i.next;
				j = j.next;
			}
			if (j.next == null) {
				i.next = j.next;
			} else {
				Node temp = j.next;
				i.next = temp;
				temp.prev = i;
			}
		}
	}

	// ************* SIZE FUNCTION ****************

	public int size() {
		int size = 0;
		Node i = Head;
		while (i != null) {
			size++;
			i = i.next;
		}
		return size;
	}

	// ************* SUBLIST FUNCTION ***************

	public ILinkedList sublist(int fromIndex, int toIndex) {
		DoublyLL doubleList = new DoublyLL();
		ILinkedList subDoubleList = (ILinkedList) doubleList;
		int size = size();
		if (fromIndex >= size || fromIndex < 0 || toIndex >= size
				|| toIndex < 0 || fromIndex > toIndex)
			throw null;
		else {
			Node i = Head;
			int counter = 0;

			while (counter <= toIndex) {
				if (counter >= fromIndex) {
					subDoubleList.add(i.value);
				}
				i = i.next;
				counter++;
			}
		}
		return subDoubleList;

	}

	// *********************** CONTAINS FUNCTION ***********************
	public boolean contains(Object o) {
		Node i = Head;
		while (i != null) {
			if (i.value.equals(o)) {
				return true;
			}
			i = i.next;
		}
		return false;
	}

}
