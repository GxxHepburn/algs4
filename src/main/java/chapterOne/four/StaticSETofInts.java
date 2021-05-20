package chapterone.four;

import java.util.Arrays;

public class StaticSETofInts {
	
	private int[] a;
	public StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++) {
			a[i] = keys[i];
		}
		Arrays.sort(a);
	}
	
	public boolean contains(int key) {
		return rank(key) != -1;
	}
	
	private int rank(int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public int howMany(int key) {
		// logN
		int mid = rank(key);
		int temp = mid;
		int cnt = 0;
		while (temp > 0) {
			if (a[temp-1] == key) {
				cnt++;
				temp--;
			}  else {
				break;
			}
		}
		temp = mid;
		while (temp < a.length-1) {
			if (a[temp+1] == key) {
				cnt++;
				temp++;
			} else {
				break;
			}
		}
		return 1 + cnt;
	}
}
