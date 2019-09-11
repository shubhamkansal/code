package com.kansal.testprj;

import java.util.LinkedList;
import java.util.Queue;

import com.kansal.testprj.TreeRightView.Node;

import java.util.*;

public class TreeTopView {
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	
	static class Queueobj{
		Node node;
		int hd;
		Queueobj(Node node, int hd){
			this.node = node;
			this.hd = hd;
		}
	}
	Node root;
	
	static Queue<Queueobj> q = new LinkedList<Queueobj>();
	
	static Map<Integer, Node> m = new TreeMap<Integer, Node>();	
	
	static void TopView(Node root) {
		
		if(root == null) {
			return;
		}
		m.put(0, root);
		q.add(new Queueobj(root, 0));
		
		while(!q.isEmpty()) {
			Queueobj curr = q.poll();
			
			if(!m.containsKey(curr.hd)) {
				m.put(curr.hd, curr.node);
			}
			if(curr.node.left != null) {
				q.add(new Queueobj(curr.node.left, curr.hd-1));
			}
			if(curr.node.right != null) {
			    q.add(new Queueobj(curr.node.right, curr.hd+1));
			}
		}
		for(Map.Entry<Integer, Node> entry: m.entrySet()) {
	    	 System.out.print(entry.getValue().data + " ");
	     }
	}
	
	public static void main(String args[]) {
		 TreeTopView tree = new TreeTopView(); 
	     tree.root = new Node(12); 
	     tree.root.left = new Node(10); 
	     tree.root.right = new Node(30); 
	     tree.root.right.left = new Node(25); 
	     tree.root.right.right = new Node(40); 

	     tree.TopView(tree.root); 
	}

}
