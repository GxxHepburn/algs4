package chapterone.one;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class K31 {

	public static void main(String[] args) {
		randomLink(20, 0.2);
	}
	
	/*
	 * 画圆
	 * @param x 圆心x坐标
	 * @param y 圆心y坐标
	 * @param r 半径r
	 */
	public static void drawCircle(double x, double y, double r) {
		StdDraw.setXscale(0, 2 * y);
		StdDraw.setYscale(0, 2 * y);
		StdDraw.setPenRadius(0.003);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.circle(x, y, r);
	}
	
	/*
	 * 在圆上描点
	 * @param x0 圆心坐标
	 * @param y0 圆心坐标
	 * @param r 半径r
	 * @param N N个点
	 */
	public static double[][] drawPoints(double x0, double y0, double r, int N) {
		double[][] points = new double[N][2];
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		for (int i = 0; i < N; i++) {
			double x = x0 + r * Math.cos(2 * Math.PI * i / N);
			double y = x0 + r * Math.sin(2 * Math.PI * i / N);
			StdDraw.point(x, y);
			points[i][0] = x;
			points[i][1] = y;
		}
		return points;
	}
	
	/**
	 * 以概率p随机连接顶点集points中的点
	 * @param points 点集
	 * @param p 概率p
	 */
	public static void randomwLinkPoints(double[][] points, double p) {
		StdDraw.setPenRadius(0.002);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		int length = points.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (true == StdRandom.bernoulli(p)) {
					StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
				}
			}
		}
	}
	
	/**
	 * 在圆上画N个点然后两点间以概率p连接
	 * @param N N个点
	 * @param p 概率p
	 */
	public static void randomLink(int N, double p) {
		double x = 10.0;
		double y = 10.0;
		double r = 9.0;
		drawCircle(x, y, r);
		double[][] points = drawPoints(x, y, r, N);
		randomwLinkPoints(points, p);
	}
}
