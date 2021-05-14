package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K27 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		StdOut.print(max(stack));
	}
	
	public static int max(Iterable<Integer> iterable) {
		if (iterable == null) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (Integer i : iterable) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
}
