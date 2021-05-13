package chapterone.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K11 {

	public static void main(String[] args) {
		
		String[] subExs = subExs();
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		for (String s : subExs) {
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				Integer r = Integer.parseInt(vals.pop());
				Integer l = Integer.parseInt(vals.pop());
				if (s.equals("+")) {
					vals.push((l + r) + "");
				}
				if (s.equals("-")) {
					vals.push((l - r) + "");
				}
				if (s.equals("*")) {
					vals.push((l * r) + "");
				}
				if (s.equals("/")) {
					vals.push((l / r) + "");
				}
			} else {
				vals.push(s);
			}
		}
		StdOut.println(vals.pop());
	}
	
	public static String[] subExs () {
		// 中序变后续表达式
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		int N = 0;
		while (!StdIn.isEmpty()) {
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
		String subEx = vals.pop();
		String[] subExs = subEx.split(" ");
		return subExs;
	}
}
