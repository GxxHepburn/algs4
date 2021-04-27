package chapterOne.one;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K22 {

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		int lo = 0;
		int hi = whitelist.length - 1;
		int deep = 0;
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist, lo, hi, deep) < 0) {
				StdOut.println(key);
			}
		}
	}
	
	public static int rank(int key, int[] a, int lo, int hi, int deep) {
		StdOut.print("lo: " + lo + " ,hi: " + hi + " ,deep: " + deep);
		deep++;
		int mid = lo + (hi - lo) / 2;
		
		if (lo > hi) {
			return -1;
		} else if (a[mid] == key) {
			return mid;
		} else if (key < a[mid]) {
			return rank(key, a, lo, mid - 1, deep);
		} else {
			return rank(key, a, mid + 1, hi, deep);
		}
	}
}
