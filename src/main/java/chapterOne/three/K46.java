package chapterone.three;

/*
 * P(3，3) = 3! = 3*2*1 = 6
 * 1 2 3	1入栈，出栈2入栈，出栈，3入栈出栈	小中大
 * 1 3 2 	1入栈，出栈2入栈3入栈，出栈，出栈	小大中
 * 2 1 3	1入栈2入栈，出栈，出栈	3入栈出栈	中小大
 * 2 3 1	1入栈2入栈，出栈 3入栈，出栈，出栈 	中大小
 * 3 2 1	1入栈2入栈3入栈，出栈，出栈，出栈 	大中小
 * 3 1 2 	1入栈2入栈3入栈，出栈，出栈----出错，此时时2不是1
 */
public class K46 {

	public static void main(String[] args) {
		
	}
}
