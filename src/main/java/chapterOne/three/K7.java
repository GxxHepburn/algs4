package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K7 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		StdOut.println(stack.peek());
		stack.pop();
		StdOut.println(stack.peek());
	}
}
