package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K12 {

	public static void main(String[] args) {
		Stack<String> that = new Stack<String>();
		that.push("1");
		that.push("2");
		that.push("3");
		Stack<String> s = Stack.copy(that);
		for (String str : s) {
			StdOut.print(str + " ");
		}
		StdOut.println();
		for (String str : that) {
			StdOut.print(str + " ");
		}
		StdOut.println();
		StdOut.println();
		that.pop();
		for (String str : s) {
			StdOut.print(str + " ");
		}
		StdOut.println();
		for (String str : that) {
			StdOut.print(str + " ");
		}
		StdOut.println();
		s.pop();
		for (String str : s) {
			StdOut.print(str + " ");
		}
		StdOut.println();
		for (String str : that) {
			StdOut.print(str + " ");
		}
	}
}
