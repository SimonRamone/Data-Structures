package projectCode20280;

public class LinkedDeque<E> implements Deque<E> {
	
	DoublyLinkedList<E> list = new DoublyLinkedList<E>();

	public static void main(String[] args) {
		LinkedDeque<Integer> D = new LinkedDeque<Integer>();
		D.addFirst(1);
		D.addLast(2);
		D.addFirst(3);
		D.addLast(4);
		D.addFirst(5);
		D.addLast(6);
		System.out.println(D);
		System.out.println(D.removeFirst());
		System.out.println(D);
		System.out.println(D.removeLast());
		System.out.println(D);
		System.out.println(D.size());
		System.out.println(D.isEmpty());
		System.out.println(D.first());
		System.out.println(D.last());
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E first() {
		return list.get(0);
	}

	@Override
	public E last() {
		return list.get(list.size()-1);
	}

	@Override
	public void addFirst(E e) {
		list.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		list.addLast(e);
	}

	@Override
	public E removeFirst() {
		return list.removeFirst();
	}

	@Override
	public E removeLast() {
		return list.removeLast();
	}
	
	public String toString() {
		return list.toString();
	}

}
