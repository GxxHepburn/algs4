package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class K24 {
	
	private int cnt;

	public static void main(String[] args) {
		int N = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < 1000000; i++) {
			a[i] = i;
		}
		Stopwatch time = new Stopwatch();
		K24 k24 = new K24();
		StdOut.println(fastBinarySearch(a, 2, k24) + " cnt: " + k24.cnt + " time:" + time.elapsedTime());
		k24.cnt = 0;
		StdOut.println(binarySearch(a, 2, k24) + " cnt: " + k24.cnt + " time:" + time.elapsedTime());
	}
	
	//	~lgN
	public static int binarySearch(int[] a, int F, K24 k24) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			k24.cnt++;
			int mid = lo + (hi - lo) / 2;
			if (F < a[mid]) {
				hi = mid - 1;
			} else if (F > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int fastBinarySearch(int[] a, int F, K24 k24) {
		int k = 0;
		while (Math.pow(2, k) < F) {
			k24.cnt++;
			k++;
		}
		
		int lo = (int) Math.pow(2, k-1);
		int hi = (int) Math.pow(2, k);
		while (lo <= hi) {
			k24.cnt++;
			int mid = lo + (hi - lo) / 2;
			if (F < a[mid]) {
				hi = mid - 1;
			} else if (F > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
