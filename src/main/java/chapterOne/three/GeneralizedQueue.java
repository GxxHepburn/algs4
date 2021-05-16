package chapterone.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 数组实现
 * @author gxx
 *
 */

/**
 * ----------------------------------------------
 * public class GeneralizedQueue<Item> implements Iterable<T>
 * 	GeneralizedQueue()			创建一条空队列
 * 	boolean isEmpty()			队列是否为空
 * 	void insert(Item x)			添加一个元素
 * 	Item delete(int k)			删除并返回最早插入的第k个元素
 *
 */

public class GeneralizedQueue<Item> implements Iterable<Item> {

	private Item[] a;
	private int N;
	
	public GeneralizedQueue() {
		a = (Item[]) new Object[1];
		N = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	private void resize(int max) {
		if (max < N) {
			throw new IllegalArgumentException("the size of new Array must larger than the size of Queue");
		}
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void insert(Item x) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = x;
	}
	
	/*
	 * k>=1
	 * 不考虑为空的情况
	 */
	public Item delete(int k) {
		if (k > N) {
			throw new NoSuchElementException("队列不存在该元素");
		}
		Item item = a[k-1];
		for (int i = k-1; i < N-1; i++) {
			a[i] =a[i+1];
		}
		a[N-1] = null;
		N--;
		return item;
	}
	
	@Override
	public String toString() {
		String s;
		s = "Size: " + N + " ArrayLength: " + a.length + "\n";
		for (Item str : a) {
			s += (str + " ");
		}
		s += "\n";
		return s;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class ResizingArrayQueueIterator implements Iterator<Item> {
		
		private int number = N;
		
		@Override
		public boolean hasNext() {
			return number > 0;
		}
		@Override
		public Item next() {
			Item item = a[--number];
			return item;
		}
	}
}
