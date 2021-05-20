package chapterone.four;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;


/*
 * 各数均不相同
 */
public class K15 {

	public static void main(String[] args) {
		int[] a = {-2, -1 ,0, 1, 2, 4};
		StdOut.println(twoSum(a));
	
		int[] b = {-4, -2, -1, 0, 1, 2, 3, 4};
		StdOut.println(threeSum(b));
		StdOut.println(ThreeSumFast.count(b));
	}
	
	/*
	 * a的大小>=2
	 */
	public static int  twoSum(int[] a) {
		Arrays.sort(a);
		int lo = 0;
		int hi = a.length-1;
		int cnt = 0;
		while (a[lo]<0 && a[hi]>0 && lo<hi) {
			int sum = a[lo]+a[hi];
			if (sum < 0) {
				lo++;
			} else if(sum > 0) {
				hi--;
			} else {
				cnt++;
				lo++;
				hi--;
			}
		}
		return  cnt;
	}
	
	public static int threeSum(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++)  {
			int lo;
			int hi;
			for (lo=i+1, hi=a.length-1; lo < hi;) {
				if (a[i]+a[lo]+a[hi] > 0) {
					hi--;
				} else if (a[i]+a[lo]+a[hi]<0) {
					lo++;
				} else {
					cnt++;
					lo++;
					hi--;
				}
			}
		}
		return cnt;
	}
}
