package self.preparation.stack;

import java.util.EmptyStackException;

public class LinkedListStack {
	
	class Node{
		int data;
		Node next;
	    Node(int data) {
	    	this.data = data;
	    	next = null;
		}
	}
	
	public Node head;
	public LinkedListStack() {
		this.head = null;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public void push(int item){
		if(this.head == null){
			head = new Node(item);
		}
		Node nodeToPush = new Node(item);
		nodeToPush.next = head;
		head = nodeToPush;
	}

	public int pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		int poppedItem = this.head.data;
		this.head = this.head.next;
		return poppedItem;
	}
	
	public int top(){
		if(this.head == null){
			System.out.println("Stack is empty, nothing to get data");
			return -1;
		}else{
			return this.head.data;
		}
	}
	
	public void deleteStack(){
		this.head = null;
	}
	
	public static void main(String[] args) {
		LinkedListStack llStack = new LinkedListStack();
		llStack.head = null;
		System.out.println("Going to push element in stack.");
		llStack.push(10);
		llStack.push(20);
		llStack.push(30);
		llStack.push(40);
		llStack.push(50);
		System.out.println("Going to pop elements from stack.");
		System.out.println("Popped Item is: "+ llStack.pop());
		System.out.println("Popped Item is: "+ llStack.pop());
		System.out.println("Popped Item is: "+ llStack.pop());
		System.out.println("Popped Item is: "+ llStack.pop());
		System.out.println("Popped Item is: "+ llStack.pop());
		System.out.println("Going to delete stack.");
		llStack.deleteStack();
		System.out.println("Stack deleted.");
		System.out.println(llStack.top());

	}

}
