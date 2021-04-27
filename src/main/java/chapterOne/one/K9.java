package chapterOne.one;

import edu.princeton.cs.algs4.StdOut;

public class K9 {

	public static void main(String[] args) {
		int N = 2;
		String s = toBinary2(N);
		StdOut.println(s);
	}
	
	public static String toBinary(int N) {
		int a;
		while (N > 1) {
			a = N % 2;
			return toBinary(N / 2) + a;
		}
		a = N;
		return a + "";
	}
	
	public static String toBinary2(int N) {
		 String s = "";
		 for (int n = N; n > 0; n /= 2) {
			 s = (n % 2) + s;
		 }
		 return s;
	}
}
