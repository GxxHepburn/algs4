package chapterone.three;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author gxx
 *
 * @param <Item>
 */

/**
 * --------------------------------------------------------
 * public class RandomQueue<Item> implements Iterable<Item>
 * --------------------------------------------------------
 * 	RandomQueue()			创建一条空的随机队列
 * 	boolean isEmpty()		队列是否为空
 * 	void enqueue(Item item)	添加一个元素
 * 	Item dequeue()			删除并随机返回一个元素(取样且不放回)
 * 	Item sample()			随机返回一个元素但不删除它(取样且放回)
 * 
 */

public class RandomQueue<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void enqueue(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}
	
	public Item dequeue() {
		int r = StdRandom.uniform(N);
		Item item = a[r];
		a[r] = a[N-1];
		a[N-1] = null;
		N--;
		if (N > 0 && N == a.length/4) {
			resize(a.length / 2);
		}
		
		return item;
	}
	
	public Item sample() {
		int r = StdRandom.uniform(N);
		Item item = a[r];
		return item;
	}
	
	@Override
	public String toString() {
		String s;
		s = "Size: " + size() + " ArrayLength: " + a.length + "\n";
		for (Item str : this) {
			s += (str + " ");
		}
		s += "\n";
		return s;
	}

	@Override
	public Iterator<Item> iterator() {
		//	K35
//		return new ReverseArrayIterator();
		//	K36
		return new RandomIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
	}
	
	private class RandomIterator implements Iterator<Item> {
		
		private Item[] items = (Item[]) new Object[N];
		private int j = N;
		
		public RandomIterator() {
			for (int i = 0; i < N; i++) {
				items[i] = a[i];
			}
			for (int i = 0; i < N; i++) {
				int r = i + StdRandom.uniform(N - i);
				Item temp = items[i];
				items[i] = items[r];
				items[r] = temp;
			}
		}
		
		@Override
		public boolean hasNext() {
			
			return j > 0;
		}

		@Override
		public Item next() {
			return items[--j];
		}
	}
}
