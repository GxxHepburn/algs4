package chapterone.one;

public class K15 {

	public static void main(String[] args) {
		int[] a = {0, 1, 2, 2, 2, 5, 6};
		int M = 7;
		int[] b = histogram(a, M);
		for (int i = 0; i < M; i++) {
			System.out.println(b[i]);
		}
	}
	
	public static int[] histogram(int[] a, int M) {
		int[] b = new int[M];
		for (int i = 0; i < a.length; i++)  {
			if (a[i] < M && a[i] > -1) {
				b[a[i]]++;
			}
		}
		return b;
	}
}
