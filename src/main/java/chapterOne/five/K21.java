package chapterone.five;

import edu.princeton.cs.algs4.StdOut;

public class K21 {

	public static void main(String[] args) {
		int N = 1000;
		StdOut.println("count: " + K17.count(N) + " , expected: N/2 * lnN = " + (N/2 * Math.log(N)));
	}
}
