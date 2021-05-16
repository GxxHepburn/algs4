package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K42 {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		StdOut.println(s);
		Stack<Integer> r = new Stack<Integer>(s);
		StdOut.println(r);
		s.push(6);
		StdOut.print(s);
		StdOut.println(r);
		r.push(6);
		StdOut.print(s);
		StdOut.println(r);
		s.pop();
		StdOut.print(s);
		StdOut.println(r);
		r.pop();
		StdOut.print(s);
		StdOut.println(r);
	}
}
