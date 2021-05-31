package chapterone.five;

import edu.princeton.cs.algs4.StdOut;

public class K13 {

	public static void main(String[] args) {
		/*
		 * UF_path_compression_weighting_quick_union
		 */
		UF_path_compression_weighting_quick_union uf = new UF_path_compression_weighting_quick_union(19);
		uf.union(0, 1);
		uf.union(0, 2);
		uf.union(0, 3);
		uf.union(6, 7);
		uf.union(8, 9);
		uf.union(6, 8);
		uf.union(0, 6);
		uf.union(10, 11);
		uf.union(10, 12);
		uf.union(10, 13);
		uf.union(10, 14);
		uf.union(10, 15);
		uf.union(10, 16);
		uf.union(10, 17);
		uf.union(10, 18);
		uf.union(0, 10);
		
		for (int i : uf.getId()) {
			StdOut.print(i + " ");
		}
	}
}
