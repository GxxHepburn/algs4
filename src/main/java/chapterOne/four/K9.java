package chapterone.four;

public class K9 {

	public static void main(String[] args) {
		/*
		 * 	Example:
		 * 		T(16) = ?
		 * 		T(2) = T(1) * 2^b
		 * 		T(4) = T(2) * 2^b
		 * 		T(8) = T(4) * 2^b
		 * 		etc
		 * 
		 * so, we have that
		 * 	T(16) = T(1) * 2^b * 2^b * 2^b  * 2^b
		 * 	which is equal to:
		 * 	T(16) = T(1) * ((2^b)^lgN)
		 * 
		 * For a problem of size N:
		 * 	T(N0) = T = T * 1^b
		 * 	T(2*N0) = T * ((2^b)^lg2) = T * 2^b
		 * 	...
		 * 	T(16*N0) = T * 2^b * 2^b  * 2^b  * 2^b = T * ((2^b)^lg16) = T * 16^b 
		 * 
		 * Thus, we have:
		 * 	T(N) = T * (N/N0)^b
		 * 
		 * 注意：
		 * 	这里的N是N0的2的n次方倍
		 */
	}
}
