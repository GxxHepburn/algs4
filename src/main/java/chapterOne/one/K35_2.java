package chapterOne.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class K35_2 {

	public static int SIDES = 6;
	
	public static void main(String[] args) {
		double[] dist0 = theoreticalValue();
		print(dist0);
		int initTimes = 10000;
		int N = testGetN(initTimes, dist0);
		StdOut.println("至少试验次数: " + N);
	}
	
	/**
	 * 打印
	 * @param dist
	 */
	public static void print(double[] dist) {
		for (int i = 2; i <= 2*SIDES; i++) {
			StdOut.println(dist[i]);
		}
		StdOut.println("----------------------------------");
	}
	
	/**
	 * 根据统计数据计算概率值
	 * @param dist
	 * @param testTimes
	 * @return 概率数组
	 */
	public static double[] computeProbobility(double[] dist, int testTimes) {
		for (int i = 0; i <= 2*SIDES; i++) {
			dist[i] /= (1.0*testTimes);
		}
		return dist;
	}
	
	/**
	 * 两个骰子之和的理论概率值
	 * @return	理论概率值
	 */
	public static double[] theoreticalValue() {
		double[] dist = new double[2 * SIDES + 1];
		// 统计值出现的理论次数
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dist[i+j] += 1.0;
			}
		}
		// 计算理论概率
		dist = computeProbobility(dist, 36);
		return dist;
	}
	
	/**
	 * 用随机数模拟掷骰子并统计求出实验概率
	 * @param N
	 * @return
	 */
	public static double[] simulate(int N) {
		double[] dist = new double[2 * SIDES + 1];
		//做N次随机实验模拟抛骰子，并统计数据
		for (int i = 0; i < N; i++) {
			int a = StdRandom.uniform(1, 6+1);
			int b = StdRandom.uniform(1, 6+1);
			dist[a+b] += 1.0;
		}
		dist = computeProbobility(dist, N);
		return dist;
	}
	
	/**
	 * 实验概率值能否与理论概率值至少匹配到小数点后三位
	 * @param dist0
	 * @param dist1
	 * @return
	 */
	public static boolean isMatch(double[] dist0, double[] dist1) {
		for (int i = 2; i <= 2*SIDES; i++) {
			if (Math.abs(dist0[i] - dist1[i]) >= 0.0001) {
				return false;
			}
		}
		return true;
	}
	
	public static int testGetN(int initTimes, double[] dist0) {
		int N = initTimes;
		boolean match = false;
		while (!match) {
			double[] dist1 = simulate(N);
			match = isMatch(dist0, dist1);
			if (match) {
				print(dist1);
			} else {
				N *= 10;
			}
		}
		return N;
	}
}
