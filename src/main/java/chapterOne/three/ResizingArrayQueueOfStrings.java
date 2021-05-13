package chapterone.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings implements Iterable<String> {
	
	private String[] a;
	private int head;
	private int tail;
	private int N;
	
	public ResizingArrayQueueOfStrings() {
		a = new String[1];
		N = 0;
		tail = 0;
		head = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int max) {
		if (max < N) {
			throw new IllegalArgumentException("the size of new Array must larger than the size of Queue");
		}
		String[] temp = new String[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[(head+i) % a.length];
		}
		head = 0;
		tail = N;
		a = temp;
	}
	
	public void enqueue(String item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[tail++] = item;
		if (tail == a.length) {
			tail = 0;
		}
		N++;
	}
	
	public String dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		String item = a[head];
		a[head] = null;
		head++;
		if (head == a.length) {
			head = 0;
		}
		N--;
		if (N == a.length/4 && N > 0) {
			resize(a.length / 2);
		}
		return item;
	}

	@Override
	public String toString() {
		String s;
		s = "Size: " + N + " ArrayLength: " + a.length + " head: " + head + " tail: " + tail + "\n";
		for (String str : a) {
			s += (str + " ");
		}
		s += "\n";
		return s;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new ResizingArrayQueueIterator();
	}
	
	private class ResizingArrayQueueIterator implements Iterator<String> {
		
		private int number = N;
		private int start = head;
		@Override
		public boolean hasNext() {
			return number > 0;
		}
		@Override
		public String next() {
			String item = a[start++];
			if (start == a.length) {
				start = 0;
			}
			number--;
			return item;
		}
	}
}
