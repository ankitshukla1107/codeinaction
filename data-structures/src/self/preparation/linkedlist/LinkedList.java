package self.preparation.linkedlist;

public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	private static void traverseLinkedList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	private static int getListLength(Node head) {
		Node current = head;
		int listLength = 0;
		while (current != null) {
			current = current.next;
			listLength++;
		}
		return listLength;
	}

	private static Node insertInLinkedList(Node head, Node nodeToInsert,
			int position) {
		int size = getListLength(head);
		if (position < 1 || position > size + 1) {
			return head;
		}
		if (position == 1) { // insert node at beginning
			nodeToInsert.next = head;
			head = nodeToInsert;
		} else {
			// insert node at middle or end
			Node previousNode = head;
			int count = 1;
			while (count < position) {
				previousNode = previousNode.next;
				count++;
			}
			Node currentNode = previousNode.next;
			nodeToInsert.next = currentNode;
			previousNode.next = nodeToInsert;
		}
		return head;
	}

	private static Node deleteFromLinkedList(Node head, int position) {
		int size = getListLength(head);
		if (position < 1 || position > size + 1) {
			return head;
		}
		if (position == 1) { // delete node at beginning
			Node current = head;
			head = current.next;
			current = null;
		} else {
			int count = 1;
			Node previous = head;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}
			Node current = previous.next;
			previous.next = current.next;
			current = null;
		}
		return head;
	}
	
	private static Node reverseLinkedList(Node head){
		Node temp = null;
		Node nextNode = null;
		while(head!=null){
			nextNode = head.next;
			head.next = temp;
			temp = head;
			head = nextNode; 
		}
		return head;
	}
	
	// Basic operations on List
	public static void main(String[] args) {
		// Populating the Linked List
		LinkedList linkedList = new LinkedList();
		linkedList.head = new Node(12);
		linkedList.head.next = new Node(14);
		linkedList.head.next.next = new Node(16);
		linkedList.head.next.next.next = new Node(18);

		/*System.out.println("Going to traverse Linked List: ");
		traverseLinkedList(linkedList.head);

		System.out.println("Inserting Node at beginning...");
		Node nodeToInsert = new Node(10);
		int beginning = 1;
		Node newheadAfterInsertionAtBeginning = insertInLinkedList(
				linkedList.head, nodeToInsert, beginning);
		System.out
				.println("Going to traverse Linked List after insertion at beginning: ");
		traverseLinkedList(newheadAfterInsertionAtBeginning);

		System.out.println("Inserting Node at middle...");
		Node nodeToInsertAtMiddle = new Node(15);
		int middle = 3;
		Node newHeadAferInsertionAtMiddle = insertInLinkedList(linkedList.head,
				nodeToInsertAtMiddle, middle);
		System.out
				.println("Going to traverse Linked List after insertion at middle: ");
		traverseLinkedList(newHeadAferInsertionAtMiddle);

		System.out.println("Inserting Node at End...");
		Node nodeToInsertAtEnd = new Node(20);
		int end = 4;
		Node newHeadAferInsertionAtEnd = insertInLinkedList(linkedList.head,
				nodeToInsertAtEnd, end);
		System.out
				.println("Going to traverse Linked List after insertion at end: ");
		traverseLinkedList(newHeadAferInsertionAtEnd);

		System.out.println("Deleting Node at beginning...");
		Node nodeAfterDeleteAtBeg = deleteFromLinkedList(linkedList.head, 1);
		System.out
				.println("Going to traverse linked list after deletion at beginning...");
		traverseLinkedList(nodeAfterDeleteAtBeg);

		System.out.println("Deleting Node at middle...");
		Node nodeAfterDeleteAtMiddle = deleteFromLinkedList(linkedList.head, 3);
		System.out
				.println("Going to traverse linked list after deletion at middle...");
		traverseLinkedList(nodeAfterDeleteAtMiddle);

		System.out.println("Deleting Node at end...");
		Node nodeAfterDeleteAtEnd = deleteFromLinkedList(linkedList.head, 4);
		System.out
				.println("Going to traverse linked list after deletion at middle...");
		traverseLinkedList(nodeAfterDeleteAtEnd);*/
		
		Node newHead = reverseLinkedList(linkedList.head);
		traverseLinkedList(newHead);
	}
}
