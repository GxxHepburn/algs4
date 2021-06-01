package chapterone.five;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K20 {

	public static void main(String[] args) {
		/**
		 * UF_resizing_weighting_quick_union
		 */
		
		UF_resizing_weighting_quick_union uf = new UF_resizing_weighting_quick_union();
		for (int i = 0; i < 100; i++) {
			uf.newSite();
		}
		
		while (uf.count() != 1) {
			int p = StdRandom.uniform(uf.getSize());
			int q = StdRandom.uniform(uf.getSize());
			
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				StdOut.println("United sites " + p + " and " + q);
			}
		}
		StdOut.println("size: " + uf.getSize() + " , count: " + uf.count());
	}
}
