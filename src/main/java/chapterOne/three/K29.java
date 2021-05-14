package chapterone.three;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;


public class K29<Item> implements Iterable<Item> {

	public static void main(String[] args) {
		K29<Integer> q = new K29<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		q.dequeue();
		q.enqueue(5);
		q.enqueue(6);
		q.dequeue();
		q.enqueue(7);
		StdOut.println(q);
	}
	
	private Node last;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return last == null;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {

		private Node current = last == null ? null : last.next;
		private Node lastNode = current;
		private int l = 0;
		
		@Override
		public boolean hasNext() {
			l++;
			if (current == null) {
				return false;
			} else if (current == lastNode && l > 1) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public int size() {
		int l = 0;
		for (Item item : this) {
			l++;
		}
		return l;
	}
	
	public void enqueue(Item item) {
		if (last == null) {
			last = new Node();
			last.item = item;
			last.next = last;
			return;
		}
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = oldlast.next;
		oldlast.next = last;
	}
	
	public Item dequeue() {
		Item item = last.next.item;
		if (size() == 1) {
			last = null;
		} else {
			last.next = last.next.next;
		}
		return item;
	}

	@Override
	public String toString() {
		String s;
		s = "Size: " + size() + "\n";
		for (Item str : this) {
			s += (str + " ");
		}
		s += "\n";
		return s; 
	}
}
