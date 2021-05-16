package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K40 {

	public static void main(String[] args) {
		MoveToFront<Integer> m = new MoveToFront<Integer>();
		for (int i = 0; i < 10; i++) {
			m.add(i);
		}
		StdOut.println(m);
		m.add(5);
		StdOut.println(m);
		m.add(8);
		StdOut.println(m);
		m.add(9);
		StdOut.println(m);
	}
}
