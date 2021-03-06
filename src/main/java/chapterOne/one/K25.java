package chapterone.one;

public class K25 {

	public static void main(String[] args) {
//		数学归纳法证明
//		基础步骤：
//		若q = 0，则 gcd(p, q) = gcd(p, 0) = p。
//
//		归纳步骤：
//		令 p = a * q + r， 其中 p、a、q、r 均为非负整数。
//
//		设 d 整除 p 和 q， 则 d 可以整除 p - a * q = r，即 p / d = a*q / d + r / d 。
//
//		此时， d 为 p，q 的公约数，且 d 为 q，r 的公约数，即 p 和 q 的公约数 = q 和 r 的公约数 = d 。
//
//		也即 gcd(p, q) = gcd(q, r) , 其中 r 为 p 除以 q 的余数。
//
//		不断归纳，直至函数 gcd 的第二个参数为0，此时得到基础步骤。
//
//		此时我们已经证明了最终的结果是 p 和 q 的一个约数。
//
//		然而这还没完，因为我们只证明了最终结果是一个公约数，但没有证明它是最大的公约数。
//
//		因为 d 整除 p 和 q，可得 d 整除 p - a * q = r, 因此 p 和 q 的任意约数也为 q 和 r 的约数；
//
//		同理，d整除 q 和 r， 可得 d 整除 a * q + r = p， 因此q 和 r 的任意约数也为 p 和 q 的约数。
//
//		综上，p 和 q 的约数集等于 q 和 r 的约数集。
//		
//		接下来由递推法：
//
//		假定当函数gcd()的第二个参数为0时，第一个参数为m，可得 p 和 q 的约数集与 m 和 0 的约数集相同。
//
//		由数学归纳法的基础情况知， 而 m 和 0 的最大公约数为 m， 即 m 和 0 的约数集的最大值为 m，
//
//		由此可得 p 和 q 的约数集的最大值也为 m 。
//
//		综上，欧几里得算法得证。
	}
}
