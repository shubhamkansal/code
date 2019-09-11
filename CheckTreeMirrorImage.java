package com.kansal.testprj;

import com.kansal.testprj.TreeTopView.Node;

public class CheckMirrorImages {
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	Node root1, root2;
	boolean CheckMirror(Node n1, Node n2){
		if(n1 == null && n2 == null) {
			return true;
		}
		if(n1 == null || n2 == null) {
			return false;
		}
		return n1.data == n2.data && CheckMirror(n1.left, n2.right) && CheckMirror(n1.right, n2.left);
	}
	public static void main(String args[]) {
		CheckMirrorImages tree = new CheckMirrorImages(); 
	     tree.root1 = new Node(12); 
	     tree.root1.left = new Node(10); 
	     tree.root1.right = new Node(30); 
	     tree.root1.right.left = new Node(25); 
	     tree.root1.right.right = new Node(40); 
	     
	     tree.root2 = new Node(12); 
	     tree.root2.left = new Node(10); 
	     tree.root2.right = new Node(30); 
	     tree.root2.right.left = new Node(25); 
	     tree.root2.right.right = new Node(40);

	     System.out.println(tree.CheckMirror(tree.root1, tree.root2));
	}

}
