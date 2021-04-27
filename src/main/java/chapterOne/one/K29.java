package chapterOne.one;

public class K29 {

	public static void main(String[] args) {
		
	}
	
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				while (mid > 0 && a[mid] == a[mid - 1]) {
					--mid;
				}
				return mid;
			}
		}
		return lo;
	}
	
	public static int count(int key, int[] a) {
		int lo = rank(key, a);
		int idx = lo;
		if (idx == a.length || key != a[idx]) {
			return 0;
		}
		int cnt = 1;
		while ((idx < a.length - 1) && (a[idx] == a[idx + 1])) {
			++cnt;
			++idx;
		}
		return cnt;
	}
}
