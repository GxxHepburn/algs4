package chapterone.three;

import java.util.Iterator;

/**
 * 双向队列与栈
 * @author gxx
 *
 */

/*
 * ---------------------------------------------
 * 	public class Dstack<Item>
 * ---------------------------------------------
 * 		boolean leftStackIsEmpty()		左栈是否为空
 * 		boolean rightStackIsEmpty()		右栈是否为空
 * 		int leftStackSize()				左栈大小
 * 		int rightStackSize()			右栈大小
 * 		void pushLeftStack(Item item)	左入栈
 * 		void pushRightStack(Item item)	右入栈
 * 		Item popLeftStack()				左出栈
 * 		Item popRightStack()			右出栈
 */
public class Dstack<Item> {

	private Deque<Item> deque = new Deque<Item>();
	private int leftCount;
	private int rightCount;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean leftStackIsEmpty() {
		return leftCount == 0;
	}
	
	public boolean rightStackIsEmpty() {
		return rightCount == 0;
	}
	
	public int leftStackSize() {
		return leftCount;
	}
	
	public int rightStackSize() {
		return rightCount;
	}
	
	public void pushLeftStack(Item item) {
		deque.pushLeft(item);
		leftCount++;
	}
	
	public void pushRightStack(Item item) {
		deque.pushRight(item);
		rightCount++;
	}
	
	/*
	 * 不考虑为空的情况
	 */
	public Item popLeftStack() {
		leftCount--;
		return deque.popLeft();
	}
	
	/*
	 * 不考虑为空的情况
	 */
	public Item popRightStack() {
		rightCount--;
		return deque.popRight();
	}

	@Override
	public String toString() {
		return deque.toString();
	}
}
