package chapterone.four;

public class K26 {

	public static void main(String[] args) {
		/*
		 * (a, a^3) (b, b^3) (c, c^)在同一条线上
		 * （b^3 - a^3) / (b - a) == (c^3 - b^3) / (c - b)
		 *  b^2 + a * b + a^2 == c^2 + b * c + b^2
		 *  a * b + a^2 == b * c + c^2
		 *  a * (a + b) == c * (b + c)
		 *  
		 *  假设a + b + c = T != 0
		 *  a * (T - c) == c * (T - a)
		 *  a * T == c * T
		 *  a == c
		 *  不成立
		 *  所以T == 0
		 */
	}
}
