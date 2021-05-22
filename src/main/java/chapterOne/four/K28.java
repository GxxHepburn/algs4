package chapterone.four;

import chapterone.three.Queue;
import edu.princeton.cs.algs4.StdOut;

public class K28 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		StdOut.println(stack.pop() + " ");
		StdOut.println(stack.pop() + " ");
		for (int i = 5; i < 10; i++) {
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			StdOut.print(stack.pop() + " ");
		}
	}
	
	public static class Stack<Item> {
		Queue<Item> queue = new Queue<Item>();
		
		public boolean isEmpty() {
			return size() == 0;
		}
		
		public int size() {
			return queue.size();
		}
		
		public void push (Item item) {
			queue.enqueue(item);
		}
		
		public Item pop() {
			int N = queue.size();
			for (int i = 0; i < N - 1; i++) {
				queue.enqueue(queue.dequeue());
			}
			return queue.dequeue();
		}
	}
}
