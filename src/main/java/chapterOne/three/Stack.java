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
