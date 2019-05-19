package self.preparation.queue;

public class ArrayQueue {
	
	int front, rear;
	int capacity;
	int arr[];
	
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		front = -1;
		rear = -1;
		arr = new int[capacity];
	}
	
	public ArrayQueue createArrayQueue(){
		return new ArrayQueue(capacity);
	}
	
	public boolean isEmpty(){
		return front==-1;
	}
	
	public boolean isFull(){
		return (rear+1)%capacity==front;
	}
	
	public void enqueue(int item){
		if(isFull()){
			System.out.println("Queue is full");
		}
		rear = (rear+1)%capacity;
		arr[rear] = item;
		if(front==-1){
			front = rear;
		}
	}

	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
		int item = arr[front];
		if(front==rear){
			front = rear-1;
		}
		front = (front+1)%capacity;
		return item;
	}
	
	public int getQueueSize(){
		return (capacity-front+rear+1)%capacity;
	}
	
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(10);
		System.out.println("Going to enqueue items.");
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		System.out.println("Going to dequeue item");
		int size = queue.getQueueSize();
		for (int i = 0; i < size; i++) {
			System.out.println("Current deque item is: "+queue.dequeue());
		}
		
		
	}

}
