package chapterone.five;

import edu.princeton.cs.algs4.StdOut;

/**
 * The height of a tree will only increase when uniting with a tree of the same height,
 * otherwise the smaller tree will join the biggest tree.
 * This guaratees a logarithmic upper bound on the height of the trees of N sites.
 * The size of a tree will be at most 2^height.Therefore, the height can increase at most lgN times.
 * @author gxx
 *
 */
public class K14 {

	public static void main(String[] args) {
		UF_highting_quick_union uf = new UF_highting_quick_union(19);
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
		StdOut.println();
		
		StdOut.println("Components: " + uf.count() + " Expected: 3");
		StdOut.println("Maximum height: " + uf.getMaxHeight() + " Expected: Equal or less than 5 for N = 19" +
                " (lg 19 = 5)");
	}
}
