package chapterone.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class K26<Item> implements Iterable<Item> {
	
	private class Node {
		Item item;
		Node next;
	}
	
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public Item delete(int k) {
		Node current = first;
		for (int i = 1; i < this.size(); i++) {
			if (i == k-1) {
				Node kNode = current.next;
				current.next = kNode.next;
				N--;
				return kNode.item;
			}
		}
		throw new NoSuchElementException("链表元素少于k个!");
	}
	
	public void remove(String item) {
		Node current = first;
		while (current.next != null) {
			if (current.next.item.equals(item)) {
				current.next = current.next.next;
				N--;
			} else {
				current = current.next;
			}
		}
		if (first.item.equals(item)) {
			first = first.next;
			N--;
		}
	}
	
	@Override
	public String toString() {
		String s;
		s = "Size: " + N + "\n";
		for (Item item : this) {
			s += (item + " ");
		}
		s += "\n";
		return s;
	}

	public static void main(String[] args) {
		K26<String> k26 = new K26<String>();
		k26.push("1");
		k26.push("1");
		k26.push("1");
		k26.push("2");
		k26.push("1");
		k26.push("1");
		k26.push("1");
		k26.push("1");
		k26.push("1");
		StdOut.println(k26);
		k26.remove("1");
		StdOut.println(k26);
	}
}
