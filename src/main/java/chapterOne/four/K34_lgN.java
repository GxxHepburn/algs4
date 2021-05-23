package chapterone.four;

import edu.princeton.cs.algs4.StdOut;


/**
 * ~1lgN
 * @author gxx
 * https://blog.csdn.net/weixin_34029949/article/details/94220533?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control
 * https://blog.csdn.net/qq_40569107/article/details/100891014
 *
 */
public class K34_lgN {
	
	static int runTimes = 0;

	public static void main(String[] args) {
//		StdOut.println(findKey(1000, 991) + " cnt: " + runTimes);
		
		int N = 10000;
		int max = 0;
		int avg = 0;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			findKey(N, i);
			int t = runTimes;
			runTimes = 0;
			max = Math.max(t, max);
			sum += t;
		}
		avg = sum / N;
		StdOut.println("max: " + max + " sum: " + sum + " avg: " + avg);
	}
	
	public static int findKey(int N, int key) {
		int prevNum = 1;
		int prevDiff = Math.abs(1 - key);
		if (prevDiff == 0) {
			return prevNum;
		}
		int lo = 1;
		int hi = N;
		int nowNum = (lo + hi) / 2;
		while (nowNum != key) {
			runTimes++;
			int nowDiff = Math.abs(nowNum - key);
			if (nowDiff < prevDiff) {
				if (nowNum > prevNum) {
					lo = (prevNum + nowNum) / 2;
				} else {
					hi = (prevNum + nowNum) / 2;
				}
			} else if (nowDiff > prevDiff) {
				if (nowNum > prevNum) {
					hi = (prevNum + nowNum) / 2;
				} else {
					lo = (prevNum + nowNum) / 2;
				}
			}
			prevDiff = nowDiff;
			if ((lo + hi) / 2 == prevNum) {
				hi += 2;
			}
			prevNum = nowNum;
			nowNum = (lo + hi) / 2;
		}
		return nowNum;
	}
}
