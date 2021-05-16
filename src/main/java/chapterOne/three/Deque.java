package chapterone.three;

import java.util.Iterator;


/**
 * 双向链表实现
 * @author gxx
 *
 * @param <Item>
 */

/*
 * ----------------------------------------------------
 * public class Deque<Item> implements Iterable<Item>
 * ----------------------------------------------------
 * 		Deque()					创建空双向队列
 * 		boolean isEmpty()		双向队列是否为空
 * 		int size()				双向队列中元素的数量
 * 		void pushLeft(Item item)向左端添加一个新元素
 * 		void pushRight(Item item)向右端添加一个新元素
 * 		Item popLeft()			从左端删除一个元素
 * 		Item popRight()			从右端删除一个元素
 * -----------------------------------------------------
 */

public class Deque<Item> implements Iterable<Item> {
	
	private class Node {
		public Item item;
		public Node prev;
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
	
	public void pushLeft(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		first.prev = null;
		if (oldfirst == null) {
			last = first;
		} else {
			oldfirst.prev = first;
		}
		N++;
	}
	
	public void pushRight(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldlast;
		if (oldlast == null) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
	}
	
	public Item popLeft() {
		Item item = first.item;
		first = first.next;
		if (first == null) {
			last = null;
		} else {
			first.prev = null;
		}
		N--;
		return item;
	}
	
	public Item popRight() {
		Item item = last.item;
		last = last.prev;
		if (last == null) {
			first = null;
		} else {
			last.next = null;
		}
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
			Item item = (Item) current.item;
			current = current.next;
			return item;
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
		s += (first == null ? null : first.item) + " " + (last == null ? null : last.item);
		s += "\n";
		return s;
	}
}
