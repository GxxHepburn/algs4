package chapterone.five;

import java.util.ArrayList;
import java.util.List;

import chapterone.five.K18.Connection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * quick_find ~N^2	ratio:16	明显
 * quick_union ~N^2	ratio:16	波动较大，N值大时才能明显显示ratio靠近16
 * weighting_quick_union ~N ratio 4	明显	
 * 
 * @author gxx
 *
 */
public class K25 {

	public static void main(String[] args) {
		int T = 1;
		int N = 2;
		/*
		 *  UF_quick_find(N)	ratio:	16
		 *  UF_quick_union		ratio:	16
		 *  UF_weighting_quick_union	ratio: 4
		 */
//		UF uf = new UF_quick_find(N*N);
		UF uf = new UF_quick_union(N*N);
//		UF uf = new UF_weighting_quick_union(N*N);
		List<Connection[]> list = new ArrayList<Connection[]>();
		for (int i = 0; i < T; i++) {
			Connection[] connections = new K18().generate(N);
			list.add(connections);
		}
		double prev = 0d;
		
		Stopwatch time = new Stopwatch();
		for (int i = 0; i < T; i++) {
			int left = uf.count();
			int index = 0;
			while (left > 1) {
				int p = list.get(i)[index].p;
				int q = list.get(i)[index].q;
				index++;
				if (uf.connected(p, q)) {
					continue;
				}
				uf.union(p, q);
				left = uf.count();
			}
		}
		prev = time.elapsedTime() * 1.0d / T;
		
		while (true) {
			N += N;
//			uf = new UF_quick_find(N * N);
			uf = new UF_quick_union(N*N);
//			uf = new UF_weighting_quick_union(N*N);
			list = new ArrayList<Connection[]>();
			for (int i = 0; i < T; i++) {
				Connection[] connections = new K18().generate(N);
				list.add(connections);
			}
			double now = 0d;
			int totalUnion = 0;
			time = new Stopwatch();
			for (int i = 0; i < T; i++) {
				int left = uf.count();
				int index = 0;
				while (left > 1) {
					int p = list.get(i)[index].p;
					int q = list.get(i)[index].q;
					index++;
					if (uf.connected(p, q)) {
						totalUnion++;
						continue;
					}
					totalUnion++;
					uf.union(p, q);
					left = uf.count();
				}
			}
			now = time.elapsedTime() * 1.0d / T;
			StdOut.println("N: " + N + " , avg: " + totalUnion / T + " , ratio: " + now/prev);
			prev = now;
		}
	}
}
