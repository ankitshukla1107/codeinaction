import java.util.HashMap;
import java.util.Map;

class Node {
	int key;
	int value;
	Node previous;
	Node next;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class LRUImplementation {
	int capacity;
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	LRUImplementation(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			delete(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void delete(Node node) {
		if (node.previous != null) {
			node.previous.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.previous = node.previous;
		} else {
			end = node.previous;
		}
	}

	public void setHead(Node node) {
		node.next = head;
		node.previous = null;

		if (head != null)
			head.previous = node;

		head = node;

		if (end == null)
			end = head;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			// update the old value
			Node old = map.get(key);
			old.value = value;
			delete(old);
			setHead(old);
		} else {
			Node newNode = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				// remove last node
				delete(end);
				setHead(newNode);
			} else {
				setHead(newNode);
			}
			map.put(key, newNode);
		}
	}

	public static void main(String arg[]) {

		LRUImplementation lrucache = new LRUImplementation(3);
//		lrucache.set(1, 100);
//		lrucache.set(10, 99);
//		lrucache.set(15, 98);
//		System.out.println(lrucache.get(10));
//		lrucache.set(20, 97);
//		System.out.println(lrucache.get(15));
//		System.out.println(lrucache.get(10));
		
		  lrucache.set(10, 97); 
		  lrucache.set(12, 96); 
		  lrucache.set(18, 95);
		  lrucache.set(1, 94);
		  lrucache.set(15, 93);

		 

		
		  System.out.println(lrucache.get(1)); 
		  System.out.println(lrucache.get(18));
		  System.out.println(lrucache.get(12));
		 

	}
}
