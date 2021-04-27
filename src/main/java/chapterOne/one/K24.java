package chapterOne.one;

import edu.princeton.cs.algs4.StdOut;

public class K24 {

	public static void main(String[] args) {
		int a = euclid(1111111, 1234567);
		StdOut.println(a);
	}
	
	public static int gcd(int p, int q) {
		StdOut.print("p: " + p + " ,q: " + q);
		StdOut.println();
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}
	
	public static int euclid(int p, int q) {
		StdOut.print("p: " + p + " ,q: " + q);
		StdOut.println();
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}
}
