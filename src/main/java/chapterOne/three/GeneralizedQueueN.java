package chapterone.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/**
 * 链表实现
 * @author gxx
 *
 */

/*
 * --------------------------------------------------------------
 * public class GeneralizedQueueN<Item> implements Iterable<Item>
 * --------------------------------------------------------------
 * 	GeneralizedQueueN()			创建一条空队列
 * 	boolean isEmpty()			队列是否为空
 * 	void insert(Item x)			添加一个元素
 * 	Item delete(int k)			删除并返回最早插入的第k个元素
 * --------------------------------------------------------------
 */

public class GeneralizedQueueN<Item> implements Iterable<Item> {
	
	private class Node {
		Item item;
		Node next;
	}

	private Node first;
	private Node last;
	private int N;
	
	public GeneralizedQueueN() {
		first = null;
		last = null;
		N = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insert(Item x) {
		Node node = new Node();
		node.item = x;
		node.next = null;
		if (first == null) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;
		}
		N++;
	}
	
	public Item delete(int k) {
		if (k > N) {
			throw new NoSuchElementException("the size of new Array must larger than the size of Queue");
		}
		if (first == last) {
			Item item = first.item;
			first = null;
			last = null;
			N--;
			return item;
		} else if (k == 1) {
			Item item = first.item;
			first = first.next;
			N--;
			return item;
		}
		Node prev = first;
		for (int i = 1; i < k-1; i++) {
			prev = prev.next;
		}
		Item item = prev.next.item;
		prev.next = prev.next.next;
		last = prev;
		N--;
		return item;
	}
	
	@Override
	public String toString() {
		String s;
		s = "Size: " + N + "\n";
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
		
		private Node current = first;
		private int number = N;
		
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
