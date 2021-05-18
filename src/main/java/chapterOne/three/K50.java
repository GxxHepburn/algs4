package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K50 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		for (int i : stack) {
			StdOut.print(i + " ");
			if (i == 5) {
				stack.push(10);
			}
		}
	}
}
