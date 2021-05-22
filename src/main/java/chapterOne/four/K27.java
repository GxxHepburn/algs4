package chapterone.four;

import chapterone.three.Stack;
import edu.princeton.cs.algs4.StdOut;

public class K27 {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		StdOut.println(queue.dequeue() + " ");
		StdOut.println(queue.dequeue() + " ");
		for (int i = 5; i < 10; i++) {
			queue.enqueue(i);
		}
		while (!queue.isEmpty()) {
			StdOut.print(queue.dequeue() + " ");
		}
	}
	
	public static class Queue<Item> {
		Stack<Item> head = new Stack<Item>();
		Stack<Item> tail = new Stack<Item>();
		
		public boolean isEmpty() {
			return size() == 0;
		}
		
		public int size() {
			return head.size() + tail.size();
		}
		
		public void enqueue(Item item) {
			tail.push(item);
		}
		
		public Item dequeue() {
			if (head.isEmpty()) {
				int N = tail.size();
				for (int i = 0; i < N; i++) {
					head.push(tail.pop());
				}
			}
			return head.pop();
		}
	}
}
