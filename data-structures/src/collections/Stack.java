package collections;

import java.util.EmptyStackException;
import java.util.stream.IntStream;

public class Stack<T> {

	final Object[] arr;
	int capacity = 5;
	int top = -1;
	
	public Stack() {
		arr = new Object[capacity];
	}
	
	public Stack(int capacity) {
		this.capacity = capacity;
		arr = new Object[capacity];
	}
	
	public void push(T data) {
		if(isFull()) {
			System.out.println("stack is full couldn't insert data");
			return;
		}
		arr[++top] = data;
		System.out.println(data+" inserted in stack");
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		Object data = arr[top--];
		System.out.println(data+" removed from stack");
	}
	
	public boolean isFull() {
		return (top + 1) == capacity;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) arr[top];
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		//value insertion
		IntStream.rangeClosed(0, 5).forEach(s::push);
		System.out.println("After insertion");
		System.out.println("is Stack full: "+s.isFull());
		System.out.println("is stack empty: "+s.isEmpty());
		
		IntStream.rangeClosed(0, 5).forEach(count->s.pop());
		System.out.println("After deletion");
		System.out.println("is stack full: "+s.isFull());
		System.out.println("is stack empty: "+s.isEmpty());
		
	}

}
