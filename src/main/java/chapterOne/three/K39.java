package chapterone.three;

import edu.princeton.cs.algs4.StdOut;

public class K39 {

	public static void main(String[] args) {
		int capacity = 10;
		RingBuffer<String> ringBuffer = new RingBuffer<String>(capacity);
		
		/****************测试用例1***************/
		for (int i = 0; i < capacity; i++) {
			String inputItem = i + "";
			boolean putSuccess = ringBuffer.put(inputItem);
			StdOut.println(putSuccess ? "插入 " + inputItem + " 成功" : "插入 " + inputItem + "失败");
		}
		
		/*****************测试用例2*****************/
		for (int i = 0; i < capacity+1; i++) {
			if (i == capacity - 1) {
				String takeItem = ringBuffer.take();
				StdOut.println("取出 " + takeItem + " 成功");
			}
			if (i == capacity) {
				String takeItem = ringBuffer.take();
				StdOut.println("取出 " + takeItem + " 成功");
			}
			String inputItem = i + "";
			boolean putSuccess = ringBuffer.put(inputItem);
			StdOut.println(putSuccess ? "插入 " + inputItem + " 成功" : "插入 " + inputItem + "失败");
		}
	}
}
