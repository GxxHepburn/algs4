package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K41 {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		StdOut.println(q);
		Queue<Integer> r = new Queue<Integer>(q);
		StdOut.println(r);
//		Queue<String> s = new Queue<String>(q);
		q.dequeue();
		StdOut.println(q);
		StdOut.println(r);
		r.dequeue();
		StdOut.println(q);
		StdOut.println(r);
	}
}
