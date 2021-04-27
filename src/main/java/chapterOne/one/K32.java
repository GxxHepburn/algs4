package chapterOne.one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K32 {

	public static void main(String[] args) {
		double[] whiteList = In.readDoubles(args[0]);
		double min = Double.POSITIVE_INFINITY;
		double max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < whiteList.length; i++) {
			if (min > whiteList[i]) {
				min = whiteList[i];
			}
			if (max < whiteList[i]) {
				max = whiteList[i];
			}
		}
		// 从控制台读取应将数据分割的段数
		StdOut.print("将数据分割的段数: ");
		int N = StdIn.readInt();
		dataHistogram(N, min, max + 10.0, whiteList);
	}
	
	/**
	 * 数据柱状图
	 * @param N
	 * @param l
	 * @param r
	 * @param a
	 */
	public static void dataHistogram(int N, double l, double r, double[] a) {
		int length = a.length;
		int[] statistics = new int[N];
		double interval = (r - l) / N;
		//统计数据分布
		for (int i = 0; i < length; i++) {
			double remain = a[i] - 1;
			int idx = (int)(remain / interval);
			// 过滤未命中部分
			if (idx >= 0 && idx < N) {
				statistics[idx]++;
			}
		}
		// 查找统计结果中最大值，用于绘制直方图时计算柱状图高
		double max = statistics[0];
		for (int i = 1; i < statistics.length; i++) {
			if (max < statistics[i]) {
				max = statistics[i];
			}
		}
		//绘制直方图
		StdDraw.setXscale(l, r);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		double x0 = l + interval / 2.0;
		for (int i = 0; i < statistics.length; i ++) {
			double x = x0 + i * interval;
			double y = statistics[i] / (max + 1) / 2.0;
			double hw = 0.99 * interval / 2.0;
			double hh = y;
			StdDraw.filledRectangle(x, y, hw, hh);
		}
	}
}
