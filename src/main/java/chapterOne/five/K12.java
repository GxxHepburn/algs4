package chapterone.five;

import edu.princeton.cs.algs4.StdOut;

public class K12 {

	public static void main(String[] args) {
		/**
		 * UF_path_compression_quick_union
		 */
		UF_path_compression_quick_union uf = new UF_path_compression_quick_union(10);
		uf.union(0, 1);
		uf.union(1, 2);
		uf.union(2, 3);
		uf.union(3, 4);
		for (int i : uf.getId()) {
			StdOut.print(i + " ");
		}
	}
}
