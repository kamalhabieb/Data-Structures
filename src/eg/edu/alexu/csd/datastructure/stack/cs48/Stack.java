package eg.edu.alexu.csd.datastructure.stack.cs48;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {
	private LinkedList ll = new LinkedList();

	private int index = -1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stack.IStack#add(int, java.lang.Object) adds element to the stack in
	 * a specified index
	 */
	public void add(int indextwo, Object element) {
		if (indextwo <= (index + 1) && indextwo >= 0) {
			ll.add(indextwo, element);
			index++;
		} else {
			throw null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stack.IStack#pop()
	 * 
	 * @return the element on top of the stack then deleting it
	 */
	public Object pop() {
		if (!ll.isEmpty()) {
			Object poped = ll.get();
			ll.remove();
			index--;
			return poped;
		} else {
			throw null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stack.IStack#peek()
	 * 
	 * @return the element on top of the stack without deleting it
	 */
	public Object peek() {
		if (index >= 0) {
			Object peek = ll.get();
			return peek;
		} else {
			throw null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stack.IStack#push(java.lang.Object) ads new elements to the stack on
	 * top of it
	 */
	public void push(Object element) {
		index++;
		ll.add(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stack.IStack#isEmpty() checks if the stack is currently empty
	 * 
	 * @return boolean value
	 */
	public boolean isEmpty() {
		return ll.isEmpty();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stack.IStack#size()
	 * 
	 * @return an integer indicates the size of the stack
	 */
	public int size() {
		int size = index + 1;
		return size;
	}

}
