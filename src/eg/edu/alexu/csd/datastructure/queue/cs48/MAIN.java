package eg.edu.alexu.csd.datastructure.queue.cs48;

public class MAIN {
	public static void main(String[] args) {
		Array q = new Array(10000000);
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		Integer c = new Integer(3);
		Integer d = new Integer(4);

		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.enqueue(d);

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(b);

		System.out.println(q.isEmpty());
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
		System.out.println(q.size());

	}
}