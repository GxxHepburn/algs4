package chapterone.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K8 {

	/*
	 * was best times of the was the it (1 left on stack)
	 * it 
	 */
	public static void main(String[] args) {
		DoublingStackOfStrings doublingStackOfStrings = new DoublingStackOfStrings();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				doublingStackOfStrings.push(item);
			} else if (!doublingStackOfStrings.isEmpty()) {
				StdOut.print(doublingStackOfStrings.pop() + " ");
			}
		}
		StdOut.println("(" + doublingStackOfStrings.size() + " left on stack)");
		for (String str : doublingStackOfStrings) {
			StdOut.print(str + " ");
		}
	}
}
