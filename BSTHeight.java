package com.kansal.testprj;

import com.kansal.testprj.TreeBottomView.Node;

public class TreeHeight {
	
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	Node root;
	
	int Height(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(Height(root.left), Height(root.right));
		
	}
	
	public static void main(String args[]) {
		TreeHeight tree = new TreeHeight(); 
	    tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(5); 
        tree.root.left.right = new Node(3); 
        tree.root.right.left = new Node(4); 
        tree.root.right.right = new Node(25); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        System.out.println("Height of the given binary tree: " + tree.Height(tree.root)); 
	}

}
