package chapterone.two;

public class K17 {

	public static void main(String[] args) {
		Rational r1 = new Rational(1, 1000000000);
        Rational r2 = new Rational(1, 1000000001);
        Rational r = new Rational(1, 1000000002);
        System.out.println(r1.plus(r2).plus(r));
	}
}
