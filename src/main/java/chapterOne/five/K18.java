package chapterone.five;

import chapterone.three.RandomBag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K18 {

	public static void main(String[] args) {
		int numberOfSites = 10;
		
		Connection[] connections = new K18().generate(numberOfSites);
		StdOut.println("Connections");
		for (Connection connection : connections) {
			StdOut.println(connection.p + " - " + connection.q);
		}
	}
	
	public class Connection {
		int p;
		int q;
		
		public Connection(int p, int q) {
			this.p = p;
			this.q = q;
		}
	}
	
	public Connection[] generate(int numberOfSites) {
		RandomBag<Connection> randomBag = new RandomBag<Connection>();
		UF uf = new UF_path_compression_weighting_quick_union(numberOfSites * numberOfSites);
		int left = uf.count();
		while (left > 1) {
			int p = StdRandom.uniform(numberOfSites*numberOfSites);
			int q = StdRandom.uniform(numberOfSites*numberOfSites);
			if (uf.connected(p, q)) {
				continue;
			}
			if (p != q) {
				Connection connection = new Connection(p, q);
				randomBag.add(connection);
			}
			uf.union(p, q);
			left = uf.count();
		}
		
		Connection[] connections = new Connection[randomBag.size()];
		int index = 0;
		
		for (Connection connection : randomBag) {
			connections[index++] = connection;
		}
		return connections;
	}
}
