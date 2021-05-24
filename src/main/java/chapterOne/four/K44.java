package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K44 {

	public static void main(String[] args) {
		int N = 1000000000;
		int cnt = 0;
		int[] a = new int[N];
		int index;
		while (true) {
			index = StdRandom.uniform(N);
			cnt++;
			if (a[index] != 0) {
				a[index] = 2;
				break;
			} else {
				a[index] = 1;
			}
		}
		double tobe = Math.sqrt((Math.PI * N) / 2);
		StdOut.println("cnt: " + cnt + " ,tobe: " + tobe);
	}
}
