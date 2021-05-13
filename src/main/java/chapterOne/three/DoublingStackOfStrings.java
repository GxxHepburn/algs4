package chapterone.three;

import java.util.Iterator;

public class DoublingStackOfStrings implements Iterable<String> {
	
	private String[] a;
	private int N;
	
	public DoublingStackOfStrings() {
		a = new String[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int max) {
		String[] temp = new String[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(String item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}
	
	public String pop() {
		String item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length/4) {
			resize(a.length / 2);
		}
		return item;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<String> {

		private int i = N;
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public String next() {
			// TODO Auto-generated method stub
			return a[--i];
		}
	}

}
