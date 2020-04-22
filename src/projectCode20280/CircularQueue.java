package projectCode20280;

public class CircularQueue<E> implements Queue<E> {

	public static int rear, front;
	public static int N;   //array size
	public static int size = 0;   //queue size
	public E[] queue;	
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int n) {
		front = 0;
		rear = 0;
		N = n;
		queue = (E[])new Object[N];
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
		if(size() < N) {
			rear = (front + size()) % N; 
			queue[rear] = e;
			rear++;
			size++;
		} else System.out.println("Queue is full.");
	}

	@Override
	public E first() {
		return queue[front];
	}
	

	public E last() {
		return queue[rear-1];
	}

	@Override
	public E dequeue() {
		E firstElement = queue[front];
		front = (front + 1) % N;
		size--;
		return firstElement;
	}
	
	public String toString() {
		int index = front;
		String str = "";
		if(rear > front) {
			while(index < rear) {
			str += queue[index] + " ";
			index++;
			}
		}
		else {
				while(index < N) {
					str += queue[index] + " ";
					index++;
				}
				index = 0;
				while(index < rear) {
					str += queue[index] + " ";
					index++;
				}
			}
		return str;
	}
	
	
	public static void main(String[] args) {
		int n = 6;
		CircularQueue<Integer> q = new CircularQueue<Integer>(n);
		
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
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		
		System.out.println(q);
		System.out.println(q.first());
		System.out.println(q.last());
		
		
	}
}
