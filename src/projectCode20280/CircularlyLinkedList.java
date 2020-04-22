package projectCode20280;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

	private Node<E> tail = null;	
	private int size = 0;
	
	private class Node<E> {
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

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) {
		int index = 0;
		Node<E> atIndex = tail;
		while(index != i) {
			atIndex = atIndex.getNext(); 
			index++;
		}
		return atIndex.getElement();
	}

	@Override
	public void add(int i, E e) {
		Node<E> cur = tail.getNext();
		Node<E> prev = tail;
		int index = 1;
		while(index != i) {
			cur = cur.getNext();
			prev = prev.getNext();
			index++;
		}
		prev.setNext(new Node<E>(e, cur));
	}

	@Override
	public E remove(int i) {
		Node<E> cur = tail.getNext();
		Node<E> prev = tail;
		int index = 1;
		while(index != i) {
			cur = cur.getNext();
			prev = prev.getNext();
			index++;
		}
		prev.setNext(cur.getNext());
		size--;
		return null;
	}

	@Override
	public E removeFirst() {
		tail = tail.getNext();
		size--;
		return null;
	}

	@Override
	public E removeLast() {
		Node<E> last = tail;
		while(last.getNext() != tail) {
			last = last.getNext();
		}
		last.setNext(tail);
		size--;
		return null;
	}

//	@Override
//	public Iterator<E> iterator() {
//		return new ListIterator();
//	}
//	
//	private class ListIterator implements Iterator<E> {
//		Node<E> curr;
//		public ListIterator() {
//			curr = head;
//		}
//		public boolean hasNext() {
//			return curr != null;
//		}
//		@Override
//		public E next() {
//			E res = (E) curr.getElement();
//			curr = curr.getNext();
//			return res;
//		}
//	}
	
	@Override
	public void addFirst(E e) {
		Node<E> curr = tail;
		if(tail == null) {
			Node<E> newest = new Node<E>(e, null);
			tail = newest;
			tail.setNext(tail);
		}
		else if(curr.getNext() == tail) {
			Node<E> newest = new Node<E>(e, tail);
			curr.setNext(newest);
		}
		else {
			Node<E> newest = new Node<E>(e, tail);
			while(curr.getNext() != tail) {
				curr = curr.getNext();
			}
			curr.setNext(newest);
		}
	}

	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, tail);
		Node<E> last = tail;
		
		if(last == null) {
			tail = newest;
		}
		else {
			while(last.getNext() != tail) {
				last = last.getNext();
			}
			last.setNext(newest);
		}
		size++;
	}

	public void rotate() {
				
	}
	
	public String toString() {
		String str = "";
		Node<E> last = tail;
		str += last.getElement();
		while(last.getNext() != tail) {
			last = last.getNext();
			str += " " + last.getElement();
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
//		for(int i = 10; i < 20; ++i) {
//			ll.addFirst(i);
//		}
		ll.addFirst(0);
		System.out.println(ll);
		ll.addFirst(1);
		System.out.println(ll);
		ll.addFirst(3);
		System.out.println(ll);
		ll.addFirst(4);
		System.out.println(ll);
		ll.addFirst(5);
		System.out.println(ll);
		ll.add(3, 2);
		System.out.println(ll);
		ll.addFirst(-100);
		System.out.println(ll);
		ll.addLast(100);
		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll);
		ll.removeLast();
		System.out.println(ll);
		System.out.println(ll);
//
//		ll.removeFirst();
//		System.out.println(ll);
//
//		ll.removeLast();
//
//		ll.rotate();
//		System.out.println(ll);
//
//		ll.removeFirst();
//		ll.rotate();
//		System.out.println(ll);
//
//		ll.removeLast();
//		ll.rotate();
//		System.out.println(ll);

//		for (Integer e : ll) {
//			System.out.println("value: " + e);
//		}

	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
