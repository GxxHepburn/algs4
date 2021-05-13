package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K14 {

	public static void main(String[] args) {
		ResizingArrayQueueOfStrings resizingArrayQueueOfStrings = new ResizingArrayQueueOfStrings();
		resizingArrayQueueOfStrings.enqueue("1");
		resizingArrayQueueOfStrings.enqueue("2");
		resizingArrayQueueOfStrings.enqueue("3");
		resizingArrayQueueOfStrings.enqueue("4");
		resizingArrayQueueOfStrings.enqueue("5");
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.enqueue("6");
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.enqueue("7");
		resizingArrayQueueOfStrings.enqueue("8");
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.enqueue("9");
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
		resizingArrayQueueOfStrings.dequeue();
		StdOut.println(resizingArrayQueueOfStrings);
	}
}
