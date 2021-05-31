package chapterone.five;

public class K8 {

	public static void main(String[] args) {
		/*
		 * id[p] = 2
		 * id[q] = 4
		 * 
		 * Array
		 * 	0 1 2 2 4 2 6
		 * 
		 * 0 != 2, is not updated
		 * 1 != 2, is not updated
		 * 2 == 2， is updated to 4 (after this, all comparisons are incorrectly made with 4 instead of 2)
		 * 2 != 4, in not updated (are should have been updated)
		 * 4 == 4, in updated to 4(again)
		 * 2 != 4  in not updated (are should have been updated)
		 * 6 != 4 is not updated
		 */
	}
}
