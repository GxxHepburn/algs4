package chapterone.four;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class K38 {

	public static void main(String[] args) {
		Map<Integer, Double> timesOfNaiveThreeSum = new HashMap<Integer, Double>();
		Map<Integer, Double> timesOfEvenNaiverThreeSum = new HashMap<Integer, Double>();
		int maxTrials = 4000;
		StdOut.println("Number of items and ratio");
		for (int n = 250; n <= maxTrials; n+=n) {
			double time = timeTrial(n, false);
			timesOfNaiveThreeSum.put(n, time);
		}
		
		for (int n = 250; n <= maxTrials; n+=n) {
			double time = timeTrial(n, true);
			timesOfEvenNaiverThreeSum.put(n, time);
		}
		
		for (int n = 250; n <= maxTrials; n+=n) {
			double timeOfNaiveThreeSum  = timesOfNaiveThreeSum.get(n);
			double timeOfEvenNaiverThreeSum = timesOfEvenNaiverThreeSum.get(n);
			
			double ratio = timeOfEvenNaiverThreeSum / timeOfNaiveThreeSum;
			StdOut.printf("%7d %5.1f\n", n, ratio);
		}
	}
	
	private static double timeTrial(int n, boolean useEvenNaiverImplementation) {
		int max = 1000000;
		int[] values = new int[n];
		
		for (int i = 0; i < n; i++) {
			values[i] = StdRandom.uniform(-max, max);
		}
		Stopwatch time = new Stopwatch();
		if (useEvenNaiverImplementation) {
			evenNaiverThreeSumCount(values);
		} else {
			threeSumCount(values);
		}
		return time.elapsedTime();
	}
	
	private static int threeSumCount(int[] values) {
		int n = values.length;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (values[i] + values[j] + values[k] == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	private static int evenNaiverThreeSumCount(int[] values) {
		int n = values.length;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i < j && j < k) {
						if (values[i] + values[j] + values[k] == 0) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}
}
