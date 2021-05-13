package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K6 {

	public static void main(String[] args) {
		// 将q中元素倒叙排列
		Queue<String> q = new Queue<String>();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		Stack<String> stack = new Stack<String>();
		while (!q.isEmpty()) {
			stack.push(q.dequeue());
		}
		while (!stack.isEmpty()) {
			q.enqueue(stack.pop());
		}
		for (String str : q) {
			StdOut.println(str);
		}
	}
}
