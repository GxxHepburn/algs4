package chapterone.one;

import edu.princeton.cs.algs4.StdOut;

public class K30 {

	public static void main(String[] args) {
		int N = 10;
		boolean[][] a = new boolean[N][N];
		StdOut.print("  ");
		for (int i = 0; i < N; i++) {
			StdOut.print(i + "    ");
		}
		StdOut.println();
		for (int i = 0; i < N; i++) {
			StdOut.print(i + " ");
			for (int j = 0; j < N; j++) {
				if (gcd(i, j) == 1) {
					a[i][j] = true;
				} else {
					a[i][j] = false;
				}
				StdOut.print(a[i][j] + " ");
			}
			StdOut.println();
		}
	}
	
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}
}
