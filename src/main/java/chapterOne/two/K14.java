package chapterone.two;

import java.util.Date;

import edu.princeton.cs.algs4.StdOut;

public class K14 {

	public static void main(String[] args) {
		Date date = new Date();
		Transaction transaction = new Transaction("gxx", date, 13.14d);
		Transaction transaction2 = new Transaction("gxx", date, 13.14d);
		StdOut.println(transaction.equals(transaction2));
	}
}
