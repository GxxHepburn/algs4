package chapterone.five;

public class K5 {

	public static void main(String[] args) {
		/*
		 * M:10^6	N:10^9
		 * quick_find算法每次union都需要遍历一次数组，共需迭代N次
		 * 每次for迭代需要10条机器指令，共需10*N条指令，
		 * 一共有M条union操作
		 * 	共需10*N*M条指令
		 * 计算机每秒执行N条指令
		 * 	供需执行10M 秒
		 * 约等于10^7/60/60/24=115.74天
		 */
	}
}
