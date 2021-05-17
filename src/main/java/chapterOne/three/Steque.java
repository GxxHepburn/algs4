package chapterone.three;

import java.util.Iterator;

/**
 * ---------------------------------------------------- public class
 * Steque<Item> implements Iterable<Item>
 * ---------------------------------------------------- boolean isEmpty(); int
 * size(); void push(Item item); 添加一个元素到头部 Item pop() 从头部删除一个元素 void
 * enqueue(Item e) 添加一个元素到尾部
 * 
 * @author gxx
 *
 */

public class Steque<Item> implements Iterable<Item> {

	private class Node {
		public Item item;
		public Node next;
	}

	private Node first;
	private Node last;
	private int N;

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {

		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (oldfirst == null) {
			last = first;
		}
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		if (first == null) {
			last = null;
		}
		N--;
		return item;
	}

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
	}
	
	/*
	 * 	K47
	 */
	public void catenation(Steque<Item> lastSteque) {
		Steque<Item> temp = new Steque<Item>();
		int lenght = lastSteque.size();
		for (int i = 0; i < lenght; i++) {
			temp.push(lastSteque.pop());
		}
		for (int i = 0; i < lenght; i++) {
			Item item = temp.pop();
			push(item);
			lastSteque.push(item);
		}
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

	@Override
	public String toString() {
		String s;
		s = "Size: " + N + "\n";
		for (Item Item : this) {
			s += (Item + " ");
		}
		s += "\n";
		s += "first: " + (first == null ? null : first.item) + " last: " + (last == null ? null : last.item);
		s += "\n";
		return s;
	}
}
