package chapterone.two;

import edu.princeton.cs.algs4.StdOut;

public class K10 {

	public static void main(String[] args) {
		int N = 15;
		int max = 3;
		
		VisualCounter visualCounter = new VisualCounter(N, max);
		visualCounter.increament();
		visualCounter.increament();
		visualCounter.increament();
		visualCounter.increament();
		visualCounter.reduce();
		visualCounter.reduce();
		visualCounter.reduce();
		visualCounter.reduce();
		visualCounter.reduce();
		visualCounter.reduce();
		visualCounter.reduce();
		StdOut.println(visualCounter);
	}
}
