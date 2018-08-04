package self.preparation.tree;

import self.preparation.tree.BinaryTree.BinaryTreeNode;

public class BinarySearchTree {
	
	static class BinarySearchTreeNode{
		int data;
		BinarySearchTreeNode left;
		BinarySearchTreeNode right;
		
		public BinarySearchTreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	BinarySearchTreeNode root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	private void inOrderTraversal(BinarySearchTreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}
	
	private BinarySearchTreeNode search(BinarySearchTreeNode root, int item){
		if(root==null){
			return null;
		}
		while(root!=null){
			if(item<root.data){
				root = root.left;
			}else if(item>root.data){
				root = root.right;
			}else if(item==root.data){
				System.out.println("item found");
				break;
			}
		}
		return root;
	}
	
	private int findMinimum(BinarySearchTreeNode root){
		int min = 0;
		if(root==null){
			System.out.println("tree is empty");
		}
		while(root.left!=null){
			root = root.left;
			min = root.data;
		}
		return min;
	}
	
	private BinarySearchTreeNode insert(BinarySearchTreeNode root, int item){
		if(root==null){
			root = new BinarySearchTreeNode(item);
		}else{
			if(item<root.data){
				root.left = insert(root.left,item);
			}else if(item>root.data){
				root.right = insert(root.right, item);
			}
		}
		return root;
	}
	
	 // To keep tract of previous node in Inorder Traversal
    BinarySearchTreeNode prev;
 
    private boolean isBST()  {
        prev = null;
        return isBST(root);
    }
 
    /* Returns true if given search tree is binary
       search tree (efficient version) */
    boolean isBST(BinarySearchTreeNode node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;
 
            // allows only distinct values node
            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
    
	/*
	 * Function to find LCA of n1 and n2. The function assumes that both n1 and
	 * n2 are present in BST
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


	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new BinarySearchTreeNode(10);
		bst.root.left = new BinarySearchTreeNode(8);
		bst.root.right = new BinarySearchTreeNode(12);
		bst.root.left.left = new BinarySearchTreeNode(6);
		bst.root.left.right = new BinarySearchTreeNode(9);
		bst.root.right.left = new BinarySearchTreeNode(11);
		bst.root.right.right = new BinarySearchTreeNode(13);
		
		//bst.inOrderTraversal(bst.root);
		//System.out.println(bst.search(bst.root, 9).data);
		//System.out.println(bst.findMinimum(bst.root));
		//BinarySearchTreeNode newRoot = bst.insert(bst.root, 5);
		//bst.inOrderTraversal(newRoot);
		// System.out.println(bst.isBST());
		System.out.println(bst.lca(bst.root, 11, 13).data);
	}

}
