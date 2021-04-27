package chapterOne.one;

import edu.princeton.cs.algs4.StdOut;

public class K11 {

	public static void main(String[] args) {
		int[][] a = new int[10][10];
		for (int i = 0 ; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int)(Math.random() * 100) % 2;
			}
		}
		System.out.print("  ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			StdOut.print(i + " ");
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 0) {
					StdOut.print("  ");
				} else {
					StdOut.print("* ");
				}
			}
			StdOut.println();
		}
	}
}
