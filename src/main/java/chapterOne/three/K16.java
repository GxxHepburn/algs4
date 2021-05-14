package chapterone.three;

import chapterone.two.SmartDate;
import edu.princeton.cs.algs4.StdOut;

public class K16 {

	public static void main(String[] args) {
		SmartDate[] dates = SmartDate.readDates();
		for (SmartDate date : dates) {
			StdOut.println(date);
		}
	}
}
