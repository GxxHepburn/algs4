package chapterone.two;

import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {

	public static int rank(int key, int[] a, Counter counter) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			counter.increment();
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				StdOut.println(counter);
				return mid;
			}
		}
		StdOut.println(counter);
		return -1;
	}
}
