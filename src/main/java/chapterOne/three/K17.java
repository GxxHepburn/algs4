package chapterone.three;

import chapterone.two.Transaction;
import edu.princeton.cs.algs4.StdOut;

public class K17 {

	public static void main(String[] args) {
		Transaction[] tses = Transaction.readTransactions();
		for (Transaction ts : tses) {
			StdOut.println(ts);
		}
	}
}
