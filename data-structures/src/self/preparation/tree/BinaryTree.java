package self.preparation.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {

	static class BinaryTreeNode {

		private int data;
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		int hd;

		public BinaryTreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	BinaryTreeNode root;

	public BinaryTree() {
		root = null;
	}

	private void preOrderTraversal(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	private void inOrderTraversal(BinaryTreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}

	private void postOrderTraversal(BinaryTreeNode root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}

	private void levelOrderTraversal(BinaryTreeNode root) {
		Queue queue = new LinkedList();
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = (BinaryTreeNode) queue.poll();
			// process current node
			System.out.println(temp.data);

			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private int sizeOfBinaryTree(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return sizeOfBinaryTree(root.left) + 1 + sizeOfBinaryTree(root.right);
	}

	private BinaryTreeNode deleteBinaryTree(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		deleteBinaryTree(root.left);
		deleteBinaryTree(root.right);
		root = null;
		return root;
	}

	private void levelOrderTraversalInReverse(BinaryTreeNode root) {
		Queue queue = new LinkedList();
		LinkedList stack = new LinkedList();
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = (BinaryTreeNode) queue.poll();
			stack.push(temp.data);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private int heightOrDepthOfBinaryTree(BinaryTreeNode root) {
		int heightOrDepth, leftHeightOrDepth, rightHeightOrDepth;
		if (root == null) {
			heightOrDepth = 0;
		} else {
			leftHeightOrDepth = heightOrDepthOfBinaryTree(root.left);
			rightHeightOrDepth = heightOrDepthOfBinaryTree(root.right);
			heightOrDepth = (leftHeightOrDepth > rightHeightOrDepth) ? leftHeightOrDepth + 1
					: rightHeightOrDepth + 1;
		}
		return heightOrDepth;
	}

	private void printLevelOrderLineByLine(BinaryTree tree) {
		int height = tree.heightOrDepthOfBinaryTree(tree.root);
		if (height > 0) {
			for (int i = 0; i <= height; i++) {
				printGivenLevelRecursively(tree.root, i);
				System.out.println();
			}
		}

	}

	private void printGivenLevelRecursively(BinaryTreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data);
		} else if (level > 1) {
			printGivenLevelRecursively(root.left, level - 1);
			printGivenLevelRecursively(root.right, level - 1);
		}
	}

	/*
	 * Given a binary tree, print out all of its root-to-leaf paths, one per
	 * line. Uses a recursive helper to do the work.
	 */
	void printPaths(BinaryTreeNode node) {
		int path[] = new int[1000];
		printPathsRecur(node, path, 0);
	}

	/*
	 * Recursive helper function -- given a node, and an array containing the
	 * path from the root node up to but not including this node, print out all
	 * the root-leaf paths.
	 */
	void printPathsRecur(BinaryTreeNode node, int path[], int pathLen) {
		if (node == null)
			return;

		/* append this node to the path array */
		path[pathLen] = node.data;
		pathLen++;

		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null)
			printArray(path, pathLen);
		else {
			/* otherwise try both subtrees */
			printPathsRecur(node.left, path, pathLen);
			printPathsRecur(node.right, path, pathLen);
		}
	}

	/* Utility function that prints out an array on a line. */
	void printArray(int ints[], int len) {
		int i;
		for (i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println("");
	}

	/*
	 * Given a tree and a sum, return true if there is a path from the root down
	 * to a leaf, such that adding up all the values along the path equals the
	 * given sum.
	 * 
	 * Strategy: subtract the node value from the sum when recurring down, and
	 * check to see if the sum is 0 when you run out of tree.
	 */

	boolean haspathSum(BinaryTreeNode node, int sum) {
		if (node == null)
			return (sum == 0);
		else {
			boolean ans = false;

			/* otherwise check both subtrees */
			int subsum = sum - node.data;
			if (subsum == 0 && node.left == null && node.right == null)
				return true;
			if (node.left != null)
				ans = ans || haspathSum(node.left, subsum);
			if (node.right != null)
				ans = ans || haspathSum(node.right, subsum);
			return ans;
		}
	}

	private BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if (root != null) {
			mirrorOfBinaryTree(root.left);
			mirrorOfBinaryTree(root.right);
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	/*
	 * If target is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	private boolean printAncestors(BinaryTreeNode node, int target) {
		/* base cases */
		if (node == null)
			return false;

		if (node.data == target)
			return true;

		/*
		 * If target is present in either left or right subtree of this node,
		 * then print this node
		 */
		if (printAncestors(node.left, target)
				|| printAncestors(node.right, target)) {
			System.out.print(node.data + " ");
			return true;
		}

		/* Else return false */
		return false;
	}

	// Function to print all non-root nodes that don't have a sibling
	private void printSingles(BinaryTreeNode node) {
		// Base case
		if (node == null)
			return;

		// If this is an internal node, recur for left
		// and right subtrees
		if (node.left != null && node.right != null) {
			printSingles(node.left);
			printSingles(node.right);
		}

		// If left child is NULL and right is not, print right child
		// and recur for right child
		else if (node.right != null) {
			System.out.print(node.right.data + " ");
			printSingles(node.right);
		}

		// If right child is NULL and left is not, print left child
		// and recur for left child
		else if (node.left != null) {
			System.out.print(node.left.data + " ");
			printSingles(node.left);
		}
	}

	private void printSpiral(BinaryTreeNode node) {
		if (node == null)
			return; // NULL check

		// Create two stacks to store alternate levels
		Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();// For levels to
																// be printed
																// from right to
																// left
		Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();// For levels to
																// be printed
																// from left to
																// right

		// Push first level to first stack 's1'
		s1.push(node);

		// Keep ptinting while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty()) {
				BinaryTreeNode temp = s1.peek();
				s1.pop();
				System.out.print(temp.data + " ");

				// Note that is right is pushed before left
				if (temp.right != null)
					s2.push(temp.right);

				if (temp.left != null)
					s2.push(temp.left);

			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty()) {
				BinaryTreeNode temp = s2.peek();
				s2.pop();
				System.out.print(temp.data + " ");

				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

	static int max_level = 0;

	// recursive function to print left view
	/*
	 * The problem can also be solved using simple recursive traversal. We can
	 * keep track of level of a node by passing a parameter to all recursive
	 * calls. The idea is to keep track of maximum level also. Whenever we see a
	 * node whose level is more than maximum level so far, we print the node
	 * because this is the first node in its level (Note that we traverse the
	 * left subtree before right subtree). Following is the implementation-
	 */
	private void leftViewUtil(BinaryTreeNode node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	// A wrapper over leftViewUtil()
	void leftView() {
		leftViewUtil(root, 1);
	}

	/*
	 * Bottom View of a Binary Tree Given a Binary Tree, we need to print the
	 * bottom view from left to right. A node x is there in output if x is the
	 * bottommost node at its horizontal distance. Horizontal distance of left
	 * child of a node x is equal to horizontal distance of x minus 1, and that
	 * of right child is horizontal distance of x plus 1.
	 */

	// Method that prints the bottom view.
	public void bottomView() {
		if (root == null)
			return;

		// Initialize a variable 'hd' with 0 for the root element.
		int hd = 0;

		// TreeMap which stores key value pair sorted on key value
		Map<Integer, Integer> map = new TreeMap<>();

		// Queue to store tree nodes in level order traversal
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

		// Assign initialized horizontal distance value to root
		// node and add it to the queue.
		root.hd = hd;
		queue.add(root);

		// Loop until the queue is empty (standard level order loop)
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();

			// Extract the horizontal distance value from the
			// dequeued tree node.
			hd = temp.hd;

			// Put the dequeued tree node to TreeMap having key
			// as horizontal distance. Every time we find a node
			// having same horizontal distance we need to replace
			// the data in the map.
			map.put(hd, temp.data);

			// If the dequeued node has a left child add it to the
			// queue with a horizontal distance hd-1.
			if (temp.left != null) {
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}
			// If the dequeued node has a left child add it to the
			// queue with a horizontal distance hd+1.
			if (temp.right != null) {
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}

		// Extract the entries of map into a set to traverse
		// an iterator over that.
		Set<Entry<Integer, Integer>> set = map.entrySet();

		// Make an iterator
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();

		// Traverse the map elements using the iterator.
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}

	class Values {
		int max, min;
	}

	Values val = new Values();

	// A utility function to find min and max distances with respect
	// to root.
	void findMinMax(BinaryTreeNode node, Values min, Values max, int hd) {
		// Base case
		if (node == null)
			return;

		// Update min and max
		if (hd < min.min)
			min.min = hd;
		else if (hd > max.max)
			max.max = hd;

		// Recur for left and right subtrees
		findMinMax(node.left, min, max, hd - 1);
		findMinMax(node.right, min, max, hd + 1);
	}

	// A utility function to print all nodes on a given line_no.
	// hd is horizontal distance of current node with respect to root.
	void printVerticalLine(BinaryTreeNode node, int line_no, int hd) {
		// Base case
		if (node == null)
			return;

		// If this node is on the given line number
		if (hd == line_no)
			System.out.print(node.data + " ");

		// Recur for left and right subtrees
		printVerticalLine(node.left, line_no, hd - 1);
		printVerticalLine(node.right, line_no, hd + 1);
	}

	// The main function that prints a given binary tree in
	// vertical order
	void verticalOrder(BinaryTreeNode node) {
		// Find min and max distances with resepect to root
		findMinMax(node, val, val, 0);

		// Iterate through all possible vertical lines starting
		// from the leftmost line and print nodes line by line
		for (int line_no = val.min; line_no <= val.max; line_no++) {
			printVerticalLine(node, line_no, 0);
			System.out.println("");
		}
	}
	
	// head --> Pointer to head node of created doubly linked list
    BinaryTreeNode head;
      
    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static BinaryTreeNode prev = null;
  
    // A simple recursive function to convert a given Binary tree 
    // to Doubly Linked List
    // root --> Root of Binary Tree
    private void binaryTree2DoubleLinkedList(BinaryTreeNode root) 
    {
        // Base case
        if (root == null)
            return;
  
        // Recursively convert left subtree
        binaryTree2DoubleLinkedList(root.left);
  
        // Now convert this node
        if (prev == null) 
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
  
        // Finally convert right subtree
        binaryTree2DoubleLinkedList(root.right);
    }
  
    /* Function to print nodes in a given doubly linked list */
    void printList(BinaryTreeNode node)
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);
		tree.root.right.left = new BinaryTreeNode(6);
		tree.root.right.right = new BinaryTreeNode(7);
		// tree.preOrderTraversal(tree.root);
		// tree.inOrderTraversal(tree.root);
		// tree.postOrderTraversal(tree.root);
		// tree.levelOrderTraversal(tree.root);
		/*
		 * BinaryTreeNode root = tree.deleteBinaryTree(tree.root);
		 * System.out.println("size of binary tree is: " +
		 * tree.sizeOfBinaryTree(root));
		 */

		// tree.levelOrderTraversalInReverse(tree.root);
		// System.out.println(tree.heightOrDepthOfBinaryTree(tree.root));
		// tree.printLevelOrderLineByLine(tree);
		// tree.printPaths(tree.root);
		// tree.levelOrderTraversal(tree.mirrorOfBinaryTree(tree.root));
		// tree.printAncestors(tree.root, 7);
		// tree.printSingles(tree.root);
		// tree.printSpiral(tree.root);
		// tree.leftView();
		// tree.bottomView();
		// tree.verticalOrder(tree.root);
		tree.binaryTree2DoubleLinkedList(tree.root);
		tree.printList(tree.head);
	}
}
