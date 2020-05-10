package self.preparation.tree;

public class ConnectNodesAtSameLevel {

	static class Node {
		int data;
		Node left, right, nextRight;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
			nextRight = null;
		}
	}

	/* Sets nextRight of all nodes of a tree with root as p */
	static void connect(Node p) {
		if (p == null)
			return;

		// Set nextRight for root
		p.nextRight = null;

		// set nextRight of all levels one by one
		while (p != null) {
			Node q = p;

			/*
			 * Connect all childrem nodes of p and children nodes of all other nodes at same
			 * level as p
			 */
			while (q != null) {
				// Set the nextRight pointer for p's left child
				if (q.left != null) {

					// If q has right child, then right child is nextRight of
					// p and we also need to set nextRight of right child
					if (q.right != null)
						q.left.nextRight = q.right;
					else
						q.left.nextRight = getNextRight(q);
				}

				if (q.right != null)
					q.right.nextRight = getNextRight(q);

				// Set nextRight for other nodes in pre order fashion
				q = q.nextRight;
			}

			// start from the first node of next level
			if (p.left != null)
				p = p.left;
			else if (p.right != null)
				p = p.right;
			else
				p = getNextRight(p);
		}
	}

	/*
	 * This function returns the leftmost child of nodes at the same level as p.
	 * This function is used to getNExt right of p's right child If right child of
	 * is NULL then this can also be used for the left child
	 */
	static Node getNextRight(Node p) {
		Node temp = p.nextRight;

		/*
		 * Traverse nodes at p's level and find and return the first node's first child
		 */
		while (temp != null) {
			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;
			temp = temp.nextRight;
		}

		// If all the nodes at p's level are leaf nodes then return NULL
		return null;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.right = new Node(90);

		connect(root);
		// Let us check the values of nextRight pointers
		System.out.println("Following are populated nextRight pointers in \n"
				+ "the tree (-1 is printed if there is no nextRight)");
		System.out
				.println("nextRight of " + root.data + " is " + ((root.nextRight != null) ? root.nextRight.data : -1));
		System.out.println("nextRight of " + root.left.data + " is "
				+ ((root.left.nextRight != null) ? root.left.nextRight.data : -1));
		System.out.println("nextRight of " + root.right.data + " is "
				+ ((root.right.nextRight != null) ? root.right.nextRight.data : -1));
		System.out.println("nextRight of " + root.left.left.data + " is "
				+ ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1));
		System.out.println("nextRight of " + root.right.right.data + " is "
				+ ((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1));
	}

}
