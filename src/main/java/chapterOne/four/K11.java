package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class K11 {

	public static void main(String[] args) {
		int[] a = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
		StaticSETofInts staticSETofInts = new StaticSETofInts(a);
		StdOut.println(staticSETofInts.howMany(4));
	}
}
