package projectCode20280;

public class ArrayStack<E> implements Stack<E> {

	public static final int N = 1000; 	//array capacity
	private E[] data;					//generic array used for storage
	private int t = -1;					//index of the top element in stack
	
	public ArrayStack() {
		this(N); 						//constructs stack with default capacity
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int n) {			//constructs stack with given capacity
		data = (E[]) new Object[n];		//safe cast
	}

	public static void main(String[] args) {
		ArrayStack<Integer> S = new ArrayStack<Integer>();
		System.out.println(S.isEmpty());
		S.push(1);
		System.out.println(S);
		System.out.println(S.isEmpty());
		S.push(2);
		S.push(3);
		System.out.println(S);
		System.out.println(S.size());
		S.push(4);
		S.push(5);
		System.out.println(S);
		System.out.println(S.pop());
		System.out.println(S);
		S.pop();
		S.pop();
		System.out.println(S);
		System.out.println(S.top());
		S.pop();
		S.pop();
		System.out.println(S.isEmpty());
		System.out.println(S.size());
	}

	@Override
	public int size() {
		return t + 1;
	}

	@Override
	public boolean isEmpty() {
		return t == -1;
	}

	@Override
	public void push(E e) {
		if(size() == N) System.out.println("Stack is full.");
		else{
			t++;
			data[t] = e;
		}
	}

	@Override
	public E top() {
		if(isEmpty()) return null;
		else return data[t];
	}

	@Override
	public E pop() {
		if(isEmpty()) return null;
		else {
			E valueAtTopOfStack = data[t];
			t--;
			return valueAtTopOfStack;
		}
	}
	
	public String toString() {
		String str = "";
		int index = t;
		while(index >= 0) {
			str += data[index] + " ";
			index--;
		}
		return str;
	}

}
