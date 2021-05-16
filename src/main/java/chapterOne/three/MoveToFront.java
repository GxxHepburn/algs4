package chapterone.three;

import java.util.Iterator;

/**
 * 前移编码
 * @author gxx
 *
 */

/*
 * --------------------------------------------
 * 	public class MoveToFront<Item>
 * --------------------------------------------
 * 		boolean isEmpty()		判断链表是否为空
 * 		void add(Item item)		插入元素，并保持该元素唯一且位于链表头部
 */

public class MoveToFront<Item> implements Iterable<Item> {

	/**
	 * @param args
	 */
	private class Node {
		Item item;
		Node next;
	}
	
	private Node first;
	private int size;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void add(Item item) {
		Node node = new Node();
		node.item = item;
		
		if (first != null && first.item.equals(item)) {
			return;
		}
		
		Node cur = first;
		for (; cur!= null && cur.next != null; cur = cur.next) {
			if (cur.next.item.equals(item)) {
				Node temp = cur.next;
				cur.next = cur.next.next;
				temp.next = null;
				size--;
				break;
			}
		}
		size++;
		node.next = first;
		first = node;
	}

	@Override
	public String toString() {
		String s;
		s = "Size: " + size + "\n";
		for (Item str : this) {
			s += (str + " ");
		}
		s += "\n";
		return s;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ResizingArrayQueueIterator();
	}
	
	private class ResizingArrayQueueIterator implements Iterator<Item> {
		
		private int number = size;
		private Node current = first;
		@Override
		public boolean hasNext() {
			return number > 0;
		}
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			number--;
			return item;
		}
	}
}
