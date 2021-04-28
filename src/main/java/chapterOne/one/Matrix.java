package chapterone.one;

import edu.princeton.cs.algs4.StdOut;

public class Matrix {

	/**
	 * 向量点乘
	 * @param x
	 * @param y
	 * @return
	 */
	public static double dot(double[] x, double[] y) {
		// 两向量行列数必须相同才能进行点乘
		if (x.length != y.length) {
			StdOut.println("两向量行列数必须相同才能进行点乘");
			System.exit(-1);
		}
		double sum = 0.0;
		for (int i = 0; i < x.length; i++) {
			sum += (x[i] * y[i]);
		}
		return sum;
	}
	
	/**
	 * 矩阵和矩阵之积
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] mult(double[][] a, double[][] b) {
		//只有矩阵a的列数等于矩阵b的行数时，相乘才有意义
		if (a[0].length != b.length) {
			StdOut.println("只有矩阵a的列数等于矩阵b的行数时，相乘才有意义");
			System.exit(-1);
		}
		double[][] matrix = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < b.length; k++) {
					matrix[i][j] += (a[i][k] * b[k][j]);
				}
			}
		}
		return matrix;
	}
	
	/**
	 * 转置矩阵
	 * @param a
	 * @return
	 */
	public static double[][] transpose(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				double temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		return a;
	}
	
	/**
	 * 矩阵和向量之积
	 * @param a
	 * @param x
	 * @return
	 */
	public static double[] mult(double[][] a, double[] x) {
		// 矩阵列必须等于向量行数才有意义
		if (a[0].length != x.length) {
			StdOut.println("矩阵列必须等于向量行数才有意义");
			System.exit(-1);
		}
		double[] matrix = new double[x.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < x.length; j++) {
				matrix[i] += a[i][j] * x[j];
			}
		}
		return matrix;
	}
	
	/**
	 * 向量和矩阵之积
	 * @param y
	 * @param a
	 * @return
	 */
	public static double[] mult(double[] y, double[][] a) {
		// 向量的列数必须等于矩阵的行数才有意义
		if (y.length != a.length) {
			StdOut.println("向量的列数必须等于矩阵的行数才有意义");
			System.exit(-1);
		}
		double[] matrix = new double[y.length];
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				matrix[i] += y[j] * a[j][i];
			}
		}
		return matrix;
	}
}
