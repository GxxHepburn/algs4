package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class K12 {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b= {2, 4, 6};
		printPublicSort(a, b);
	}
	
	/*
	 * a和b的大小相同
	 */
	public static void printPublicSort(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		while (j+i < a.length*2-1) {
			if (a[i] == b[j]) {
				StdOut.println(a[i]);
				if (i == a.length - 1) {
					j++;
				}
				i++;
			} else if (a[i] < b[j]) {
				if (i == a.length - 1) {
					break;
				}
				i++;
			} else if (a[i] > b[j]) {
				if (j == a.length - 1) {
					break;
				}
				j++;
			}
		}
	}
}
