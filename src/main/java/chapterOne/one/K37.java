package chapterone.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K37 {

	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		double[][] b = shuffleAndBefore(M, N);
		double[][] c = getCount(b, M, N);
		print(c);
	}
	
	/**
	 * 将数据打乱，洗牌
	 * @param a
	 */
	public static void shuffle(double[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = StdRandom.uniform(N - i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	
	/**
	 * 统计大小为M的数组，N次打乱之后的结果
	 * @param M
	 * @param N
	 */
	public static double[][] shuffleAndBefore(int M, int N) {
		double[] a = new double[M];
		double[][]b = new double[N][M];
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < M; i++) {
				a[i] = i;
			}
			shuffle(a);
			for (int i = 0; i < M; i++) {
				b[j][i] = a[i];
			}
		}
		return b;
	}
	
	/**
	 * 统计M个数组N次打乱后，分布情况
	 * @param b
	 * @param M
	 * @param N
	 * @return
	 */
	public static double[][] getCount(double[][] b, int M, int N) {
		double[][] c = new double[M][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				c[(int)b[i][j]][j] += 1.0;
			}
		}
		return c;
	}
	
	public static void print(double[][] c) {
		StdOut.print("  ");
		for (int i = 0; i < c[0].length; i++) {
			StdOut.print(i + "   ");
		}
		StdOut.println();
		for (int i = 0; i < c.length; i++) {
			StdOut.print(i + " ");
			for (int j = 0; j < c[i].length; j++) {
				StdOut.print(c[i][j] + " ");
			}
			StdOut.println();
		}
	}
}
