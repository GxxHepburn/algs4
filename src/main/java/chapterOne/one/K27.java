package chapterone.one;

import edu.princeton.cs.algs4.StdOut;

public class K27 {
	
	static int sum = 0;

	public static void main(String[] args) {
		int N = 100;
		int k = 50;
		double[][] t = new double[N+1][k+1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = -1;
			}
		}
		double a = binomial(N, k, 0.25, t);
		System.out.println(sum);
		System.out.println(a);
	}
	
	public static double binomial(int N, int k, double p,  double[][] t) {
		sum++;
		StdOut.println("sum: " + sum + ", N: " + N + ", k: " + k);
		if (N == 0 && k == 0) {
			t[N][k] = 1.0;
			return 1.0;
		}
		if (N < 0 || k < 0) {
			return 0.0;
		}
		double g1;
		double g2;
		if (N == 0) {
			g1 = 0.0;
		} else if (t[N-1][k] != -1) {
			g1 = t[N-1][k];
		} else {
			g1 = binomial(N - 1, k, p, t);
		}
		
		if (N == 0 || k == 0) {
			g2 = 0.0;
		} else if (t[N-1][k-1] != -1) {
			g2 = t[N-1][k-1];
		} else {
			g2 = binomial(N - 1, k - 1, p, t);
		}
		double g = (1.0 - p) * g1 + p * g2;
		t[N][k] = g;
		return g;
	}
}
