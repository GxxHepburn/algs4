package chapterone.four;

import chapterone.three.Stack;
import chapterone.two.Counter;
import edu.princeton.cs.algs4.StdOut;

/**
 * 这个实现并不能保证均摊操作为常数！
 * 	用例中的情况表明，N次操作，最坏为~c*N/4
 * @author gxx
 *
 */
public class K31 {

	static Counter count = new Counter("test");

	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 1000; i++) {
			deque.pushLeft(i);
		}

		StdOut.println(count.tally());
		for (int i = 0; i < 100; i++) {
			deque.pushLeft(i);
			deque.popRight();
		}
		StdOut.println(count.tally());
	}
	
	public static class Deque<Item> {
		
		
		Stack<Item> headStack = new Stack<Item>();
		Stack<Item> tailStack = new Stack<Item>();
		Stack<Item> tempStack = new Stack<Item>();
		
		public boolean isEmpty() {
			return size() == 0;
		}
		
		public int size() {
			return headStack.size() + tailStack.size() + tempStack.size();
		}
		
		public void pushLeft(Item item) {
			while (!headStack.isEmpty()) {
				count.increment();
				tempStack.push(headStack.pop());
			}
			count.increment();
			headStack.push(item);
		}
		
		public void pushRight(Item item) {
			count.increment();
			tailStack.push(item);
		}
		
		public Item popLeft() {
			if (headStack.size() + tempStack.size() != 0) {
				while (!headStack.isEmpty()) {
					count.increment();
					tempStack.push(headStack.pop());
				}
			} else {
				while (!tailStack.isEmpty()) {
					count.increment();
					tempStack.push(tailStack.pop());
				}
			}
			count.increment();
			return tempStack.pop();
		}
		
		public Item popRight() {
			if  (!tailStack.isEmpty()) {
				count.increment();
				return tailStack.pop();
			}  else {
				while (!tempStack.isEmpty()) {
					count.increment();
					headStack.push(tempStack.pop());
				}
				count.increment();
				return headStack.pop();
			}
		}
	}
}
