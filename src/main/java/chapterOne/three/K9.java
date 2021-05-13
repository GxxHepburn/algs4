package chapterone.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 初始化两个栈，一个用于保存运算符，一个用于保存操作数
 * 读取标准输入，将操作数压入操作数栈，将运算符压入运算符栈
 * 在遇到右括号时，弹出一个运算符，弹出两个操作数
 * 组合运算符和操作数，并在两端添加左右括号，将结果压入操作数栈
 * @author gxx
 *
 */
public class K9 {

	// 不支持sqrt
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("+")) {
				ops.push(s);
			} else if(s.equals("-")) {
				ops.push(s);
			} else if(s.equals("*")) {
				ops.push(s);
			} else if(s.equals("/")) {
				ops.push(s);
			} else if(s.equals(")")) {
				String op = ops.pop();
				String v = vals.pop();
				vals.push("(" + " " + vals.pop() + " " + op + " " + v + " " + ")");
			} else {
				vals.push(s);
			}
		}
		StdOut.print(vals.pop());
	}
}
