package self.preparation.tree;

public class BinarySearchTree {

	static class BinarySearchTreeNode {
		int data;
		BinarySearchTreeNode left;
		BinarySearchTreeNode right;

		public BinarySearchTreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static BinarySearchTreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	private void inOrderTraversal(BinarySearchTreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}

	private BinarySearchTreeNode search(BinarySearchTreeNode root, int item) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (item < root.data) {
				root = root.left;
			} else if (item > root.data) {
				root = root.right;
			} else if (item == root.data) {
				System.out.println("item found");
				break;
			}
		}
		return root;
	}

	private int findMinimum(BinarySearchTreeNode root) {
		int min = 0;
		if (root == null) {
			System.out.println("tree is empty");
		}
		while (root.left != null) {
			root = root.left;
			min = root.data;
		}
		return min;
	}

	private BinarySearchTreeNode insert(BinarySearchTreeNode root, int item) {
		if (root == null) {
			root = new BinarySearchTreeNode(item);
		} else {
			if (item < root.data) {
				root.left = insert(root.left, item);
			} else if (item > root.data) {
				root.right = insert(root.right, item);
			}
		}
		return root;
	}

	// To keep tract of previous node in Inorder Traversal
	BinarySearchTreeNode prev;

	private boolean isBST() {
		prev = null;
		return isBST(root);
	}

	/*
	 * Returns true if given search tree is binary search tree (efficient version)
	 */
	boolean isBST(BinarySearchTreeNode node) {
		// traverse the tree in inorder fashion and
		// keep a track of previous node
		if (node != null) {
			if (!isBST(node.left))
				return false;

			// allows only distinct values node
			if (prev != null && node.data <= prev.data)
				return false;
			prev = node;
			return isBST(node.right);
		}
		return true;
	}

	/*
	 * Function to find LCA of n1 and n2. The function assumes that both n1 and n2
	 * are present in BST
	 */
	private BinarySearchTreeNode lca(BinarySearchTreeNode node, int n1, int n2) {
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);

		return node;
	}

	class Info {
		int size; // Size of subtree
		int max; // Min value in subtree
		int min; // Max value in subtree
		int sizeOfLargestBST; // Size of largest BST which is subtree of current node
		boolean isBST; // If subtree is BST

		public Info(int size, int max, int min, int sizeOfLargestBST, boolean isBST) {
			this.size = size;
			this.max = max;
			this.min = min;
			this.sizeOfLargestBST = sizeOfLargestBST;
			this.isBST = isBST;
		}
	}

	Info largestBSTBT(BinarySearchTreeNode root) {
		if (root == null)
			return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);

		if (root.left == null && root.right == null)
			return new Info(1, root.data, root.data, 1, true);

		// Recur for left subtree and right subtrees
		Info left = largestBSTBT(root.left);
		Info right = largestBSTBT(root.right);

		// Create a return variable and initialize its size.
		Info result = new Info(0, 0, 0, 0, false);
		result.size = 1 + left.size + right.size;

		// If whole tree rooted under current root is BST.
		if (left.isBST && right.isBST && left.max < root.data && right.min > root.data) {
			result.min = Math.min(left.min, Math.min(right.min, root.data));
			result.max = Math.max(right.max, Math.max(left.max, root.data));

			// Update answer for tree rooted under
			// current 'root'
			result.sizeOfLargestBST = result.size;
			result.isBST = true;

			return result;
		}

		// If whole tree is not BST, return maximum of left and right subtrees
		result.sizeOfLargestBST = Math.max(left.sizeOfLargestBST, right.sizeOfLargestBST);
		result.isBST = false;
		return result;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new BinarySearchTreeNode(10);
		bst.root.left = new BinarySearchTreeNode(8);
		bst.root.right = new BinarySearchTreeNode(12);
		bst.root.left.left = new BinarySearchTreeNode(6);
		bst.root.left.right = new BinarySearchTreeNode(9);
		bst.root.right.left = new BinarySearchTreeNode(11);
		bst.root.right.right = new BinarySearchTreeNode(13);

		// bst.inOrderTraversal(bst.root);
		// System.out.println(bst.search(bst.root, 9).data);
		// System.out.println(bst.findMinimum(bst.root));
		// BinarySearchTreeNode newRoot = bst.insert(bst.root, 5);
		// bst.inOrderTraversal(newRoot);
		// System.out.println(bst.isBST());
		// System.out.println(bst.lca(bst.root, 11, 13).data);
		System.out.println(bst.largestBSTBT(root).sizeOfLargestBST);
	}

}
