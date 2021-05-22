package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class K25 {

	public static void main(String[] args) {
		int N = 100000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = i;
		}
		StdOut.println(rank2SqrtN(a, 99));
		StdOut.println();
		StdOut.println(rankSqrtF(a, 99));
	}
	
	public static int rank2SqrtN(int[] a, int F) {
		int N = a.length;
		int n = (int) Math.ceil(Math.sqrt(N));
		int x = 0;
		int runTimes = 0;
		while (x < n * n && x < F) {
			x += n;
			runTimes++;
		}
		int floor = x - n + 1;
		while (floor < F) {
			floor++;
			runTimes++;
		}
		StdOut.println(runTimes);
		return floor;
	}
	
	public static int rankSqrtF(int[] a, int F) {
		int k = 1;
		int runTimes = 0;
		while (k * k < F) {
			k++;
			runTimes++;
		}
		int lo = (k - 1) * (k - 1) + 1;
		while (lo < F) {
			lo++;
			runTimes++;
		}
		StdOut.println(runTimes);
		return lo;
	}
}
