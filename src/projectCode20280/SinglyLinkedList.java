package projectCode20280;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

	private int size;
	private Node<E> head;

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
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	@Override
	public E get(int i) {
		int index = 0;
		Node<E> atIndex = head;
		while(index != i) {
			atIndex = atIndex.getNext(); 
			index++;
		}
		return atIndex.getElement();
	}

	@Override
	public void add(int i, E e) {
		Node<E> cur = head.getNext();
		Node<E> prev = head;
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
		Node<E> cur = head.getNext();
		Node<E> prev = head;
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
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E> {
		Node<E> curr;
		public ListIterator() {
			curr = head;
		}
		public boolean hasNext() {
			return curr != null;
		}
		@Override
		public E next() {
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	@Override
	public int size() {
		return size;
	}	
	

	@Override
	public E removeFirst() {
		E firstElement = head.getElement();
		head = head.getNext();
		size--;
		return firstElement;
	}
	
	public E first() {
		return head.getElement();
	}

	@Override
	public E removeLast() {
		Node<E> last = head;
		int index = 0;
		while(index < size-1) {
			last = last.getNext();
			index++;
		}
		last.setNext(null);
		size--;
		return null;
	}

	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, head);
		size++;
		
	}

	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		Node<E> last = head;
		
		if(last == null) {
			head = newest;
		}
		else {
			while(last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(newest);
		}
		size++;
	}
	
	public String toString() {
		String str = "[";
		Node<E> last = head;
		if(size == 1) str += last.getElement();
		else str += last.getElement() + ", ";
		while(last.getNext() != null) {
			last = last.getNext();
			if(last.getNext() == null)str += last.getElement();
			else str += last.getElement() +", ";
		}
		return str +"]";
	}
	
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());
		
		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
		
		SinglyLinkedList <Integer> ll = new SinglyLinkedList <Integer>();
		//LinkedList<Integer>ll=newLinkedList<Integer>();
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
		
		//Removestheiteminthespecifiedindex
		ll.remove(2);
		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll);
		ll.removeLast();
		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll);
		ll.addFirst(9999);
		System.out.println(ll);
		ll.addFirst(8888);
		System.out.println(ll);
		ll.addFirst(7777);
		System.out.println(ll);
		System.out.println(ll.get(0));
		System.out.println(ll.get(1));
		System.out.println(ll.get(2));
		System.out.println(ll);
	}
	


}
