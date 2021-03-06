package chapterone.one;

public class K18 {

	public static void main(String[] args) {
//		System.out.println(mystery(2, 25));
//		System.out.println(mystery(3, 11));
//		System.out.println(mystery(10, 11));
		System.out.println(mystery2(2, 4));
		System.out.println(mystery2(3, 11));
	}
	
	// == a * b
	public static int mystery(int a, int b) {
		if (b == 0) {
			return 0;
		}
		if (b % 2 == 0) {
			return mystery(a + a, b / 2);
		}
		return mystery(a + a, b / 2) + a;
	}
	
	// == Math.pow(a, b)
	public static int mystery2(int a, int b) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 0) {
			return mystery2(a * a, b / 2);
		}
		return mystery2(a * a, b / 2) * a;
	}
}
