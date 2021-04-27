package chapterOne.two;

import edu.princeton.cs.algs4.StdOut;

public class K6 {

	public static void main(String[] args) {
		String s = "ACTGACG";
		String t = "TGACGAC";
		StdOut.println(isCircularRotation(s, t));
	}
	
	public static boolean isCircularRotation(String s, String t) {
		if (s.length() == t.length() && (s+s).indexOf(t) != -1) {
			return true;
		}
		return false;
	}
}
