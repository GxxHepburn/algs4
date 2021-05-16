package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K32 {

	public static void main(String[] args) {
		//Steque
		Steque<Integer> steque = new Steque<Integer>();
		steque.push(1);
		steque.push(2);
		steque.enqueue(3);
		StdOut.println(steque);
		steque.pop();
		StdOut.println(steque);
	}
}
