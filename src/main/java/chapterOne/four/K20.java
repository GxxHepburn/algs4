package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class K20 {

	public static void main(String[] args) {
		int[] a = {-1, 2, 0};
		int key = 1;
		StdOut.println(contains(a, key));
	}
	
	//	~3lgN
	public static boolean contains(int[] a, int key) {
		int mid = max(a);
		if (rankUp(a, 0, mid, key) != -1) {
			return true;
		}
		if (rankDown(a, mid, a.length - 1, key) != -1) {
			return true;
		}
		return false;
	}
	
	//	lgN
	private static int max(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		if (a.length == 1 || a[0] > a[1]) {
			return 0;
		}
		if (a[a.length-1] > a[a.length-2]) {
			return a.length - 1;
		}
		int mid = 0;
		int left = 1;
		int right = a.length - 2;
		while (left < right) {
			mid = (left + right) / 2;
			if (a[mid - 1] > a[mid]) {
				right = mid - 1;
			} else if (a[mid + 1] > a[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}
	
	// lg(N/2) = lgN - 1
	private static int rankUp(int[] a, int lo, int hi, int key) {
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (a[mid] < key) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	//lg(N/2) = lgN - 1
	private static int rankDown(int[] a, int lo, int hi, int key) {
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (a[mid] > key) {
				lo = mid + 1;
			} else if (a[mid] < key) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
