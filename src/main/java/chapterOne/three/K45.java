package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

/**
 * 栈的可生成性
 * @author gxx
 *
 */

/*
 * 两个算法
 * 1、有一批数字与"-"混合的序列，是数字则将该数字入栈，是"-"将数字出栈，判断栈是否向下溢出
 * 2、已知一个数字序列(序列中数字为0到N-1，可以混乱),判断这个序列能否由数字0到N-1的入栈出栈
 * 	生成(入栈时顺寻由0到N-1，出栈可在数字入栈之间的任何时候进行)，如果可以，打印出数字的入栈出
 * 	栈顺寻，出栈用"-"表示。
 */

public class K45 {

	public static void main(String[] args) {
		String[] strUnderflow = {"1", "-", "-"};
		if (isUnderflow(strUnderflow)) {
			StdOut.println("UnderFlow");
		} else {
			StdOut.println("No-UnderFlow");
		}
		
		String[] sequence = {"2","5","6","7","4","8","9","3","1","0"};
		Queue<String> queue;
		if ((queue = stackIsGenerate(sequence)) != null) {
			for (String s : queue) {
				StdOut.print(s + " ");
			}
			StdOut.println();
		} else {
			StdOut.println("don't generated");
		}
		
		String[] sequence2 = {"0","4","6","5","3","8","1","7","2","9"};
		Queue<String> queue2;
		if ((queue2 = stackIsGenerate(sequence2)) != null) {
			for (String s : queue2) {
				StdOut.print(s + " ");
			}
			StdOut.println();
		} else {
			StdOut.println("don't generated");
		}
	}
	
	public static boolean isUnderflow(String[] sequence) {
		boolean ans = false;
		int count = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i].equals("-") ) {
				count--;
			} else {
				count++;
			}
			if (count < 0) {
				ans =  true;
				break;
			}
		}
		return ans;
	}
	
	public static Queue<String> stackIsGenerate(String[] sequence) {
		Queue<String> queue = new Queue<String>();
		Stack<Integer> stack = new Stack<Integer>();
		int insertedMaximum = -1;
		for (int i = 0; i < sequence.length; i++) {
			if (Integer.parseInt(sequence[i]) > insertedMaximum) {
				for (int j = insertedMaximum+1; j <= Integer.parseInt(sequence[i]); j++) {
					stack.push(j);
					queue.enqueue(Integer.toString(j));
				}
				stack.pop();
				queue.enqueue("-");
				insertedMaximum = Integer.parseInt(sequence[i]);
			} else {
				int currentMaximum = stack.pop();
				queue.enqueue("-");
				if (Integer.parseInt(sequence[i]) == currentMaximum) {
					
				} else {
					return null;
				}
			}
		}
		return queue;
	}
}
