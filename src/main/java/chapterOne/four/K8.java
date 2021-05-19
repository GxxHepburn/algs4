package chapterone.four;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class K8 {

	public static void main(String[] args) {
		int[] a = {1, 1, 2, 2, 2, 3};
		StdOut.println(countFast(a));
	}
	
	/**
	 * ~N^2
	 * @param a
	 * @return
	 */
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if (a[i] == a[j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	/**
	 * ~NlgN
	 * 排序NlgN
	 * 比较N
	 * 合计：N+NlgN~NlgN
	 * @param a
	 * @return
	 */
	public static int countFast(int[] a) {
		Arrays.parallelSort(a);
		int N = a.length;
		int cnt = 0;
		int current = a[0];
		for (int i = 1; i < N; i++) {
			if (a[i] == current) {
				cnt++;
			} else {
				current = a[i];
			}
		}
		return cnt;
	}
}
