package chapterone.four;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K16 {

	public static void main(String[] args) {
		int size = 10000;
		double[] a = new double[size];
		for (int i = 0; i < size; i++) {
			a[i] = StdRandom.uniform(-100d, 100d);
		}
		minCouple(a);
	}
	
	public static void minCouple(double[] a) {
		Arrays.sort(a);
		double min = Math.abs(a[0] - a[1]);
		int N = a.length;
		int first = 0;
		int second = 1;
		for (int i = 1; i < N; i++) {
			double cur = Math.abs(a[i]-a[i-1]);
			if (min > cur) {
				min = cur;
				first = i-1;
				second = i;
			}
		}
		StdOut.println("min: " + min + " ,first: "
				+ first + " value: " + a[first]
				+ " ,seconde: " + second + " value: " + a[second]);
	}
}
