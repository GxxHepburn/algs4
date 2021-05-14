package chapterone.three;

import chapterone.three.DoubleNode.Node;
import edu.princeton.cs.algs4.StdOut;

public class K31 {

	public static void main(String[] args) {
		DoubleNode<Integer> doubleNode = new DoubleNode<Integer>();
		doubleNode.insertBeforeHead(1);
		StdOut.print(doubleNode);
		doubleNode.insertBeforeHead(2);
		StdOut.print(doubleNode);
		doubleNode.insertAfterTail(3);
		doubleNode.insertBeforeHead(4);
		doubleNode.insertAfterTail(5);
		doubleNode.insertAfterTail(6);
		StdOut.println(doubleNode);
		doubleNode.deleteFromHead();
		doubleNode.deleteFromHead();
		StdOut.println(doubleNode);
		doubleNode.deleteFromTail();
		doubleNode.deleteFromTail();
		StdOut.println(doubleNode);
		Node<Integer> a7=new Node<Integer>();
	    a7.item=7;
		doubleNode.insertBeforeNode(1, a7);
		StdOut.println(doubleNode);
		Node<Integer> a8=new Node<Integer>();
	    a8.item=8;
		doubleNode.insertBeforeNode(3, a8);
		StdOut.println(doubleNode);
		Node<Integer> a9=new Node<Integer>();
	    a9.item=9;
		doubleNode.insertAfterNode(1, a9);
		StdOut.println(doubleNode);
		Node<Integer> a10=new Node<Integer>();
	    a10.item=10;
		doubleNode.insertAfterNode(5, a10);
		StdOut.println(doubleNode);
		doubleNode.deleteNode(1);
		StdOut.println(doubleNode);
		doubleNode.deleteNode(2);
		StdOut.println(doubleNode);
		doubleNode.deleteNode(3);
		StdOut.println(doubleNode);
		doubleNode.deleteNode(1);
		doubleNode.deleteNode(1);
		StdOut.println(doubleNode);
		doubleNode.deleteNode(1);
		StdOut.println(doubleNode);
	}
}
