package chapterone.four;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {

	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
	
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		long arg1;
		long arg2;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					arg1 = a[i];
					arg2 = a[j];
					sum = arg1 +  arg2;
					if (sum == -a[k]) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
