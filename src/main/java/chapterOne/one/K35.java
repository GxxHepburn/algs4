package chapterOne.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K35 {

	public static void main(String[] args) {
		
		double[] dist = dist();
		
		// 算出来10000000次可以保证
		int t = 10000000;
		int SIDES = 6;
		int one;
		int two;
		double[] md = new double[2*SIDES+1];
		for (int i = 0; i < t; i++) {
			one = StdRandom.uniform(1, 7);
			two = StdRandom.uniform(1, 7);
			md[one+two] += 1.0;
		}
		for (int k = 2; k <= 2*SIDES; k++) {
			md[k] /= t;
		}
		
		for (int k = 2; k <= 2*SIDES; k++) {
			StdOut.println("和: " + k + ", 概率: " + md[k] + ", 标准概率: " + dist[k]);
		}
	}
	
	public static double[] dist() {
		int SIDES = 6;
		double[] dist = new double[2*SIDES+1];
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dist[i+j] += 1.0;
			}
		}
		for (int k = 2; k <= 2*SIDES; k++) {
			dist[k] /= 36.0;
		}
		return dist;
	}
}
