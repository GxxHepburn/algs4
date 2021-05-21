package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class K22 {
	
	private int cnt = 0;
	private int snt = 0;

	public static void main(String[] args) {
//		int[] a = {0, 9, 14, 23, 89, 999};
//		int[] b = {0, 1, 3, 9};
//		StdOut.println(fibBinary2(b, 9));
		
		int[] c = new int[10000];
		for (int i = 0; i < 10000; i++) {
			c[i] = i;
		}
		K22 k22 = new K22();
		Stopwatch time = new Stopwatch();
		StdOut.println(fibBinary2(c, 11000, k22) + " ctn: " + k22.cnt + " snt: " + k22.snt + " time: " + time.elapsedTime());
	}
	
	//	这样是错的,最坏情况并不是~lgN
	public static int fibBinary(int[] a, int key) {
		int N = a.length;
		if (N == 1) {
			if (a[0] == key) {
				return 0;
			} else {
				return -1;
			}
		}
		int f1 = 1;
		int f2 = 1;
		while (f2 < N) {
			f2 = f2 + f1;
			f1 = f2 - f1;
		}
		int f0 = f2 - f1;
		while (f0 >= 0) {
			if (a[f1] == key) {
				return f1;
			} else if (a[f1] < key) {
				for (int i = f1+1; i < Math.min(f2, N-1); i++) {
					if (a[i] == key) {
						return i;
					}
				}
			} else {
				f2 = f1;
				f1 = f0;
				f0 = f2 - f1;
			}
		}
		return -1;
	}
	
	public static int fibBinary2(int[] a, int key, K22 k22) {
		int f1 = 1;
		int f2 = 1;
		while (f2 < a.length) {
			f2 = f1 + f2;
			f1 = f2 - f1;
		}
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			k22.cnt++;
			int mid = lo + f2 - f1 - 1;
			while (mid > hi) {
				k22.snt++;
				int temp = f1;
				f1 = f2 - f1;
				f2 = temp;
				mid = lo + f2 - f1;
				StdOut.println("------------" + "lo: " + lo + " mid: " + mid + " hi: " + hi + " f2: " + f2 + " f1: " + f1);
			}
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				hi = lo + f2 - f1;
				f2 = f2 - f1;
				f1 = f1 - f2;
			} else {
				hi = Math.min(hi, lo + f2);
				lo = lo + f2 - f1;
				int temp = f1;
				f1 = f2 - f1;
				f2 = temp;
			}
			StdOut.println("lo: " + lo + " mid: " + mid + " hi: " + hi + " f2: " + f2 + " f1: " + f1);
		}
		return -1;
	}
}
