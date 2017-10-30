package eg.edu.alexu.csd.datastructure.linkedList.cs48;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SinglyLL implements ILinkedList {

	public Node Head = null;

	// ************* INSERTION FUNCTION ****************

	public void add(int index, Object element) {
		Node insertedNode = new Node();
		insertedNode.value = element;

		if (Head == null && index != 0) {
			throw null;
		} else if (index < 0 || index > size()) {
			throw null;
		} else if (index == 0) {
			insertedNode.next = Head;
			Head = insertedNode;
		} else {
			Node refCounter = Head;
			for (int counter = 0; counter < (index - 1); counter++) {
				refCounter = refCounter.next;
			}
			insertedNode.next = refCounter.next;
			refCounter.next = insertedNode;
		}

	}

	// ************* APPENDING FUNCTION ****************

	public void add(Object element) {
		Node appended = new Node();
		appended.value = element;
		if (Head == null) {
			Head = appended;
			appended.next = null;
		} else {
			Node i = Head;
			while (i.next != null) {
				i = i.next;
			}
			i.next = appended;
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
			i.next = j.next;
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
		SinglyLL singleList = new SinglyLL();
		ILinkedList subSingleList = (ILinkedList) singleList;
		int size = size();
		if (Head == null || fromIndex >= size || fromIndex < 0
				|| toIndex >= size || toIndex < 0)
			throw null;
		else {
			Node i = Head;
			int counter = 0;
			if (toIndex >= fromIndex) {
				while (counter <= toIndex) {
					if (counter >= fromIndex) {
						subSingleList.add(i.value);
					}
					i = i.next;
					counter++;
				}
			} else {
				for (counter = 0; counter <= fromIndex; counter++) {
					if (counter < fromIndex) {
						i = i.next;
					} else if (counter == fromIndex) {
						subSingleList.add(i.value);
						counter = -1;
						fromIndex--;
						i = Head;
					}

					if (toIndex - 1 == fromIndex) {
						break;
					}

				}
			}
			return subSingleList;
		}
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
