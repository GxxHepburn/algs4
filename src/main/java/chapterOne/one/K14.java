package chapterOne.one;

public class K14 {

	public static void main(String[] args) {
		System.out.println(lg2(4));
	}
	
	public static int lg(int N) {
		int a = 0;
		int s = 1;
		while (s <= N) {
			if (s == N) {
				return a;
			}
			s *= 2;
			a++;
		}
		return a-1;
	}
	
	public static int lg2(int N) {
		int shiftRightCount = 0;
		do {
			N >>= 1;
			shiftRightCount++;
		} while (N != 0);
		return shiftRightCount - 1;
	}
}
