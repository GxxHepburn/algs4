package chapterone.four;

import chapterone.three.FixCapacityStack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class K37 {

	public static void main(String[] args) {
		int N = 10000000;
		double prev = timerTrial(N);
		double prevInteger = timerTrialInteger(N);
		for (; true; N += N) {
			double time = timerTrial(N);
			double timeInteger = timerTrialInteger(N);
			StdOut.printf("%6d %7.1f ", N, time);
			StdOut.printf("%5.1f", time/prev);
			
			StdOut.print("-------------");
			StdOut.printf("%6d %7.1f ", N, timeInteger);
			StdOut.printf("%5.1f\n", timeInteger/prevInteger);
			prev = time;
			prevInteger = timeInteger;
		}
	}
	
	public static double timerTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch timer = new Stopwatch();
		FixedCapacityStackOfInts fixedCapacityStackOfInts = new FixedCapacityStackOfInts(N);
		for (int i = 0; i < N; i++) {
			fixedCapacityStackOfInts.push(i);
		}
		for (int i = 0; i < N; i++) {
			fixedCapacityStackOfInts.pop();
		}
		return timer.elapsedTime();
	}
	
	public static double timerTrialInteger(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch timer = new Stopwatch();
		FixCapacityStack<Integer> fixCapacityStack = new FixCapacityStack<Integer>(N);
		for (int i = 0; i < N; i++) {
			fixCapacityStack.push(i);
		}
		for (int i = 0; i < N; i++) {
			fixCapacityStack.pop();
		}
		return timer.elapsedTime();
	}
}
