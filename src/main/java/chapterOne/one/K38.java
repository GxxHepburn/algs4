package chapterOne.one;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K38 {

	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss SSS");
		
		int[] whitelist = In.readInts(args[0]);
		int[] list = In.readInts(args[1]);
		
		// 二分法
		Date dateBs = new Date();
		StdOut.println("二分法开始时间: " + simpleDateFormat.format(dateBs));
		for (int i = 0; i < list.length; i++) {
			if (binarySearch(list[i], whitelist) < 0) {
//				StdOut.println(list.get(i));
			}
		}
		Date dateBe = new Date();
		StdOut.println("二分法结束时间: " + simpleDateFormat.format(dateBe));
		StdOut.println("二分法持续时间毫秒: " + (dateBe.getTime() - dateBs.getTime()));
		
		
		// 暴力方法
		Date dateBFs = new Date();
		StdOut.println("暴力法法开始时间: " + simpleDateFormat.format(dateBFs));
		for (int i = 0; i < list.length; i++) {
			if (bruteForeceSearch(list[i], whitelist) < 0) {
//				StdOut.println(list.get(i));
			}
		}
		Date dateBFe = new Date();
		StdOut.println("暴力法结束时间: " + simpleDateFormat.format(dateBFe));
		StdOut.println("暴力法持续时间毫秒: " + (dateBFe.getTime() - dateBs.getTime()));
	}
	
	/**
	 * 二分查找
	 * @param key
	 * @param a
	 * @return
	 */
	public static int binarySearch(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * 暴力查找
	 * @param key
	 * @param a
	 * @return
	 */
	public static int bruteForeceSearch(int key, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (key == a[i]) {
				return i;
			}
		}
		return -1;
	}
}
