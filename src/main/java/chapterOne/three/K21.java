package chapterone.three;

import edu.princeton.cs.algs4.StdOut;


public class K21 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("3");
		StdOut.println(find(stack, "1"));
		StdOut.println(find(stack, "2"));
		StdOut.println(find(stack, "3"));
	}
	
	public static boolean find(Iterable<String> iterable, String key) {
		for (String item : iterable) {
			if (item.equals(key)) {
				return true;
			}
		}
		return false;
	}
}
