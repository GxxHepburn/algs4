package chapterOne.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K39 {

	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		int[] N = {1000, 10000, 100000, 1000000};
		int sum = 0;
		
		for (int i = 0; i < N.length; i++) {
			for (int j = 0; j < T; j++) {
				sum += getCount(N[i]);
			}
			StdOut.println("T: " + T + ", N: " + N[i] + ", 平均值: " + (double)sum/T);
		}
	}
	
	/**
	 * 统计数据大小为N时，同时存在与两数组中整数数量
	 * @param N
	 * @return
	 */
	public static int getCount(int N) {
		int[] a = new int[N];
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(1, 1000000);
			b[i] = StdRandom.uniform(1, 1000000);
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int ans = BinarySearch.rank(a[i], b);
			if (ans != - 1) {
				sum++;
			}
		}
		return sum;
	}
}
