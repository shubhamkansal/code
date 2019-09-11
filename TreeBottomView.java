package com.kansal.testprj;

import java.util.LinkedList;
import java.util.Queue;

import com.kansal.testprj.TreeRightView.Node;

import java.util.*;

public class TreeBottomView {
	static class Node{
		int data;
		Node left,right;
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
	static Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
	
	void BottomView(Node root) {
		if(root == null) {
			return;
		}
		q.add(new Queueobj(root, 1));
		m.put(1, root.data);
		while(!q.isEmpty()) {
			Queueobj curr = q.poll();
			m.put(curr.hd, curr.node.data);
			if(curr.node.left != null) {
				q.add(new Queueobj(curr.node.left, curr.hd-1));
			}
			if(curr.node.right != null) {
				q.add(new Queueobj(curr.node.right, curr.hd+1));
			}
		}
		for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
			System.out.print(entry.getValue()+ " ");
		}
	}
	
	public static void main(String args[]) {
		    TreeBottomView tree = new TreeBottomView(); 
		    tree.root = new Node(20); 
	        tree.root.left = new Node(8); 
	        tree.root.right = new Node(22); 
	        tree.root.left.left = new Node(5); 
	        tree.root.left.right = new Node(3); 
	        tree.root.right.left = new Node(4); 
	        tree.root.right.right = new Node(25); 
	        tree.root.left.right.left = new Node(10); 
	        tree.root.left.right.right = new Node(14); 
	        System.out.println("Bottom view of the given binary tree:"); 
	        tree.BottomView(tree.root); 
	}

}
