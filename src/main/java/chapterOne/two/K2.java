package chapterone.two;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K2 {

	public static void main(String[] args) {
		 int N = Integer.parseInt(args[0]);
		 double[][] intervals = readIntervals(N);
		 sortInner(intervals);
		 sort(intervals);
		 double[][][] intersects = getIntersects(intervals);
		 print(intersects);
	}
	
	/**
	 * 从标准输入读取N个间隔
	 * @param N
	 * @return 间隔数组
	 */
	public static double[][] readIntervals(int N) {
		 double[][] intervals = new double[N][2];
		 int index = 0;
		 while (!StdIn.isEmpty()) {
			double start = StdIn.readDouble();
			double end = StdIn.readDouble();
			intervals[index][0] = start;
			intervals[index][1] = end;
			StdOut.println(start + " " + end);
			index++;
			if (index >= N) {
				break;
			}
		}
		 return intervals;
	}
	
	/**
	 * 对间隔进行内部排序，保证间隔较小值在前
	 * @param intervals
	 * @return
	 */
	public static double[][] sortInner(double[][] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			double f = intervals[i][0];
			double s = intervals[i][1];
			if (f > s) {
				intervals[i][0] = s;
				intervals[i][1] = f;
			}
		}
		return intervals;
	}
	
	/**
	 * 将间隔按照第一个值排序
	 * @param intervals
	 * @return
	 */
	public static double[][] sort(double[][] intervals) {
		for (int i = 0; i < intervals.length - 1; i++) {
			for (int j = i + 1; j < intervals.length; j++) {
				if (intervals[i][0] > intervals[j][0]) {
					double[] temp = intervals[i];
					intervals[i] = intervals[j];
					intervals[j] = temp;
				}
			}
		}
		return intervals;
	}
	
	/**
	 * 获得所有相交的间隔对
	 * @param intervals
	 * @return
	 */
	public static double[][][] getIntersects(double[][] intervals) {
		List<double[][]> list = new ArrayList<double[][]>();
		for (int i = 0; i < intervals.length-1; i++) {
			for (int j = i+1; j < intervals.length; j++) {
				Interval1D iF = new Interval1D(intervals[i][0], intervals[i][1]);
				Interval1D iS = new Interval1D(intervals[j][0], intervals[j][1]);
				if (iF.intersects(iS)) {
					double[][] listItem = new double[2][2];
					listItem[0] = intervals[i];
					listItem[1] = intervals[j];
					list.add(listItem);
				} else {
					break;
				}
			}
		}
		
		double[][][] intersects = new double[list.size()][2][2];
		for (int i = 0; i < intersects.length; i++) {
			intersects[i] = list.get(i);
		}
		return intersects;
	}
	
	public static void print(double[][][] intersects) {
		for (int i = 0; i < intersects.length; i++) {
			StdOut.println("第一个间隔: (" + intersects[i][0][0] + ", " + intersects[i][0][1]
					+ "), 第二个间隔: (" + intersects[i][1][0] + ", " + intersects[i][1][1] + ")");
		}
	}
}
