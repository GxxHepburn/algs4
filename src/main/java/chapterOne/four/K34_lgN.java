package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

/**
 * ~1lgN
 * @author gxx
 *
 */
public class K34_lgN {
	
	static int runTimes = 0;

	public static void main(String[] args) {
		StdOut.println(lgN(10000, 991) + " cnt: " + runTimes);
		
		int N = 10000000;
		int max = 0;
		int avg = 0;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			lgN(N, i);
			int t = runTimes;
			runTimes = 0;
			max = Math.max(t, max);
			sum += t;
		}
		avg = sum / N;
		StdOut.println("max: " + max + " sum: " + sum + " avg: " + avg);
	}
	
	public static int lgN(int N, int key) {
		int lo = 1;
		int hi = N;
		
		int g1 = lo;
		int g2 = hi;
		
		if (g1 == key) {
			return g1;
		}
		while (true) {
			runTimes++;
			if (g2 == key) {
				return g2;
			} else if (Math.abs(g1 - key) > Math.abs(g2 - key)) {
				if (lo == farBoundary(lo, hi, g2)) {
					if (lo == (lo + hi) / 2) {
						lo++;
					} else {
						lo = (lo + hi) / 2;
					}
				} else {
					if (hi == (lo + hi) / 2) {
						hi--;
					} else {
						hi = (lo + hi) / 2;
					}
				}
				g1 = g2;
				g2 = nextGuess(lo, hi, g2);
			} else if (Math.abs(g1 - key) < Math.abs(g2 - key)) {
				if (lo == nearBoundary(lo, hi, g2)) {
					if (lo == (lo + hi) / 2) {
						lo++;
					} else {
						lo = (lo + hi) / 2;
					}
				} else {
					if (hi == (lo + hi) / 2) {
						hi--;
					} else {
						hi = (lo + hi) / 2;
					}
				}
				g1 = g2;
				g2 = nextGuess(lo, hi, g2);
			} else {
				g1 = g2;
				g2 = (lo + hi) / 2;
			}
		}
	}
	
	private static int nextGuess(int lo, int hi, int currentGuess) {
		return lo + hi - currentGuess;
	}
	
	private static int farBoundary(int lo, int hi, int guess) {
		if (Math.abs(guess - lo) < Math.abs(guess - hi)) {
			return hi;
		} else {
			return lo;
		}
	}
	
	private static int nearBoundary(int lo, int hi, int guess) {
		if (Math.abs(guess - lo) < Math.abs(guess - hi)) {
			return lo;
		} else {
			return hi;
		}
	}
}
