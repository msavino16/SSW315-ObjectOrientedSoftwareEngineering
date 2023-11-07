public class LLPriorityQueue<E> {

	private class Node {
		private E element;
		private Node prev;
		private Node next;

		public Node(E o) {
			element = o;
			prev = null;
			next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LLPriorityQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public void enque(E element) {
		Node o = new Node(element);

		if (head == null) {
			head = o;
			tail = o;
		} else if (((Comparable<E>) o.element).compareTo(head.element) > 0) {
			o.next = head;
			head.prev = o;
			head = o;
		} else {
			Node n = head;
			while (n.next != null && ((Comparable<E>) o.element).compareTo(n.next.element) <= 0) {
				n = n.next;
			}
			o.prev = n;
			o.next = n.next;

			if (n.next == null) {
				tail = o;
			} else {
				n.next.prev = o;
			}
			n.next = o;
		}
		size++;
	}

	public E deque() {
		if (head == null) {
			return null;
		}

		E o = head.element;
		head = head.next;
		if (head == null) {
			tail = null;
		} else {
			head.prev = null;
		}
		size--;
		return o;
	}

}
