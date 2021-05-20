package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class K10 {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 4, 5, 5, 5};
		StdOut.println(rank(5, a));
		StdOut.println(rank(2, a));
		
		int N = 125;
		double prev = timeTrial(N);
		for (N = 250; true; N += N) {
			double now = timeTrial(N);
			StdOut.printf("N=%10d time=%7.1f ratio=%6.1f\n", N, now, now/prev);
			prev = now;
		}
	}
	
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		int key = StdRandom.uniform(-a.length, a.length);
		Stopwatch time = new Stopwatch();
		int index = rank(key, a);
		StdOut.println(index);
		return time.elapsedTime();
	}
	
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				while (mid>=0 && a[mid-1]==key) {
					mid--;
				}
				return mid;
			}
		}
		return -1;
	}
}
