package chapterone.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Dijkstra双栈算法
 * 遇到数字则压入数字栈中(String)
 * 遇到运算符则压入运算符栈中(String)
 * 遇到右括号，从数字栈和运算符栈中弹出相应的元素，生成相应的运算表达式(后缀表示)
 * 再次压入数字栈中(String)
 * 最后从数字栈中弹出最终的运算表达式
 * @author gxx
 *
 */
public class K10 {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		int N = 0;
		while (!StdIn.isEmpty()) {
			StdOut.println(N++);
			String s = StdIn.readString();
			if (s.equals("(")) {
				
			} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				String val = vals.pop();
				String subExpression = vals.pop() + " " + val + " " + op;
				vals.push(subExpression);
			} else {
				vals.push(s);
			}
		}
		StdOut.println(vals.pop());
	}
}
