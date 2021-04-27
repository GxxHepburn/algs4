package chapterOne.two;

public class Test {

	public static void main(String[] args) {
		String s = "123";
		System.out.println(s.charAt(1));
		
		System.out.println(s.getClass());
		s.toString();
		System.out.println(s == "123");
		assert s == "13" : "test----------";
	}
}
