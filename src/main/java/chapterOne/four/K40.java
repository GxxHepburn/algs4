package chapterone.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * ~N^2
 * T(2N)/T(N) = (2N)^2/N^2 = 4
 * Tn = (Tn/2) * 4
 * @author gxx
 *
 */
public class K40 {

	public static void main(String[] args) {
		int pin = 100;
		double prev;
		double prevSum = 0;
		for (int i = 0; i < pin; i++) {
			prevSum += DoublingTest.timerTrial(125);
		}
		prev = prevSum / pin;
		for (int N = 250; true; N += N) {
			double timeSum = 0;
			for (int i = 0; i < pin; i++) {
				timeSum += timerTrial(N);
			}
			double time = timeSum / pin;
			StdOut.printf("%6d %7.1f ", N, time);
			StdOut.printf("%5.1f\n", time/prev);
			prev = time;
		}
	}
	

	
	private static double timerTrial(int n) {
		int max = 1000000;
		int[] values = new int[n];
		for(int i = 0; i < n; i++) {
            values[i] = StdRandom.uniform(-max, max);
        }
		Stopwatch timer = new Stopwatch();
		threeSumCount(values);
		return timer.elapsedTime();
	}
	
	private static int threeSumCount(int[] values) {
		Map<Integer, List<Integer>> numbers = new HashMap<Integer, List<Integer>>();
		
		for (int i = 0; i < values.length; i++) {
			List<Integer> indexesOfNumber = numbers.get(values[i]);
			
			if (indexesOfNumber == null) {
				List<Integer> indexes = new ArrayList<Integer>();
				indexes.add(i);
				
				numbers.put(values[i], indexes);
			} else {
				indexesOfNumber.add(i);
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < values.length - 1; i++) {
			for (int j = i + 1; j < values.length; j++) {
				int neededNumberForATriple = (values[i] + values[j]) * -1;
				
				List<Integer> indexes = numbers.get(neededNumberForATriple);
				
				if (indexes != null) {
					for (int index : indexes) {
						if (index > i && index > j) {
							count++;
							break;
						}
					}
				}
			}
		}
		return count;
	}
}
