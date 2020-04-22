package projectCode20280;

public class ArrayQueue<E> implements Queue<E> {

	public static int rear, front;
	public static int N;   //array size
	public E[] queue;	
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int n) {
		front = 0;
		rear = 0;
		N = n;
		queue = (E[])new Object[N];
	}

	@Override
	public int size() {
		return rear - front;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public void enqueue(E e) {
		if(rear < N) {
			queue[rear] = e;
			rear++;
		}
		else return;
	}

	@Override
	public E first() {
		return queue[front];
	}

	@Override
	public E dequeue() {
		if(front != rear) {
			E element = queue[front];
			front++;
			return element;
		}
		else return null;
	}
	
	public String toString() {
		int index = front;
		String str = "";
		while(index != rear) {
			str += queue[index] + " ";
			index++;
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		int n = 10;
		ArrayQueue<Integer> q = new ArrayQueue<Integer>(n);
		
		q.enqueue(1);
		
		System.out.println(q.first());
		
		System.out.println(q.isEmpty());
		
		q.enqueue(4);
		
		System.out.println(q);
		
		System.out.println("Size: " + q.size());
		
		System.out.println("dequeue: " + q.dequeue());
		
		System.out.println(q.first());
		
		System.out.println("dequeue: " + q.dequeue());
		
		System.out.println(q.isEmpty());
		
		System.out.println("Size: " + q.size());

	}
}
