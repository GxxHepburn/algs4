package chapterone.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Josephus
 * @author gxx
 *
 */
public class K37 {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		int N = StdIn.readInt();
		int M = StdIn.readInt();
		for (int i = 0; i < N; i++) {
			queue.enqueue(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < (M-1); i++) {
				queue.enqueue(queue.dequeue());
			}
			StdOut.print(queue.dequeue() + " ");
		}
	}
}
