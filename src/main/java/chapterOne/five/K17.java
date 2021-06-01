package chapterone.five;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K17 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		StdOut.println("count: " + count(N));
	}
	
	public static int count(int N) {
//		UF_weighting_quick_union uf = new UF_weighting_quick_union(N);
		//	K22
//		UF_quick_union uf = new UF_quick_union(N);
		UF_quick_find uf = new UF_quick_find(N);
		
		
		int left = uf.count();
		int total = 0;
		while (left > 1) {
			total++;
			int p = StdRandom.uniform(N);
			int q = StdRandom.uniform(N);
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			left = uf.count();
		}
		return total;
	}
}
