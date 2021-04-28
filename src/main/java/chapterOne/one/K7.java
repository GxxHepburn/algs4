package chapterone.one;

import edu.princeton.cs.algs4.StdOut;

public class K7 {

	public static void main(String[] args) {
		//a。	3.00009
		double t = 9.0;
		while (Math.abs(t - 9.0/t) > .001) {
			t = (9.0/t + t) / 2.0;
		}
		StdOut.printf("%.5f", t);
		StdOut.println();
		
		//b.	499500
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		StdOut.println(sum);
		
		//c.	10000
		int sums = 0;
		for (int i = 1; i < 1000; i *= 2) {
			for (int j = 0; j < 1000; j++) {
				sums++;
			}
		}
		StdOut.println(sums);
	}
}
