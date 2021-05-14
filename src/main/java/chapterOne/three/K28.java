package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K28<Item>{

	private static class Node<Item2> {
		Item2 item;
		Node next;
	}
	
	private Node first;
	private Node last;
	private int N;
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		Item item = (Item) first.item;
		first = first.next;
		return item;
	}
	
	public static int max(Node<Integer> node) {
		if (node.next == null) {
			return node.item;
		} else {
			int result = max(node.next);
			return result > node.item ? result : node.item;
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> a1=new Node<Integer>();
	    a1.item=1;
		Node<Integer> a2=new Node<Integer>();
        a2.item=2;
        Node<Integer> a3=new Node<Integer>();
        a3.item=3;
        Node<Integer> a4=new Node<Integer>();
        a4.item=5;
        Node<Integer> a5=new Node<Integer>();
        a5.item=4;
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        int max = max(a1);
        StdOut.println(max);
	}
}
