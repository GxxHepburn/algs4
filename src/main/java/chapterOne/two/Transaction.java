package chapterone.two;

import java.util.Date;

import chapterone.three.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Transaction {

	private final String who;
	private final Date when;
	private final double amount;
	
	
	
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	/**
	 * K19
	 * @param trans
	 */
	public Transaction(String trans) {
		String[] fields = trans.split(" ");
		String wo = fields[0];
		String we = fields[1];
		String a = fields[2];
		
		String[] dates = we.split("/");
		int m = Integer.parseInt(dates[0]);
		int d = Integer.parseInt(dates[1]);
		int y = Integer.parseInt(dates[2]);
		Date whe = new Date(y, m, d);
		double am = Double.parseDouble(a);
		
		this.who = wo;
		this.when = whe;
		this.amount = am;
	}
	
	public String who() {
		return who;
	}
	
	public Date when() {
		return when;
	}
	
	public double amount() {
		return amount;
	}

	@Override
	public String toString() {
		return who() + ", " + when() + ", " + amount();
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
		Transaction that = (Transaction) obj;
		if (!who.equals(that.who())) {
			return false;
		}
		if (!when.equals(that.when())) {
			return false;
		}
		// 注意这里that.amount可以访问，但是建议使用amount()，这里这么做是为了说明可以做到直接访问
		if (amount != that.amount) {
			return false;
		}
		return true;
	}
	
	/**
	 * K17
	 * @return
	 */
	public static Transaction[] readTransactions() {
		Queue<String> queue = new Queue<String>();
		String trans = "";
		int t = 0;
		while (!StdIn.isEmpty()) {
			String tsstr = StdIn.readString();
			if (++t % 3 == 0) {
				trans += tsstr;
				queue.enqueue(trans);
				trans = "";
			} else {
				trans += tsstr + " ";
			}
		}
		Transaction[] tses = new Transaction[queue.size()];
		int index = 0;
		for (String str : queue) {
			tses[index++] = new Transaction(str);
		}
		return tses;
	}
}
