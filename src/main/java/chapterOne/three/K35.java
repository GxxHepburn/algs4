package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K35 {

	public static void main(String[] args) {
		RandomQueue<Integer> randomQueue = new RandomQueue<Integer>();
		randomQueue.enqueue(1);
		randomQueue.enqueue(2);
		randomQueue.enqueue(3);
		randomQueue.enqueue(4);
		randomQueue.enqueue(5);
		randomQueue.enqueue(6);
		randomQueue.enqueue(7);
		randomQueue.enqueue(8);
		randomQueue.enqueue(9);
		randomQueue.enqueue(10);
		randomQueue.enqueue(11);
		randomQueue.enqueue(12);
		randomQueue.enqueue(13);
		StdOut.println(randomQueue.sample());
		StdOut.println(randomQueue);
		StdOut.println(randomQueue.dequeue());
		StdOut.println(randomQueue);
	}
}
