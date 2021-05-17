package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K48 {

	public static void main(String[] args) {
		Dstack<Integer> dstack = new Dstack<Integer>();
		for (int i = 0; i < 5; i++) {
			dstack.pushLeftStack(i);
			dstack.pushRightStack(5 + i);
		}
		StdOut.println(dstack);
		int count = dstack.leftStackSize();
		for (int i = 0; i < count; i++) {
			StdOut.print(dstack.popLeftStack() + " ");
		}
		StdOut.println();
		count = dstack.rightStackSize();
		StdOut.println(dstack.rightStackSize());
		for (int i = 0; i < count; i++) {
			StdOut.print(dstack.popRightStack() + " ");
		}
	}
}
