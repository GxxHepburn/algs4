package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class K23 {

	public static void main(String[] args) {
		int[][] a = {{1, 11}, {1, 10}, {3, 20}, {1, 6}, {1, 5}};
		int[] b = {1, 20};
		StdOut.println(binarySearch(a, b));
	}
	
	/*
	 * 分数p/q 存放在数组{p, q}中，同时该一维数组放到二维数组中
	 * 这道题其实没什么意义，不用多看
	 */
	public static int binarySearch(int[][] a, int[] b) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int fs = a[mid][1];
			int ss = b[1];
			int ff = ss * ss * fs * a[mid][0];
			int sf = fs * fs * ss * b[0];
			if (Math.abs(ff - sf) <= 1) {
				return mid;
			} else if (ff > sf) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}
}
