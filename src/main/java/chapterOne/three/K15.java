package chapterone.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K15 {

	//args[0] = 5
	//stdin: 10 9 8 7 6 5 4 3 2 1
	//ans: 5
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		Queue<String> queue = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			queue.enqueue(s);
		}
		int length = queue.size();
		for (int i = 0; i < length; i++) {
			String ans = queue.dequeue();
			if (queue.size() == (k - 1)) {
				StdOut.print(ans);
				return;
			}
		}
	}
}
