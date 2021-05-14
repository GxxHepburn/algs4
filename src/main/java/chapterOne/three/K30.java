package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K30<Item> {

	private static class Node<Item2> {
		Item2 item;
		Node next;
	}
	
	private Node first;
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
	
	/**
	 * 迭代法
	 * @param x
	 * @return
	 */
	public static Node reverse(Node x) {
		Node first = x;
		Node reverse = null;
		while (first != null) {
			Node seconde = first.next;
			first.next = reverse;
			reverse = first;
			first = seconde;
		}
		return reverse;
	}
	
	/*
	 * 递归法
	 */
	public static Node reverse2(Node first) {
		if (first == null) {
			return null;
		}
		
		if (first.next == null) {
			return first;
		}
		
		Node second = first.next;
		Node rest = reverse(second);
		second.next = first;
		first.next = null;
		return rest;
	}
	
	public static void main(String[] args) {
		Node<Integer> a1=new Node<Integer>();
	    a1.item=1;
		Node<Integer> a2=new Node<Integer>();
        a2.item=2;
        Node<Integer> a3=new Node<Integer>();
        a3.item=3;
        Node<Integer> a4=new Node<Integer>();
        a4.item=4;
        Node<Integer> a5=new Node<Integer>();
        a5.item=5;
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        Node<Integer> newA1 = K30.reverse2(a1);
        StdOut.println(newA1.item);
        StdOut.println(newA1.next.item);
        StdOut.println(newA1.next.next.item);
        StdOut.println(newA1.next.next.next.item);
	}
}
