package chapterone.one;

public class K17 {

	public static void main(String[] args) {
		
	}
	
	public static String exR2(int n) {
		String string = exR2(n - 3) + n + exR2(n - 2) + n;
		// 下面的代码永远不会执行，最后造成StackOverflowError
		if (n <= 0) {
			return "";
		}
		return string;
	}
}
