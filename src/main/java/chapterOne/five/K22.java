package chapterone.five;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class K22 {

	public static void main(String[] args) {
		// 倍率实验初始规模
		int N = 10;
		// 对于每种规模运行次数
		int T = 1;
		double prev = 0d;
		
		Stopwatch time = new Stopwatch();
		for (int i = 0; i < T; i++) {
			K17.count(N);
		}
		prev = time.elapsedTime()/ 5d;
		
		while (true) {
			int totalUnion = 0;
			int avgUnion = 0;
			double now = 0d;
			N += N;
			Stopwatch t = new Stopwatch();
			for (int i = 0; i < T; i++) {
				totalUnion += K17.count(N);
			}
			now = t.elapsedTime() / 5d;
			avgUnion = totalUnion / 5;
			StdOut.println("N: " + N + " , avgUnion: " + avgUnion + " , now/prev: " + now / prev);
			prev = now;
		}
	}
}
