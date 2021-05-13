package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K13 {

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		
		//a
		queue.enqueue("0");
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		queue.enqueue("5");
		queue.enqueue("6");
		queue.enqueue("7");
		queue.enqueue("8");
		queue.enqueue("9");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.print(queue.dequeue() + " ");
		StdOut.println();
		
		//b
		//c
		//d
		//都不可能，因为，队列是先进先出，无论如何操作，出列顺序都是0123456789
	}
}
