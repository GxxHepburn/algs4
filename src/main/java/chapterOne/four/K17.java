package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K17 {

	public static void main(String[] args) {
		int size = 10000;
		double[] a = new double[size];
		for (int i = 0; i < size; i++) {
			a[i] = StdRandom.uniform(-100d, 100d);
		}
		maxCouple(a);
	}
	
	public static void maxCouple(double[] a) {
		double min = a[0];
		double max = a[0];
		int N = a.length;
		int first = 0;
		int second = 0;
		for (int i = 0; i < N; i++) {
			if (min > a[i]) {
				min = a[i];
				first = i;
			}
			if (max < a[i]) {
				max = a[i];
				second = i;
			}
		}
		StdOut.println("first: "
				+ first + " value: " + a[first]
				+ " ,seconde: " + second + " value: " + a[second]);
	}
}
