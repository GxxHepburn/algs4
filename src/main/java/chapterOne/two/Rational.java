package chapterone.two;

public class Rational {

	private final long number;
	private final long denominator;
	
	/**
	 * 先考虑极端输入
	 * 分子	分母
	 * *	0	不合法
	 * 0	！0	不用做任何处理
	 * ！0	！0	分子分母约分
	 * @param number
	 * @param denominator
	 */
	public Rational(long number, long denominator) {
		// K17断言
		assert(denominator() < Integer.MAX_VALUE && denominator() > Integer.MIN_VALUE);
		assert(number() < Integer.MAX_VALUE && number() > Integer.MIN_VALUE);
		if (denominator == 0) {
			throw new RuntimeException("Denominator is zero");
		}
		long g = gcd(number, denominator);
		// 符号转移到分子
		if (denominator < 0) {
			g = -g;
		}
		this.number = number / g;
		this.denominator = denominator / g;
	}
	
	/**
	 * 欧几里得算法求最大公约数
	 * @param p
	 * @param q
	 * @return
	 */
	private static long gcd(long p, long q) {
		if (q == 0) {
			return p;
		}
		long r = p % q;
		return gcd(q, r);
	}
	
	/**
	 * @return
	 */
	public long denominator() {
		return denominator;
	}
	
	/**
	 * @return
	 */
	public long number() {
		return number;
	}
	
	/**
	 * 有理数相加
	 * @param b
	 * @return
	 */
	public Rational plus(Rational b) {
		// K17断言
		assert(denominator()*b.denominator() < Integer.MAX_VALUE && denominator()*b.denominator() < Integer.MIN_VALUE);
		assert((denominator()*b.number() + number()*b.denominator()) < Integer.MAX_VALUE && (denominator()*b.number() + number()*b.denominator()) > Integer.MIN_VALUE) ;
		long d = denominator() * b.denominator();
		long n = number() * b.denominator() + denominator() * b.number();
		return new Rational(n, d);
	}
	
	/**
	 * 有理数相减
	 * @param b
	 * @return
	 */
	public Rational minus(Rational b) {
		long d = denominator * b.denominator();
		long n = number() * b.denominator() - denominator() * b.number();
		return new Rational(n, d);
	}
	
	/**
	 * 有理数之积
	 * @param b
	 * @return
	 */
	public Rational times(Rational b) {
		long d = denominator * b.denominator();
		long n = number() * b.number();
		return new Rational(n, d);
	}
	
	/**
	 * 有理数之商
	 * @param b
	 * @return
	 */
	public Rational divides(Rational b) {
		if (b.number() == 0) {
			throw new RuntimeException("Denominator is zero");
		}
		long d = denominator * b.number();
		long n = number() * b.denominator();
		return new Rational(n, d);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Rational that = (Rational) obj;
		if (this.number() == 0 && that.number() == 0) {
			return true;
		}
		if (this.number() != that.number() || this.denominator() != that.denominator()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return number() + " / " + denominator();
	}
}
