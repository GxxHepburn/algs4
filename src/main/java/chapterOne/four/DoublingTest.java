package chapterone.four;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

	public static void main(String[] args) {

		//	标准图像
//		StdDraw.setXscale(0, 100.0);
//		StdDraw.setYscale(0, 100);
//		for (int N = 250; true; N += N) {
//			double time = timerTrial(N);
//			StdDraw.setPenRadius(0.006);
//			double x = N/1000;
//			double y  = time;
//			StdDraw.point(x, y);
//			StdOut.printf("%7d %5.1f\n", N, time);
//		}
		
		//	对数图像
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 20);
		for (int N = 250; true; N += N) {
			double time = timerTrial(N);
			StdDraw.setPenRadius(0.006);
			double x = Math.log(N);
			double y = Math.log(time);
			StdDraw.setPenColor(StdDraw.BOOK_RED);
			StdDraw.point(x, y);
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
