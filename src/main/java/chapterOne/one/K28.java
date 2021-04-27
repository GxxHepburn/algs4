package chapterOne.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K28 {

	public static void main(String[] args) {
		
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		
		int s = whitelist[0];
		List<Integer> list = new ArrayList<Integer>();
		list.add(s);
		for (int i = 1; i < whitelist.length; i++) {
			StdOut.println(whitelist[i]);
			if (whitelist[i] != s) {
				s = whitelist[i];
				list.add(s);
			}
		}
		whitelist = new int[list.size()];
		for (int i = 0; i < whitelist.length; i++) {
			whitelist[i] = list.get(i);
		}
		
		StdOut.println();
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist) < 0) {
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
