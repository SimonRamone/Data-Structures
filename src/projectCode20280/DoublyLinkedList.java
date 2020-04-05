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
		return size==0?true:false;
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
			return curr != null;
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
	
	public String toString() {
		String str = "";
		Node<E> last = header.getNext();
		str += last.getElement();
		while(last.getNext().getElement() != null) {
			last = last.getNext();
			str += " " + last.getElement();
		}
		return str;
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
	}

	
}
