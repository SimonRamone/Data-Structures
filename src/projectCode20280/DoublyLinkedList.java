package projectCode20280;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

	private Node<E> header;		//node at beginning of list
	private Node<E> trailer;	//node at end of list
	
	private int size = 0; 		//number of elements in the list
	
	private class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public Node<E> getPrev() {
			return prev;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public void setPrev(Node<E> p) {
			prev = p;
		}
	}
	
	public DoublyLinkedList(){
		header = new Node<>(null, null, null);		//create header
		trailer = new Node<>(null, header, null);	//header is before trailer
		header.setNext(trailer);					//trailer is after header
	}	
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
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
		Node<E> atIndex = header.getNext();
		while(index != i) {
			atIndex = atIndex.getNext(); 
			index++;
		}
		return atIndex.getElement();
	}

	@Override
	public void add(int i, E e) {
		Node<E> atIndex = header.getNext();
		int index = 0;
		while(index != i) {
			atIndex = atIndex.getNext(); 
			index++;
		}
		addBetween(e, atIndex.getPrev(), atIndex);
	}

	@Override
	public E remove(int i) {
		Node<E> atIndex = header.getNext();
		int index = 0;
		while(index != i) {
			atIndex = atIndex.getNext(); 
			index++;
		}
		return remove(atIndex);
	}
	
	public E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> curr = header.getNext();
		Node<E> prev = null;
		int index = 0;
		public ListIterator() {
			curr = header.getNext();
		}
		public boolean hasNext() {
			return curr != trailer;
		}
		public boolean hasPrevious() {
			return prev != null;
		}
		@Override
		public E next() {
			prev = curr;
			E res = (E) curr.getElement();
			curr = curr.getNext();
			index++;
			return res;
		}
		
		public E previous() {
			curr = curr.getPrev();
			index--;
			prev = curr;
			return curr.getElement();
		}
	}

	@Override
	public E removeFirst() {
		if(isEmpty()) return null;
		return remove(header.getNext());
	}

	@Override
	public E removeLast() {
		if(isEmpty()) return null;
		return remove(trailer.getPrev());
	}
	

	@Override
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	@Override
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
		
	}
	
	public E first() {
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}

	public E last() {
		if(isEmpty()) return null;
		return trailer.getPrev().getElement();
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String prefix = "[";
		Node<E> current = header;
		while(current.getNext() != trailer){
			current = current.getNext();
			sb.append(prefix);
			prefix = ", ";
			E element = current.getElement();
			sb.append(element);
		}
		sb.append("]");
		return sb.toString();
	  }
	
	public static void main(String[] args) {
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll);
           
           ll.removeFirst();
           System.out.println(ll);

           ll.removeLast();
           System.out.println(ll);
           
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }
           
   		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

   		DoublyLinkedList<String> ll2 = new DoublyLinkedList<String>();
   		for (String s : alphabet) {
   			ll2.addFirst(s);
   			ll2.addLast(s);
   		}
   		System.out.println(ll2.toString());
   		
   		ll2.removeFirst();
   		System.out.println(ll2.toString());
   		
   		ll2.removeLast();
   		System.out.println(ll2.toString());

   		ll2.remove(2);
   		System.out.println(ll2.toString());
   		
   		for (String s : ll2) {
   			System.out.print(s + ", ");
   		}
   		
   		DoublyLinkedList <Integer> ll3 = new DoublyLinkedList <Integer>();
   		//LinkedList<Integer>ll=newLinkedList<Integer>();
   		ll3.addFirst(0);
   		System.out.println(ll3);
   		ll3.addFirst(1);
   		System.out.println(ll3);
   		ll3.addFirst(3);
   		System.out.println(ll3);
   		ll3.addFirst(4);
   		System.out.println(ll3);
   		ll3.addFirst(5);
   		System.out.println(ll3);
   		ll3.add(3, 2);
   		System.out.println(ll3);
   		ll3.addFirst(-100);
   		System.out.println(ll3);
   		ll3.addLast(100);
   		System.out.println(ll3);
   		ll3.removeFirst();
   		System.out.println(ll3);
   		ll3.removeLast();
   		System.out.println(ll3);
   		
   		//Removestheiteminthespecifiedindex
   		ll3.remove(2);
   		System.out.println(ll3);
   		ll3.removeFirst();
   		System.out.println(ll3);
   		ll3.removeLast();
   		System.out.println(ll3);
   		ll3.removeFirst();
   		System.out.println(ll3);
   		ll3.addFirst(9999);
   		System.out.println(ll3);
   		ll3.addFirst(8888);
   		System.out.println(ll3);
   		ll3.addFirst(7777);
   		System.out.println(ll3);
   		System.out.println(ll3.get(0));
   		System.out.println(ll3.get(1));
   		System.out.println(ll3.get(2));
   		System.out.println(ll3);
	}

	
}
