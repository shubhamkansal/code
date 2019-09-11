package com.kansal.testprj;

import java.util.HashMap;
import java.util.Map;

public class TreeRightView {
	
static class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		left=right=null;
	}
}

static Node root;
static int max_level = 0;

void RightView(Node root) {
	if(root == null) {
		return;
	}
	PrintRightView(root, 1);
}

static void PrintRightView(Node curr, int level) {
	if(curr == null) {
		return;
	}
	if(max_level < level) {
		System.out.print(curr.data + " ");
		max_level = level;
	}
	PrintRightView(curr.right, level+1);
	PrintRightView(curr.left, level+1);
}
	
public static void main(String args[]) {
	 TreeRightView tree = new TreeRightView(); 
     tree.root = new Node(12); 
     tree.root.left = new Node(10); 
     tree.root.right = new Node(30); 
     tree.root.right.left = new Node(25); 
     tree.root.right.right = new Node(40); 

     tree.RightView(root); 

	
}

}
