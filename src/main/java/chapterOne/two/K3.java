package chapterOne.two;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K3 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);
		Interval2D[] interval2ds = genInterval2D(N, min, max);
		print(interval2ds);
	}
	
	/**
	 * 生成间隔，并画出间隔
	 * @param N
	 * @param min
	 * @param max
	 * @return
	 */
	public static Interval2D[] genInterval2D(int N, double min, double max) {
		Interval2D[] interval2ds = new Interval2D[N];
		for (int i = 0; i < N; i++) {
			double x0 = StdRandom.uniform(min, max);
			double y0 = StdRandom.uniform(min, max);
			double x1 = StdRandom.uniform(min, max);
			double y1 = StdRandom.uniform(min, max);
			if (x1 < x0) {
				double temp = x1;
				x1 = x0;
				x0 = temp;
			}
			if (y1 < y0) {
				double temp = y1;
				y1 = y0;
				y0 = temp;
			}
			Interval1D i1Dx = new Interval1D(x0, x1);
			Interval1D i1Dy = new Interval1D(y0, y1);
			Interval2D i2D = new Interval2D(i1Dx, i1Dy);
			interval2ds[i] = i2D;
			i2D.draw();
		}
		return interval2ds;
	}
	
	public static void print(Interval2D[] interval2ds) {
		for (int i = 0; i < interval2ds.length-1; i++) {
			for (int j = i+1; j < interval2ds.length; j++) {
				if (interval2ds[i].intersects(interval2ds[j])) {
					StdOut.println("第一个间隔: " + interval2ds[i] + ", 第二个间隔: " + interval2ds[j]);
				}
			}
		}
	}
}
