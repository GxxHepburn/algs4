package chapterone.two;

import edu.princeton.cs.algs4.StdOut;

public class K7 {

	public static void main(String[] args) {
		String s = "123456789";
		s = mystery(s);
		StdOut.println(s);
	}
	
	// 倒序排列
	public static String mystery(String s) {
		int N = s.length();
		if (N <= 1) {
			return s;
		}
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		return mystery(b) + mystery(a);
	}
}
