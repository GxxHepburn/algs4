package chapterone.one;

public class K13 {

	public static void main(String[] args) {
		int M = 2;
		int N = 3;
		int[][] a = new int[M][N];
		int[][] b = new int[N][M];
		int s = 0;
		for (int i = 0;  i < M; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = s;
				s++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				b[i][j] = a[j][i];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}
}
