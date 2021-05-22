package chapterone.four;

import chapterone.three.Stack;

public class K31 {

	public static void main(String[] args) {
		
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
				tempStack.push(headStack.pop());
			}
			headStack.push(item);
		}
		
		public void pushRight(Item item) {
			tailStack.push(item);
		}
		
		public Item popLeft() {
			if (headStack.size() + tempStack.size() != 0) {
				while (!headStack.isEmpty()) {
					tempStack.push(headStack.pop());
				}
			} else {
				while (!tailStack.isEmpty()) {
					tempStack.push(tailStack.pop());
				}
			}
			return tempStack.pop();
		}
		
		public Item popRight() {
			if  (!tailStack.isEmpty()) {
				return tailStack.pop();
			}  else {
				while (!tempStack.isEmpty()) {
					headStack.push(tempStack.pop());
				}
				return headStack.pop();
			}
		}
	}
}
