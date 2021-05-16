package chapterone.three;

import java.util.Iterator;


/**
 * 动态数组调整实现
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

public class ResizingArrayDeque<Item> implements Iterable<Item> {

	private Item[] a;
	private int head;
	private int tail;
	
	public ResizingArrayDeque() {
		a = (Item[]) new Object[3];
		head = 1;
		tail = 1;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public int size() {
		return tail - head;
	}
	
	private void resize(int size) {
		if (size < 3) {
			size = 3;
		}
		Item[] temp = (Item[]) new Object[size];
		int j = size / 3;
		for (int i = head; i < tail; i++) {
			temp[j++] = a[i];
		}
		a = temp;
		head = size / 3;
		tail = j;
	}
	
	public void pushLeft(Item item) {
		if (head == 0) {
			resize(3 * size());
		}
		a[--head] = item;
	}
	
	public void pushRight(Item item) {
		if (tail == a.length) {
			resize(3 * size());
		}
		a[tail++] = item;
	}
	
	public Item popLeft() {
		Item item = a[head];
		a[head] = null;
		head++;
		if (size()*6 < a.length) {
			resize(size() * 3);
		}
		return item;
	}
	
	public Item popRight() {
		Item item = a[tail-1];
		a[tail-1] = null;
		tail--;
		if (size()*6 < a.length) {
			resize(size() * 3);
		}
		return item;
	}
	
	@Override
	public String toString() {
		String s;
		s = "Size: " + size() + " ArrayLength: " + a.length + " head: " + head + " tail: " + tail + "\n";
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
		
		private int start = head;
		private int number = size();
		@Override
		public boolean hasNext() {
			return number > 0;
		}
		@Override
		public Item next() {
			Item item = a[start++];
			if (start == a.length) {
				start = 0;
			}
			number--;
			return item;
		}
	}
}
