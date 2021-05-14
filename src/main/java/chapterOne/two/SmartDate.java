package chapterone.two;

import chapterone.three.Bag;
import edu.princeton.cs.algs4.StdIn;

public class SmartDate {

	private final int month;
	private final int day;
	private final int year;
	
	private final String Monday = "Monday";
	private final String Tuesday = "Tuesday";
	private final String Wednesday = "Wednesday";
	private final String Thursday= "Thursday";
	private final String Friday = "Friday";
	private final String Saturday = "Saturday";
	private final String Sunday = "Sunday";
	
	/**
	 * 日期非法时，抛出异常
	 * @param m
	 * @param d
	 * @param y
	 */
	public SmartDate(int m, int d, int y) {
		// 检查日期是否正确
		if (!judge(m, d, y)) {
			throw new RuntimeException();
		}
		month = m;
		day = d;
		year = y;
	}
	
	/**
	 * K19
	 * 字符串格式日期
	 * @param date
	 */
	public SmartDate(String date) {
		String[] fields = date.split("/");
		int m = Integer.parseInt(fields[0]);
		int d = Integer.parseInt(fields[1]);
		int y = Integer.parseInt(fields[2]);
		if (!judge(m, d, y)) {
			throw new IllegalArgumentException("Argument illegal " + m + "/" + d + "/" + y);
		}
		this.month = m;
		this.day = d;
		this.year = y;
	}
	
	/**
	 * 判断SmartDate对象是否合法
	 * @param that
	 * @return
	 */
	private boolean judge(SmartDate that) {
		int month = that.month();
		int year = that.year();
		int day = that.day();
		return judge(month, day, year);
	}
	
	/**
	 * 判断年月日参数是否合法
	 * @param m
	 * @param d
	 * @param y
	 * @return true合法，false非法
	 */
	private boolean judge(int m, int d, int y) {
		boolean res = true;
		if (m < 1 || d < 1 || y < 0) {
			res = false;
			return res;
		}
		if (m<1 || m>12) {
			res = false;
		} else if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
			if (d > 31) {
				res = false;
			}
		} else if (m == 2) {
			if (y%400==0 || (y%4==0&&y%100!=0)) {
				if (d > 29) {
					res = false;
				}
			} else {
				if (d > 28) {
					res = false;
				}
			}
		} else {
			if (d > 30) {
				res = false;
			}
		}
		return res;
	}
	
	public int month() {
		return month;
	}

	public int day() {
		return day;
	}
	
	public int year() {
		return year;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	/**
	 * 日期非法时，抛出异常
	 */
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
		SmartDate that = (SmartDate) obj;
		if (!judge(that)) {
			throw new RuntimeException();
		}
		if (this.day != that.day) {
			return false;
		}
		if (this.month != that.month) {
			return false;
		}
		if (this.year != that.year) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
	
	/**
	 * 日期非法时，抛出异常
	 * @param that
	 * @return
	 */
	public int compareTo(Object obj) {
		if (this == obj) {
			return 0;
		}
		if (obj == null) {
			throw new RuntimeException();
		}
		if (this.getClass() != obj.getClass()) {
			throw new RuntimeException();
		}
		SmartDate that = (SmartDate) obj;
		if (!judge(that)) {
			throw new RuntimeException();
		}
		if (year() < that.year()) {
			return -1;
		} else if (year() > that.year()) {
			return 1;
		} else {
			if (month() < that.month()) {
				return -1;
			} else if (month() > that.month()) {
				return 1;
			} else {
				if (day() < that.day()) {
					return -1;
				} else if (day() > that.day()) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
	
	public String dayOfTheWeek() {
		int m = month();
		int d = day();
		int y = year();
		if (m==1 || m==2) {
			m += 12;
			y--;
		}
		int iWeek = (d + 2*m + 3*(m+1)/5 + y + y/4 - y/100 + y/400) % 7;
		String sWeek = null;
		switch (iWeek) {
			case 0: {
				sWeek = Monday;
				break;
			}
			case 1: {
				sWeek = Tuesday;
				break;
			}
			case 2: {
				sWeek = Wednesday;
				break;
			}
			case 3: {
				sWeek = Thursday;
				break;
			}
			case 4: {
				sWeek = Friday;
				break;
			}
			case 5: {
				sWeek = Saturday;
				break;
			}
			case 6: {
				sWeek = Sunday;
				break;
			}
		}
		return sWeek;
	}
	
	/**
	 * K16
	 * @return
	 */
	public static SmartDate[] readDates() {
		Bag<String> bag = new Bag<String>();
		while (!StdIn.isEmpty()) {
			String dateString = StdIn.readString();
			bag.add(dateString);
		}
		SmartDate[] dates = new SmartDate[bag.size()];
		int index = 0;
		for (String string : bag) {
			dates[index++] = new SmartDate(string);
		}
		return dates;
	}
}
