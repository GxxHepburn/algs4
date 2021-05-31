package chapterone.five;

public class K6 {

	public static void main(String[] args) {
		/*
		 * M: 10^6 N: 10^9
		 * 每次输入union,最大循环次数为2*lgN
		 * 每次迭代需10条指令
		 * 一共需要2*lgN*10条指令
		 * 一共进行M次union操作
		 *  供需M*2*lgN*10条指令
		 * 计算器每秒执行N条指令
		 * 共需执行M*2*lgN*10/N 秒 约等于0.6s
		 */
	}
}
