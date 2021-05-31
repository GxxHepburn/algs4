package chapterone.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K1 {

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_quick_find uf = new UF_quick_find(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		StdOut.println(uf.getCount());
	}
}
