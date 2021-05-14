package chapterone.three;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoubleNode<Item> implements Iterable<Item> {
	
	public static class Node<Item2> {
		Item2 item;
		Node next;
		Node before;
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
	
	public void insertBeforeHead(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.before = null;
		first.next = oldfirst;
		if (oldfirst != null) {
			oldfirst.before = first;
		} else {
			last = first;
		}
		N++;
	}
	
	public void insertAfterTail(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.before = oldlast;
		if (oldlast != null) {
			oldlast.next = last;
		} else {
			first = last;
		}
		N++;
	}
	
	public Item deleteFromHead() {
		Item item = (Item) first.item;
		first = first.next;
		if (first == null) {
			last = null;
		} else {
			first.before = null;
		}
		N--;
		return item;
	}
	
	public Item deleteFromTail() {
		Item item = (Item) last.item;
		last = last.before;
		if (last == null) {
			first = null;
		} else {
			last.next = null;
		}
		N--;
		return item;
	}
	
	/**
	 * 不考虑链表为空情况
	 * k >= 1
	 * @param k
	 * @param node
	 */
	public void insertBeforeNode(int k, Node node) {
		if (k == 1) {
			node.next = first;
			node.before = null;
			first.before = node;
			first = node;
			N++;
			return;
		}
		Node current = first;
		for (int i = 1; i < k; i++) {
			if (current.next == null) {
				throw new NoSuchElementException("指定节点不存在");
			}
			current = current.next;
		}
		Node beore = current.before;
		beore.next = node;
		
		node.before = beore;
		node.next = current;
		
		current.before = node;
		N++;
	}
	
	/**
	 * 不考虑链表为空情况
	 * k >= 1
	 * @param k
	 * @param node
	 */
	public void insertAfterNode(int k, Node node) {
		Node current = first;
		for (int i = 1; i < k; i++) {
			if (current == null) {
				throw new NoSuchElementException("指定节点不存在");
			}
			current = current.next;
		}
		if (current == null) {
			throw new NoSuchElementException("指定节点不存在");
		}
		if (current.next == null) {
			current.next = node;
			node.before = current;
			node.next = null;
			last = node;
			N++;
			return;
		}
		Node next = current.next;
		next.before = node;
		
		node.before = current;
		node.next = next;
		
		current.next = node;
		N++;
	}
	
	/**
	 * 不考虑表为空的情况
	 * k >= 1
	 * @param k
	 * @return
	 */
	public Item deleteNode(int k) {
		Node current = first;
		for (int i = 1; i < k; i++) {
			if (current == null) {
				throw new NoSuchElementException("链表中没有该节点");
			}
			current = current.next;
		}
		if (current == null) {
			throw new NoSuchElementException("链表中没有该节点");
		}
		Item item = (Item) current.item;
		if (k == 1) {
			first = first.next;
			if (first != null) {
				first.before = null;
			} else {
				last = null;
			}
			N--;
			return item;
		}
		if (current.next == null) {
			last = current.before;
			if (last != null) {
				last.next = null;
			} else {
				first = null;
			}
			N--;
			return item;
		}
		Node before = current.before;
		Node next = current.next;
		before.next = next;
		next.before = before;
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
