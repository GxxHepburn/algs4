package chapterOne.one;

import edu.princeton.cs.algs4.StdOut;

public class K33 {


	// 库名Matrix
	public static void main(String[] args) {
		StdOut.println("--------------向量点乘---------------");
		double[] a0 = {1, 2, 3};
		double[] b0 = {4, 5, 6};
		double res0 = Matrix.dot(a0, b0);
		StdOut.println(res0);
		
		StdOut.println("----------------矩阵乘法----------------");
		double[][] a1 = {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		double[][] b1 = {
				{1, 2, 3},
				{4, 5, 6}
		};
		double[][] res1 = Matrix.mult(a1, b1);
		for (int i = 0; i < res1.length; i++) {
			for (int j = 0; j < res1[i].length; j++) {
				StdOut.printf("%-10.3f", res1[i][j]);
			}
			StdOut.println();
		}
		
		StdOut.println("-------- 矩阵转置 ---------");
		double[][] a2 = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		Matrix.transpose(a2);
		for(int i = 0; i < a2.length; ++i) {
			for (int j = 0; j < a2[i].length; ++j)
				StdOut.printf("%-10.3f", a2[i][j]);
			StdOut.println();
		}
		
		StdOut.println("---------------矩阵和向量之积--------------------");
		double[][] a3 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		double[] b3 = {1, 2, 3};
		double[] c3 = Matrix.mult(a3, b3);
		for (int i = 0; i < c3.length; i++) {
			StdOut.printf("%-10.3f\n", c3[i]);
		}
		
		
		StdOut.println("----- 向量和矩阵之积 ------");
		double[] a4 = {1, 2, 3};
		double[][] b4 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		double[] c4 = Matrix.mult(a4, b4);
		for (int i = 0; i < c4.length; i++) {
			StdOut.printf("%-10.3f", c4[i]);
		}
	}
}
