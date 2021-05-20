package chapterone.four;

import java.util.Arrays;

import chapterone.one.BinarySearch;

public class K14 {

	public static void main(String[] args) {
		
	}
	
	public static int count(int[] a) {
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					if (BinarySearch.rank(-a[i]-a[j]-a[k], a) > k) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
