package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K44 {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		buffer.insert('1');
		buffer.insert('2');
		buffer.insert('3');
		buffer.insert('4');
		buffer.insert('5');
		StdOut.println(buffer);
		buffer.left(1);
		buffer.insert('6');
		StdOut.println(buffer);
		buffer.delete();
		StdOut.println(buffer);
		buffer.right(1);
		buffer.insert('7');
		StdOut.println(buffer);
	}
}
