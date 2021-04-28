package chapterone.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K3 {

	public static void main(String[] args) {
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = StdIn.readInt();
		}
		if (a[0] != a[1] || a[0] != a[2]) {
			StdOut.print("not equal");
		} else {
			StdOut.print("equal");
		}
	}
}
