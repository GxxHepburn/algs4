package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class K34_2lgN {

	static int runTimes = 0;

	public static void main(String[] args) {
//		StdOut.println(guessKey2lgN(1000, 991) + " cnt: " + runTimes);
		int N = 100;
		int max = 0;
		int avg = 0;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			guessKey2lgN(N, i);
			int t = runTimes;
			runTimes = 0;
			max = Math.max(t, max);
			sum += t;
		}
		avg = sum / N;
		StdOut.println("max: " + max + " sum: " + sum + " avg: " + avg);
	}
	
	// 运行一次猜两次，运行lgN次，所以猜测了~2lgN次
	public static int guessKey2lgN(int N, int key) {
		int guess1 = 1;
		int guess2 = N;
		int guessResult;
		while (true) {
			runTimes++;
			guessResult = guessTwoNumber(guess1, guess2, key);
			if (guessResult == 1) {
				return guess1;
			} else if (guessResult == 2) {
				return guess2;
			} else if (guessResult == 3) {
				guess1 = (guess1 + guess2) / 2;
			} else {
				guess2 = (guess1 + guess2) / 2;
			}
		}
	}
	
	public static int guessTwoNumber(int guess1, int guess2, int key) {
		if (guess1 == key) {
			return 1;//guess1
		} else if (guess2 == key) {
			return 2;//guess2
		} else if (Math.abs(guess1 - key) > Math.abs(guess2 - key)) {
			return 3;//hot
		} else {
			return 4;//cold
		}
	}
}
