package chapterone.one;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K23 {

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		String s = args[1];
		int b = 1;
		if (!"+".equals(s)) {
			b = -1;
		}
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (b*rank(key, whitelist) < 0) {
				StdOut.println(key);
			}
		}
	}
	
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
