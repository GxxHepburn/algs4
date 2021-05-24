package chapterone.four;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class K41 {

	public static void main(String[] args) {
		
		StdOut.println("TwoSum");
        runExperiments(0);

        //TwoSumFast
        StdOut.println("TwoSumFast");
        runExperiments(1);

        //ThreeSum
        StdOut.println("ThreeSum");
        runExperiments(2);

        //ThreeSumFast
        StdOut.println("ThreeSumFast");
        runExperiments(3);
	}
	
	private static double timerTrial(int n, int sumMethod) {
		int max = 1000000;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = StdRandom.uniform(-max, max);
		}
		
		Stopwatch timer = new Stopwatch();
		switch (sumMethod) {
			case 0: 
				TwoSum.count(numbers);
				break;
			case 1:
				TwoSumFast.count(numbers);
				break;
			case 2:
				ThreeSum.count(numbers);
				break;
			case 3:
				ThreeSumFast.count(numbers);
				break;
		}
		return timer.elapsedTime();
	}
	
	private static void runExperiments(int sumMethod) {

        double previousTime = timerTrial(125, sumMethod);

        StdOut.printf("%6s %7s %5s\n", "N", "Time", "Ratio");

        for(int n = 250; n <= 8000; n += n) {
            double time = timerTrial(n, sumMethod);
            StdOut.printf("%6d %7.1f ", n, time);
            StdOut.printf("%5.1f\n", time / previousTime);
            previousTime = time;
        }
    }
}
