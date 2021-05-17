package chapterone.three;

/**
 * 文本编辑器的缓冲区
 * @author gxx
 *
 */

/*
 * ------------------------------------------------------------
 * 	public class Buffer
 * ------------------------------------------------------------
 * 		Buffer()					创建一块空缓冲区
 * 		void insert(char c)			在光标位置插入字符c
 * 		char delete()				删除并返回光标位置的字符
 * 		void left(int k)			将光标向左移动k个位置
 * 		void right(int k)			将光标向右移动k个位置
 * 		int size()					缓冲区中的字符数量
 */

public class Buffer {

	private Stack<Character> ms;
	private Stack<Character> as;
	private int size;
	
	public Buffer() {
		ms = new Stack<Character>();
		as = new Stack<Character>();
		size = 0;
	}
	
	public void insert(char c) {
		ms.push(c);
		size++;
	}
	
	public char delete() {
		char c = ms.pop();
		size--;
		return c;
	}
	
	/**
	 * 不考虑k超出边界问题
	 * @param k
	 */
	public void left(int k) {
		for (int i = 0; i < k; i++) {
			char c = ms.pop();
			as.push(c);
		}
	}
	
	public void right(int k) {
		for (int i = 0; i < k; i++) {
			char c = as.pop();
			ms.push(c);
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (Character c : ms) {
			s += c;
		}
		String ans = "";
		for (int i = s.length()-1; i > -1; i--) {
			ans += s.charAt(i);
		}
		s = "";
		for (Character c: as) {
			s += c;
		}
		for (int i = s.length()-1; i > -1; i--) {
			ans += s.charAt(i);
		}
		return ans;
	}
}
