package chapterone.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K21 {

	public static void main(String[] args) {
	
		while (!StdIn.isEmpty()) {
			String s = StdIn.readLine();
			String[] ss = s.split(" ");
			StdOut.printf("%s %d %d %.3f\n", ss[0], Integer.parseInt(ss[1]), Integer.parseInt(ss[2]), Double.parseDouble(ss[1])/Double.parseDouble(ss[2]));
		}
	}
}
