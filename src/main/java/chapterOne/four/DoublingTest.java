package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

	public static void main(String[] args) {
		for (int N = 250; true; N += N) {
			double time = timerTrial(N);
			StdOut.printf("%7d %5.1f\n", N, time);
		}
	}
	
	public static double timerTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0;i < N; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSumFast.count(a);
		return timer.elapsedTime();
	}
}
