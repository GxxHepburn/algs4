package chapterone.four;

import chapterone.three.ResizingArrayStack;
import chapterone.three.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/*
 * Resizing arrays are faster than linked lists for stacks.
 */
public class K43 {

	public static void main(String[] args) {
		for (int N = 100000; true; N += N) {
			double timer = timerTrial(N);
			double timerResizing = timerTrialResizing(N);
			StdOut.printf("%7.1f %7.1f ", timer, timerResizing);
			StdOut.printf("%7.1f\n", timer/timerResizing);
		}
	}
	
	public static double timerTrial(int N) {
		Stopwatch timer = new Stopwatch();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			stack.push(i);
		}
		for (int i = 0; i < N; i++) {
			stack.pop();
		}
		return timer.elapsedTime();
	}
	
	public static double timerTrialResizing(int N) {
		Stopwatch timer = new Stopwatch();
		ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>();
		for (int i = 0; i < N; i++) {
			stack.push(i);
		}
		for (int i = 0; i < N; i++) {
			stack.pop();
		}
		return timer.elapsedTime();
	}
}
