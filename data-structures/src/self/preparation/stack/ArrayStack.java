package self.preparation.stack;

public class ArrayStack {
	
	int top;
	int capacity;
	int arr[];
	public ArrayStack(int capacity) {
		top = -1;
		this.capacity = capacity;
		arr = new int[capacity];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public boolean isOverflow(){
		return top==capacity-1;
	}
	
	public void push(int item){
		if(isOverflow()){
			System.out.println("Stack Overflow.");
		}else{
			arr[++top] = item;
		}
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("Stack Underflow.");
			return 0;
		}else{
			return arr[top--];
		}
	}
	
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(10);
		System.out.println("Inserting elements onto stack.");
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			int value = stack.pop();
			System.out.println("Current popped element: "+ value);
		}
		
	}

}
