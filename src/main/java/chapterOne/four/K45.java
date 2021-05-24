package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K45 {

	public static void main(String[] args) {
		int N = 1024;
		int cnt = k45(N);
		double tobe = N * harmonicSum(N);
		StdOut.println("cnt: " + cnt + " ,tobe: " + tobe);
	}
	
	public static double harmonicSum(int N) {
		double sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += 1.0 / i;
		}
		return sum;
	}
	
	public static int k45(int N) {
		int cnt = 0;
		int[] a = new int[N];
		int notHas = N;
		while (true) {
			int index = StdRandom.uniform(N);
			cnt++;
			if (a[index] == 0) {
				a[index] = 1;
				notHas--;
			}
			if (notHas == 0) {
				break;
			}
		}
		return cnt;
	}
}
