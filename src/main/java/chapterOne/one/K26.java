package chapterOne.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K26 {

	public static void main(String[] args) {
		int a = StdIn.readInt();
		int b = StdIn.readInt();
		int c = StdIn.readInt();
		int t;
		if (a > b) {
			t = a;
			a = b;
			b = t;
		}

		StdOut.println("a = " + a + ", b = " + b + ", c = " + c);
		if (a > c) {
			t = a;
			a = c;
			c = t;
		}
		// 前两次将最小值放到a
		// 最后一次 比较b和c的大小

		StdOut.println("a = " + a + ", b = " + b + ", c = " + c);
		if (b > c) {
			t = b;
			b = c;
			c = t;
		}
		StdOut.println("a = " + a + ", b = " + b + ", c = " + c);
	}	
}
