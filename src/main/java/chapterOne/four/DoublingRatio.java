package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class DoublingRatio {

	public static void main(String[] args) {
		double prev = DoublingTest.timerTrial(125);
		for (int N = 250; true; N += N) {
			double time = DoublingTest.timerTrial(N);
			StdOut.printf("%6d %7.1f ", N, time);
			StdOut.printf("%5.1f\n", time/prev);
			prev = time;
		}
	}
}
