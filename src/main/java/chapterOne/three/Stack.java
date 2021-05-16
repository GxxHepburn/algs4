package chapterone.three;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {
	
	private class Node {
		Item item;
		Node next;
	}

	private Node first;
	private int N;
	
	public Stack(Stack<Item> s) {
		Stack<Item> result = new Stack<Item>();
		int size = s.size();
		Item[] temp = (Item[]) new Object[size];
		Node current = s.first;
		for (int i = 0; i < size; i++) {
			Item item = current.item;
			temp[i] = item;
			current = current.next;
		}
		for (int i = size; i > 0; ) {
			result.push(temp[--i]);
		}
		this.first = result.first;
		this.N = result.size();
	}
	
	public Stack() {
		super();
	}
	
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
	
	/**
	 * K7
	 * @return
	 */
	public Item peek() {
		Item item = first.item;
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
	
	/**
	 * K12
	 * 注意栈的副本，顺序也要相同!
	 * 方法中利用数组，修正顺序
	 * @param that
	 * @return
	 */
	public static Stack<String> copy(Stack<String> that) {
		Stack<String> s = new Stack<String>();
		String[] ss = new String[that.size()];
		int index = 0;
		for(String str : that) {
			ss[index++] = str;
		}
		for (int i = index; i > 0; i--) {
			s.push(ss[--index]);
		}
		return s;
	}
	
	/**
	 * K24
	 * 默认node是该链表中的一个节点
	 * @param node
	 */
	public void removeAfter(Node node) {
		if (node == null || node.next == null) {
			return;
		}
		Node current = first;
		while (current.next != null) {
			if (current.item.equals(node.item)) {
				break;
			}
		}
		current.next = null;
	}
	
	/**
	 * K25
	 * @param node
	 * @param nodeAfter
	 */
	public void insertAfter(Node node, Node nodeAfter) {
		if (node == null || nodeAfter == null) {
			return;
		}
		nodeAfter.next = node.next;
		node.next = nodeAfter;
	}
	
	

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
		for(String str : s) {
			StdOut.print(str + " ");
		}
	}
}
