package chapterone.one;

public class K20 {

	public static void main(String[] args) {
		System.out.println(ln(3));
	}
	
	public static double  ln(int N) {
		if (N == 1) {
			return 0;
		}
		return Math.log(N) + ln(N-1);
	}
}
