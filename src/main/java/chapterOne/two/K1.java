package chapterOne.two;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K1 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double[][] points = generate(N);
		double min = min(points);
		StdOut.println(min);
	}
	
	/**
	 * 生成N个点，并在单位正方形中画出这些点
	 * @param N
	 * @return
	 */
	public static double[][] generate(int N) {
		double[][] points = new double[N][2];
		for (int i = 0; i < N; i++) {
			double x = StdRandom.uniform();
			double y = StdRandom.uniform();
			points[i][0] = x;
			points[i][1] = y;
			Point2D point2d = new Point2D(x, y);
			point2d.draw();
		}
		return points;
	}
	
	public static double min(double[][] points) {
		double min = Double.POSITIVE_INFINITY;
		double[][] minPoints = new double[2][2];
		for (int i = 0; i < points.length-1; i++) {
			for (int j = i+1; j < points.length; j++) {
				double x0 = Math.abs(points[i][0] - points[j][0]);
				double y0 = Math.abs(points[i][1] - points[j][1]);
				double l = Math.sqrt(Math.pow(x0, 2) + Math.pow(y0, 2));
				if (l < min) {
					min = l;
					minPoints[0] = points[i];
					minPoints[1] = points[j];
				}
			}
		}
		Point2D pF = new Point2D(minPoints[0][0], minPoints[0][1]);
		Point2D pS = new Point2D(minPoints[1][0], minPoints[1][1]);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		pF.drawTo(pS);
		return min;
	}
}
