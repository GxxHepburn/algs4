package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K47 {

	public static void main(String[] args) {
//		Queue<Integer> queue = new Queue<Integer>();
//		Queue<Integer> lastQueue = new Queue<Integer>();
//		for (int i = 0; i < 5; i++) {
//			queue.enqueue(i);
//			lastQueue.enqueue(5+i);
//		}
//		StdOut.println(queue);
//		StdOut.println(lastQueue);
//		queue.catenation(lastQueue);
//		StdOut.println(queue);
//		StdOut.println(lastQueue);
		
//		Stack<Integer> stack = new Stack<Integer>();
//		Stack<Integer> lastStack = new Stack<Integer>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		stack.push(4);
//		stack.push(5);
//		lastStack.push(6);
//		lastStack.push(7);
//		lastStack.push(8);
//		lastStack.push(9);
//		lastStack.push(10);
//		StdOut.println(stack);
//		StdOut.println(lastStack);
//		stack.catenation(lastStack);
//		StdOut.println(stack);
//		StdOut.println(lastStack);
		
		Steque<Integer> steque = new Steque<Integer>();
		Steque<Integer> lastSteque = new Steque<Integer>();
		steque.push(1);
		steque.push(2);
		steque.push(3);
		steque.push(4);
		steque.enqueue(5);
		lastSteque.push(6);
		lastSteque.push(7);
		lastSteque.push(8);
		lastSteque.push(9);
		lastSteque.enqueue(10);
		StdOut.println(steque);
		StdOut.println(lastSteque);
		steque.catenation(lastSteque);
		StdOut.println(steque);
		StdOut.println(lastSteque);
	}
}
