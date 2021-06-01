package chapterone.five;

import chapterone.three.RandomBag;
import edu.princeton.cs.algs4.StdOut;

public class K18 {

	public static void main(String[] args) {
		int numberOfSites = 10;
		Connection[] connections = generate(numberOfSites);
		StdOut.println("Connections");
		for (Connection connection : connections) {
			StdOut.println(connection.p + " - " + connection.q);
		}
	}
	
	public static class Connection {
		int p;
		int q;
		
		public Connection(int p, int q) {
			this.p = p;
			this.q = q;
		}
	}
	
	public static Connection[] generate(int numberOfSites) {
		RandomBag<Connection> randomBag = new RandomBag<Connection>();
		
		for (int i = 0; i < numberOfSites; i++) {
			for (int j = 0; j < numberOfSites; j++) {
				if (i != j) {
					Connection connection = new Connection(i, j);
					randomBag.add(connection);
				}
			}
		}
		
		Connection[] connections = new Connection[randomBag.size()];
		int index = 0;
		
		for (Connection connection : randomBag) {
			connections[index++] = connection;
		}
		return connections;
	}
}
