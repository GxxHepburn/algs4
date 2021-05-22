package chapterone.four;

import chapterone.three.Stack;
import chapterone.three.Steque;
import edu.princeton.cs.algs4.StdOut;

public class K30 {

	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 5; i < 10; i++) {
			deque.pushRight(i);
		}
		for (int i = 0; i < 4; i++) {
			StdOut.print(deque.popRight() + " ");
		}
		StdOut.println();
		for (int i = 4; i >= 0; i--) {
			deque.pushLeft(i);
		}
		while (!deque.isEmpty()) {
			StdOut.print(deque.popLeft() + "　");
		}
	}
	
	public static class Deque<Item> {
		int runTimes = 0;
		Steque<Item> steque = new Steque<Item>();
		Stack<Item> stack = new Stack<Item>();
		
		public boolean isEmpty() {
			return size() == 0;
		}
		
		public int size() {
			return steque.size() + stack.size();
		}
		
		public void pushLeft(Item item) {
			steque.enqueue(item);
		}
		
		public void pushRight(Item item) {
			while (!stack.isEmpty()) {
				runTimes++;
				steque.push(stack.pop());
			}
			runTimes++;
			steque.push(item);
		}
		
		public Item popLeft() {
			while (!steque.isEmpty()) {
				runTimes++;
				stack.push(steque.pop());
			}
			runTimes++;
			return stack.pop();
		}
		
		public Item popRight() {
			while (!stack.isEmpty()) {
				runTimes++;
				steque.push(stack.pop());
			}
			runTimes++;
			return steque.pop();
		}
	}
}
