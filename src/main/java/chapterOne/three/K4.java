package chapterone.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K4 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("[") || item.equals("(") || item.equals("{")) {
				stack.push(item);
			} else if (stack.isEmpty()) {
				StdOut.println(false);
				return;
			} else if (item.equals("}")) {
				if (!"{".equals(stack.pop())) {
					StdOut.println(false);
					return;
				}
			} else if (item.equals(")")) {
				if (!"(".equals(stack.pop())) {
					StdOut.println(false);
					return;
				}
			} else if (item.equals("]")) {
				if (!"[".equals(stack.pop())) {
					StdOut.println(false);
					return;
				}
			}
		}
		StdOut.println(true);
	}
}
