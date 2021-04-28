package chapterone.two;

import edu.princeton.cs.algs4.StdOut;

public class K4 {

	public static void main(String[] args) {
		String string1 = "hello";
		String string2 = string1;
		string1 = "world";
		StdOut.println(string1);
		StdOut.println(string2);
		// world
		// hello
		
		int a = 1;
		int b = a;
		a = 2;
		StdOut.println(a);
		StdOut.println(b);
		// 2
		// 1
		/* 两者的区别：
		 * 1、string1 引用指向"hello", string2引用通过string1引用也指向"hello",然后string1引用指向"world"，
		 * 		而string2引用指向仍然是"hello"
		 * 2、int a 被设置为1， int b被设置为a的值1，a又被设置为2，而b仍然是原来的值1
		 * String是引用类型，而int是基本数据类型，两者虽然在测试中表现一样，但是原理不同*/
		
	}
}
