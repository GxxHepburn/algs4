package chapterone.four;

import chapterone.four.K29.Steque;
import chapterone.three.Stack;

/**
 * ~常数
 * @author gxx
 *
 */
public class K30_2 {

	public static void main(String[] args) {
		
	}
	
	public static class Deque<Item> {
		Steque<Item> steque = new Steque<Item>();
		Stack<Item> stack = new Stack<Item>();
		
		public boolean isEmpty() {
			return size() == 0;
		}
		
		public int size() {
			return steque.size() + stack.size();
		}
		
		public void pushLeft(Item item) {
			stack.push(item);
		}
		
		public Item popLeft() {
			if (stack.isEmpty()) {
				moveHalfItemsFromStequeToStack();
			}
			return stack.pop();
		}
		
		private void moveHalfItemsFromStequeToStack() {
			int halfStequeSize = steque.size() / 2;
			int remainingStequeSzie = steque.size() - halfStequeSize;
			
			for (int i = 0; i < halfStequeSize; i++) {
				steque.enqueue(steque.pop());
			}
			for (int i = 0; i < remainingStequeSzie; i++) {
				stack.push(steque.pop());
			}
		}
		
		public void pushRight(Item item) {
			steque.push(item);
		}
		
		public Item popRight() {
			if (steque.isEmpty()) {
				while (!stack.isEmpty()) {
					steque.push(stack.pop());
				}
			}
			return steque.pop();
		}
	}
}
