package projectCode20280;

public class LinkedQueue<E> implements Queue<E> {
	
	private int size;
	private Node<E> front;
	private Node<E> rear;

	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		q.enqueue(1);
		System.out.println(q);
		System.out.println(q.first());
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q);
		System.out.println(q.first());
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q);
		System.out.println(q.first());
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E e) {
		Node<E> newest = new Node<E>(e, null);
		if(rear == null) front = newest;
		else rear.setNext(newest);
		rear = newest;
		size++;
	}

	@Override
	public E first() {
		return front.getElement();
	}

	public String toString() {
		String str = "[";
		Node<E> curr = front;
		while(curr != rear) {
			str += curr.getElement() + ", ";
			curr = curr.getNext();
		}
		str += rear.getElement() + "]";
		return str;
	}
	
	@Override
	public E dequeue() {
		E firstElement = front.getElement();
		front = front.getNext();
		if(front == null) rear = null;
		size--;
		return firstElement;
	}

}
