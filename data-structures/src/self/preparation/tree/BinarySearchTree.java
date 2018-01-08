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
		BinarySearchTreeNode newRoot = bst.insert(bst.root, 5);
		bst.inOrderTraversal(newRoot);
	}

}
