package chapterone.four;

import chapterone.three.Stack;

/**
 * 操作数均摊为常数
 * @author gxx
 *
 */
public class K31_2 {

	public static void main(String[] args) {
		
	}
	
	public static class Deque<Item> {
		Stack<Item> left;
		Stack<Item> middle;
		Stack<Item> right;
		
		public Deque() {
			left = new Stack<Item>();
			middle = new Stack<Item>();
			right = new Stack<Item>();
		}
		
		public void pushLeft(Item item) {
			left.push(item);
		}
		
		public void pushRight(Item item) {
			right.push(item);
		}
		
		private void move(Stack<Item> source, Stack<Item> destination) {
			int n = source.size();
			for (int i = 0; i < n / 2; i++) {
				middle.push(source.pop());
			}
			while (!source.isEmpty()) {
				destination.push(source.pop());
			}
			while (!middle.isEmpty()) {
				source.push(middle.pop());
			}
		}
		
		public boolean isEmpty() {
			return size() == 0;
		}
		
		public int size() {
			return left.size() + right.size();
		}
		
		public Item popLeft() {
			if (left.isEmpty()) {
				move(right, left);
			}
			return left.pop();
		}
		
		public Item popRight() {
			if (right.isEmpty()) {
				move(left, right);
			}
			return right.pop();
		}
	}
}
