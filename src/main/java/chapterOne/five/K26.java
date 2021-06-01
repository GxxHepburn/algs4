package chapterone.five;

import edu.princeton.cs.algs4.StdRandom;

public class K26 {

	public static void main(String[] args) {
		int N = 625;
//		UF uf = new UF_quick_find(N);
		UF uf = new UF_quick_union(N);
//		UF uf = new UF_weighting_quick_union(N);
//		UF uf = new UF_path_compression_weighting_quick_union(N);
		int left = uf.count();
		
		int totalCost = 0;
		int i = 0;
		UF_quick_find.initStdDraw();
		
		while (left > 1) {
			uf.setCnt(0);
			int p = StdRandom.uniform(N);
			int q = StdRandom.uniform(N);
			if (uf.connected(p, q)) {
				totalCost += uf.getCnt();
				i++;
				UF_quick_find.plot(i, uf.getCnt(), totalCost);
				continue;
			}
			uf.union(p, q);
			totalCost += uf.getCnt();
			i++;
			UF_quick_find.plot(i, uf.getCnt(), totalCost);
			left = uf.count();
		}
	}
}
