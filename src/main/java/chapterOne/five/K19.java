package chapterone.five;

import chapterone.five.K18.Connection;
import edu.princeton.cs.algs4.StdOut;

public class K19 {

	public static void main(String[] args) {
		int numberOfSites = 30;
		Connection[] connections = new K18().generate(numberOfSites);
		UF_quick_union uf = new UF_quick_union(numberOfSites * numberOfSites);
		int totalcost = 0;
		int i = 0;
		UF_quick_union.initStdDraw();
		for (Connection connection : connections) {
			uf.setCnt(0);
			int p = connection.p;
			int q = connection.q;
			if (uf.connected(p, q)) {
				totalcost += uf.getCnt();
				StdOut.println(uf.getCount());
				i++;
				UF_quick_union.plot(i, uf.getCnt(), totalcost);
				continue;
			}
			uf.union(p, q);
			totalcost += uf.getCnt();
			i++;
			UF_quick_union.plot(i, uf.getCnt(), totalcost);
		}
	}
}
