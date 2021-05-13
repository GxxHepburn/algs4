package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K1 {

	public static void main(String[] args) {
		FixedCapacityStackOfStrings f = new FixedCapacityStackOfStrings(2);
		f.push("1");
		StdOut.println(f.isFull());
		f.push("2");
		StdOut.println(f.isFull());
		f.pop();
		StdOut.println(f.isFull());
	}
}
