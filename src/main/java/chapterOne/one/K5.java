package chapterone.one;

import edu.princeton.cs.algs4.StdOut;

public class K5 {

	public static void main(String[] args) {
		double x = 0.0d;
		double y = 1.0d;
		// 不许1d 应为java会自动类型转换，将1 转换为 1d
		if (x < 1 && x > 0 && y < 1 && y > 0) {
			StdOut.print(true);
		} else {
			StdOut.print(false);
		}
	}
}
