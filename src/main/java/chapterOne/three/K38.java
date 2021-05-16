package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K38 {

	public static void main(String[] args) {
		// 测试数组实现
		GeneralizedQueue<Integer> generalizedQueue = new GeneralizedQueue<Integer>();
		generalizedQueue.insert(1);
		generalizedQueue.insert(2);
		generalizedQueue.insert(3);
		generalizedQueue.insert(4);
		generalizedQueue.insert(5);
		StdOut.println(generalizedQueue);
		generalizedQueue.delete(1);
		StdOut.println(generalizedQueue);
		generalizedQueue.delete(4);
		StdOut.println(generalizedQueue);
	}
}
