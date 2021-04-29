package chapterone.two;

import edu.princeton.cs.algs4.StdOut;

public class K12 {
	
	public static void main(String[] args) {
		int y = 2021;
		int m = 4;
		int d = 29;
		SmartDate smartDate = new SmartDate(m, d, y);
		StdOut.println(smartDate.dayOfTheWeek());
	}
}
