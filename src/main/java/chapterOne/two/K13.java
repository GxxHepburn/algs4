package chapterone.two;

import java.util.Date;

import edu.princeton.cs.algs4.StdOut;

public class K13 {

	public static void main(String[] args) {
		Transaction transaction = new Transaction("gxx", new Date(), 13.14d);
		StdOut.println(transaction);
	}
}
