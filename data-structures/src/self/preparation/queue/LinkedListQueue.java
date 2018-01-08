package self.preparation.queue;

public class LinkedListQueue {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node frontNode;
	Node rearNode;

	public LinkedListQueue() {
		this.frontNode = null;
		this.rearNode = null;
	}

	public LinkedListQueue createLinkedListQueue() {
		return new LinkedListQueue();
	}

	public boolean isEmpty() {
		return frontNode == null;
	}

	public void enqueue(int item) {
		Node newNode = new Node(item);
		if (rearNode != null) {
			rearNode.next = newNode;
		}
		rearNode = newNode;
		if (frontNode == null) {
			frontNode = rearNode;
		}
	}

	public int dequeue() {
		int data;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			data = -1;
		} else {
			data = frontNode.data;
			frontNode = frontNode.next;
		}
		return data;
	}

	public static void main(String[] args) {
		LinkedListQueue linkedQueue = new LinkedListQueue();
		linkedQueue.enqueue(10);
		linkedQueue.enqueue(20);
		linkedQueue.enqueue(30);
		linkedQueue.enqueue(40);
		linkedQueue.enqueue(50);

		System.out.println("Going to dequeue item");
		System.out.println("Current deque item is: " + linkedQueue.dequeue());
		System.out.println("Current deque item is: " + linkedQueue.dequeue());
		System.out.println("Current deque item is: " + linkedQueue.dequeue());
		System.out.println("Current deque item is: " + linkedQueue.dequeue());
		System.out.println("Current deque item is: " + linkedQueue.dequeue());
	}
}
