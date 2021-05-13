package chapterone.three;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixCapacityStack<Item> implements Iterable<Item> {
	private Item[] a;
	private int N;
	
	public FixCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}
	
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length/4) {
			resize(a.length / 2);
		}
		return item;
	}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	// 这表明，在对集合进行迭代时，若改变其大小，可造成超出数组边界错误（仅仅针对这种实现方式)
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}
	}

	public static void main(String[] args) {
		FixCapacityStack<String> s;
		s = new FixCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
