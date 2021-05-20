package chapterone.four;

import edu.princeton.cs.algs4.StdOut;

public class K19 {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 11,  33,  3,  2, 102 }, 
                { 53,  6,  7, 18, 101 },
                { 12, 11, 10, 89, 100 }, 
                { 14,  1,  8,  5,   0 },
                { 114,51, 58, 55,  99 }
		};
		int[] ans = min(matrix, 0, matrix[0].length-1, 0, matrix.length-1, true);
		StdOut.println(ans[0] + " "  + ans[1] + " " + matrix[ans[0]][ans[1]]);
	}
	
	/*
	 * direction:true找中间行
	 * 		false找中间列
	 */
	public static int[] min(int[][] matrix, int left, int right, int top, int bottom, boolean direction ) {
		if (direction) {
			int row = top + (bottom - top) / 2;
			int min = matrix[row][left];
			int index = 0;
			for (int i = left; i <= right; i++) {
				if (matrix[row][i] < min) {
					min = matrix[row][i];
					index = i;
				}
			}
			int first = matrix[row-1<top ? row : row-1][index];
			int second = matrix[row+1>bottom? row : row+1][index];
			if (first >= matrix[row][index] && second >= matrix[row][index]) {
				int[] ans = new int[2];
				ans[0] = row;
				ans[1] = index;
				return ans;
			} else if (first < matrix[row][index]) {
				return min(matrix, left, right, top, row-1, !direction);
			} else {
				return min(matrix, left, right, row+1, bottom, direction);
			}
		} else {
			int col = left + (right - left) / 2;
			int min = matrix[bottom][col];
			int index = 0;
			for (int i = top; i <= bottom; i++) {
				if (matrix[i][col] < min) {
					min = matrix[i][col];
					index = i;
				}
			}
			int first = matrix[index][col-1<left ? col : col-1];
			int second = matrix[index][col+1>right ? col : col+1];
			if (first >= matrix[index][col] && second >= matrix[index][col]) {
				int[] ans = new int[2];
				ans[0] = index;
				ans[1] = col;
				return ans;
			} else if (first < matrix[index][col]) {
				return min(matrix, left, col-1, top, bottom, !direction);
			} else {
				return min(matrix, col+1, right, top, bottom, direction);
			}
		}
	}
}
