package chapterone.four;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class K18 {
	
	int cnt = 0;

	public static void main(String[] args) {
		int[] a = {6, 5, 4, 3, 2, 11, 14, 8, 25};
		int index = min(a);
		StdOut.println(index + " " + a[index]);
	}
	
	public static int min(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		if (a.length == 1 || a[0] < a[1]) {
			return 0;
		}
		if (a[a.length-1] < a[a.length-2]) {
			return a.length - 1;
		}
		int mid = 0;
		int left = 1;
		int right = a.length - 2;
		while (left < right) {
			mid = (left + right) / 2;
			if (a[mid - 1] < a[mid]) {
				right = mid - 1;
			} else if (a[mid + 1] < a[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}
}
