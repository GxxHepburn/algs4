package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K33 {
	public static void main(String[] args) {
		//	测试Deque
//		Deque<Integer> deque = new Deque<Integer>();
//		deque.pushLeft(1);
//		deque.pushLeft(2);
//		deque.pushLeft(3);
//		StdOut.println(deque);
//		deque.pushRight(4);
//		deque.pushRight(5);
//		deque.pushRight(6);
//		StdOut.println(deque);
//		deque.popLeft();
//		StdOut.println(deque);
//		deque.popRight();
//		StdOut.println(deque);
		
		//	调试ResizingArrayDeque
		ResizingArrayDeque<Integer> resizingArrayDeque = new ResizingArrayDeque<Integer>();
		resizingArrayDeque.pushLeft(1);
		resizingArrayDeque.pushLeft(2);
		resizingArrayDeque.pushLeft(3);
		StdOut.println(resizingArrayDeque);
		resizingArrayDeque.pushRight(4);
		resizingArrayDeque.pushRight(5);
		resizingArrayDeque.pushRight(6);
		StdOut.println(resizingArrayDeque);
		resizingArrayDeque.popLeft();
		StdOut.println(resizingArrayDeque);
		resizingArrayDeque.popRight();
		StdOut.println(resizingArrayDeque);
	}
}
