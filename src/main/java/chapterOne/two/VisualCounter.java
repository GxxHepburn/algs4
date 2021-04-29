package chapterone.two;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class VisualCounter {

	private final int N;
	private final int max;
	private int N2;
	private int count;
	
	public VisualCounter(int N, int max) {
		this.N = N;
		this.max = max;
		StdDraw.setXscale(0, N+1);
		StdDraw.setYscale(0, max*2 + 2);
		StdDraw.setPenRadius(0.05);
	}
	
	public void increament() {
		if (N2 == N) {
			StdOut.println("抱歉，已超过最大操作次数!");
			return;
		}
		StdDraw.point(N2, max+1+count);
		count++;
		if (Math.abs(count) > max) {
			StdOut.println("抱歉，已超过指定最大绝对值!");
			count--;
			return;
		}
		N2++;
	}
	
	public void reduce() {
		if (N2 == N) {
			StdOut.println("抱歉，已超过最大操作次数!");
			return;
		}
		StdDraw.point(N2, max+1+count);
		count--;
		if (Math.abs(count) > max) {
			StdOut.println("抱歉，已超过指定最大绝对值!");
			count++;
			return;
		}
		N2++;
	}

	@Override
	public String toString() {
		return count + "";
	}
}
