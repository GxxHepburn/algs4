package chapterone.four;

import chapterone.three.Stack;
import edu.princeton.cs.algs4.StdOut;

public class K29 {

	public static void main(String[] args) {
		Steque<Integer> steque = new Steque<Integer>();
		for (int i = 9; i >= 7; i--) {
			steque.push(i);
		}
		steque.enqueue(4);
		steque.enqueue(5);
		steque.enqueue(6);
		for (int i = 3; i >= 0; i--) {
			steque.push(i);
		}
		while (!steque.isEmpty()) {
			StdOut.println(steque.pop() + " ");
		}
	}
	
	public static class Steque<Item> {
		Stack<Item> stack = new Stack<Item>();
		Stack<Item> queueStack = new Stack<Item>();
		
		public boolean isEmpty() {
			return size() == 0;
		}
		
		public int size() {
			return stack.size() + queueStack.size();
		}
		
		public void push(Item item) {
			stack.push(item);
		}
		
		public Item pop() {
			Item item;
			if (stack.isEmpty()) {
				while(!queueStack.isEmpty()) {
					stack.push(queueStack.pop());
				}
				item = stack.pop();
			} else {
				item = stack.pop();
			}
			return item;
		}
		
		public void enqueue(Item item) {
			queueStack.push(item);
		}
	}
}
