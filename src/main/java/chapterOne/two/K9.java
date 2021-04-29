package chapterone.two;

/**
 * 
 * @author gxx
 *
 */
public class K9 {

	public static void main(String[] args) {
		int key = 3;
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
		Counter counter = new Counter("binarySearch");
		BinarySearch.rank(key, a, counter);
	}
}
